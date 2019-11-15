package com.ssafy.controller;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.model.Allergy;
import com.ssafy.model.Food;
import com.ssafy.model.Ingestion;
import com.ssafy.model.Likes;
import com.ssafy.model.Material;
import com.ssafy.model.Member;
import com.ssafy.model.Nutrition;
import com.ssafy.service.AllergyService;
import com.ssafy.service.FoodService;
import com.ssafy.service.LikesService;

@Controller
public class LikesController {
	
	@Autowired
	private LikesService likesService;
	
	@Autowired
	private FoodService foodService;
	
	@Autowired
	private AllergyService allergyService;
	
	@RequestMapping("addLikes.do")
	public ModelAndView addLikes(HttpServletRequest request, HttpServletResponse response, String foodName) throws Exception{
		
		Member m = (Member)request.getSession().getAttribute("member");
		String id = m.getId();		
		Food food = foodService.getFoodInfo(foodName);
		Likes likes = new Likes(id, food, 1);
		int re = likesService.updateLikesUp(likes);
		
		if(re == 0) {
			likesService.addLikes(likes);
		}
		return new ModelAndView("redirect:getAllFood.do");
	}
	
	@RequestMapping("updateLikesQuantity.do")
	public ModelAndView updateLikesQuantity(HttpServletRequest request, HttpServletResponse response, String foodName, int quantity) throws Exception{
		
		Member member = (Member)request.getSession().getAttribute("member");
		String id = member.getId();
		Food food = foodService.getFoodInfo(foodName);
		
		Likes l = likesService.selectLikes(new Likes(id , food, 0));
		if(l == null) {
			likesService.addLikes(new Likes(id, food, quantity));
		}else {
			System.out.println("1번 확인!");
			l.setQuantity(l.getQuantity()+quantity);
			likesService.updateLikesQuantity(l);
			System.out.println("2번 확인!");
		}
		
		request.getSession().setAttribute("foodName", foodName);
		return new ModelAndView("redirect:getFoodInfo.do");
	}
	
	@RequestMapping("updateLikesRowQuantity.do")
	public ModelAndView updateRowQuantity(HttpServletRequest request, HttpServletResponse response, HttpSession session, String foodName, int quantity) throws Exception{
		Likes likes = new Likes();
		likes.setId(((Member)session.getAttribute("member")).getId());
		likes.setFoodName(foodName);
		likes.setQuantity(quantity);
		
		likesService.updateLikesQuantity(likes);
		
		return new ModelAndView("redirect:likesInfo.do");
	}
	
	@RequestMapping("updateLikesDown.do")
	public ModelAndView updateLikesDown(HttpServletRequest request, HttpServletResponse response, Likes likes) throws Exception{
		likesService.updateLikesDown(likes);
		return new ModelAndView("mylikes");
	}
	
	@RequestMapping("updateLikesUp.do")
	public ModelAndView updateLikesUp(HttpServletRequest request, HttpServletResponse response, Likes likes) throws Exception{
		likesService.updateLikesUp(likes);
		return new ModelAndView("mylikes");
	}
	
	@RequestMapping("selectLikes.do")
	public ModelAndView selectLikes(HttpServletRequest request, HttpServletResponse response, Likes likes) throws Exception{
		Likes rvo = likesService.selectLikes(likes);
		return new ModelAndView("mylikes","vo",rvo);
	}
	
	@RequestMapping("likesInfo.do")
	public ModelAndView selectLikesById(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Member member = (Member)(request.getSession().getAttribute("member"));
		String id = member.getId();
		String foodName = "";
		int q = 0;
		double serve = 0;
		double cal = 0;
		double carbo = 0;
		double protein = 0;
		double fat = 0;
		double sugars = 0;
		double natrium = 0;
		double cholesterol = 0;
		double fatacid = 0;
		double transfat = 0;
		Nutrition n = null;
		List<Likes> iList = likesService.selectLikesById(id);
		List<Allergy> allergies = allergyService.getAllergy(id);
		List<Material> materials = null;
		HashSet<Material> mSet = new HashSet<>();
		for(Likes i : iList) {
			foodName = i.getFood().getFoodName();
			if(allergies.size() != 0) { // 알러지가 있을때만
				materials = foodService.getMaterial(foodName); // 추가한 음식마다 재료들 다 들고 오고
				for(Material m : materials) { // 재료들중에서 
					for(Allergy a : allergies) { // 알러지랑 체크해서 
						if(m.getMat().contains(a.getAllergyMat())) { // 재료가 알러지 재료 포함하면
							m.setFoodName(foodName);
							mSet.add(m);  // 셋에 추가
						}
					}
				}
			}
			i.setFood(foodService.getFoodInfo(foodName));
			q = i.getQuantity();
			n = foodService.getNutrition(foodName);
			serve += n.getDailyServing() * q;
			cal += n.getCallory() * q;
			carbo += n.getCarbo() * q;
			protein += n.getProtein() * q;
			fat += n.getFat() * q;
			sugars += n.getSugars() * q;
			natrium += n.getNatrium() * q;
			cholesterol += n.getCholesterol() * q;
			fatacid += n.getSaturatedFattyAcid() * q;
			transfat += n.getTransFat() * q;
		}
		Nutrition nutrition = new Nutrition(""
				,Double.parseDouble(String.format("%.2f", serve))
				,Double.parseDouble(String.format("%.2f", cal))
				,Double.parseDouble(String.format("%.2f", carbo))
				,Double.parseDouble(String.format("%.2f", protein))
				,Double.parseDouble(String.format("%.2f", fat))
				,Double.parseDouble(String.format("%.2f", sugars))
				,Double.parseDouble(String.format("%.2f", natrium))
				,Double.parseDouble(String.format("%.2f", cholesterol))
				,Double.parseDouble(String.format("%.2f", fatacid))
				,Double.parseDouble(String.format("%.2f", transfat)));
		System.out.println(iList.toString());
		System.out.println(nutrition.toString());
		request.setAttribute("mSet", mSet);
		request.setAttribute("total", nutrition);
		return new ModelAndView("mylikes","likesList",iList);
	}
	
	@RequestMapping("deleteLikes.do")
	public ModelAndView deleteLikes(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Member m = (Member)request.getSession().getAttribute("member");
		String id = m.getId();
		String[] fName = request.getParameterValues("deleteCheck");
		if(fName != null) {
			Food food = null;
			Likes likes = null;
			for(String f : fName) {
				food = foodService.getFoodInfo(f);
				likes = new Likes(id, food, 0);
				likesService.deleteLikes(likes);
			}
		}

		return new ModelAndView("redirect:likesInfo.do");
	}
}
