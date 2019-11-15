package com.ssafy.controller;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.model.Allergy;
import com.ssafy.model.Best;
import com.ssafy.model.Food;
import com.ssafy.model.Ingestion;
import com.ssafy.model.Likes;
import com.ssafy.model.Material;
import com.ssafy.model.Member;
import com.ssafy.model.Nutrition;
import com.ssafy.service.AllergyService;
import com.ssafy.service.BestService;
import com.ssafy.service.FoodService;
import com.ssafy.service.IngestionService;

@Controller
public class IngestionController {
	
	@Autowired
	private IngestionService ingestionService;
	
	@Autowired
	private FoodService foodService;
	
	@Autowired
	private AllergyService allergyService;
	
	@Autowired
	private BestService bestService;
	
	@RequestMapping("addIngestion.do")
	public ModelAndView addIngestion(HttpServletRequest request, HttpServletResponse response, String foodName) throws Exception{
		
		Member m = (Member)request.getSession().getAttribute("member");
		String id = m.getId();		
		Food food = foodService.getFoodInfo(foodName);
		Ingestion ingestion = new Ingestion(id, food, 1);
		int re = ingestionService.updateIngestionUp(ingestion);
		
		if(re == 0) {
			ingestionService.addIngestion(ingestion);
		}
		re = bestService.updateBestUp(ingestion);
		if(re == 0) {
			bestService.addBest(ingestion);
		}
		
		
		return new ModelAndView("redirect:getAllFood.do");
	}
	
	@RequestMapping("updateIngestionQuantity.do")
	public ModelAndView updateIngestionQuantity(HttpServletRequest request, HttpServletResponse response, String foodName, int quantity) throws Exception{
		Member member = (Member)request.getSession().getAttribute("member");
		String id = member.getId();
		Food food = foodService.getFoodInfo(foodName);
		
		Ingestion i = ingestionService.selectIngestion(new Ingestion(id, food, 0));
		if(i == null) {
			ingestionService.addIngestion(new Ingestion(id, food, quantity));
		}else {
			i.setQuantity(i.getQuantity()+quantity);
			ingestionService.updateIngestionQuantity(i);
		}
		int re = bestService.updateBestUp(new Ingestion(id, food, 0));
		if(re == 0) {
			bestService.addBest(new Ingestion(id, food, quantity));
		}
		
		return new ModelAndView("redirect:getFoodInfo.do?foodName="+URLEncoder.encode(foodName, "UTF-8"));
	}
	
	@RequestMapping("updateIngestionRowQuantity.do")
	public ModelAndView updateRowQuantity(HttpServletRequest request, HttpServletResponse response, HttpSession session, String foodName, int quantity) throws Exception{
		Ingestion ingestion = new Ingestion();
		ingestion.setId(((Member)session.getAttribute("member")).getId());
		ingestion.setFoodName(foodName);
		ingestion.setQuantity(quantity);
		
		ingestionService.updateIngestionQuantity(ingestion);
		
		return new ModelAndView("redirect:ingestionInfo.do");
	}
	
	@RequestMapping("updateIngestionDown.do")
	public ModelAndView updateIngestionDown(HttpServletRequest request, HttpServletResponse response, Ingestion ingestion) throws Exception{
		ingestionService.updateIngestionDown(ingestion);
		return new ModelAndView("myingestion");
	}
	
	@RequestMapping("updateIngestionUp.do")
	public ModelAndView updateIngestionUp(HttpServletRequest request, HttpServletResponse response, Ingestion ingestion) throws Exception{
		ingestionService.updateIngestionUp(ingestion);
		return new ModelAndView("myingestion");
	}
	
	@RequestMapping("selectIngestion.do")
	public ModelAndView selectIngestion(HttpServletRequest request, HttpServletResponse response, Ingestion ingestion) throws Exception{
		Ingestion rvo = ingestionService.selectIngestion(ingestion);
		return new ModelAndView("myingestion","vo",rvo);
	}
	
	@RequestMapping("ingestionInfo.do")
	public ModelAndView selectIngestionById(HttpServletRequest request, HttpServletResponse response) throws Exception{
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
		List<Ingestion> iList = ingestionService.selectIngestionById(id);
		List<Allergy> allergies = allergyService.getAllergy(id);
		List<Material> materials = null;
		HashSet<Material> mSet = new HashSet<>();
		for(Ingestion i : iList) {
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
		Nutrition nutrition = new Nutrition("",Double.parseDouble(String.format("%.2f",serve))
				,Double.parseDouble(String.format("%.2f",cal))
				,Double.parseDouble(String.format("%.2f",carbo))
				,Double.parseDouble(String.format("%.2f",protein))
				,Double.parseDouble(String.format("%.2f",fat))
				,Double.parseDouble(String.format("%.2f",sugars))
				,Double.parseDouble(String.format("%.2f",natrium))
				,Double.parseDouble(String.format("%.2f",cholesterol))
				,Double.parseDouble(String.format("%.2f",fatacid))
				,Double.parseDouble(String.format("%.2f",transfat)));
		System.out.println(iList.toString());
		System.out.println(nutrition.toString());
		request.setAttribute("mSet", mSet);
		request.setAttribute("total", nutrition);
		request.setAttribute("ingestionList", iList);
		return new ModelAndView("myingestion");
	}
	
	@RequestMapping("deleteIngestion.do")
	public ModelAndView deleteIngestion(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Member m = (Member)request.getSession().getAttribute("member");
		String id = m.getId();
		String[] fName = request.getParameterValues("deleteCheck");
		if(fName != null) {
			Food food = null;
			Ingestion ingestion = null;
			for(String f : fName) {
				food = foodService.getFoodInfo(f);
				ingestion = new Ingestion(id, food, 0);
				ingestionService.deleteIngestion(ingestion);
			}
		}
		return new ModelAndView("redirect:ingestionInfo.do");
	}
	
	@RequestMapping("best.do")
	public ModelAndView selectBestLimit(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Member member = (Member)request.getSession().getAttribute("member");
		String id = member.getId();
		List<Best> bList = bestService.selectBestLimit(id);
		Food food = null;
		for(Best b : bList) {
			food = foodService.getFoodInfo(b.getFoodName());
			b.setImgurl(food.getImgurl());
		}
		return new ModelAndView("best","bestList",bList);
	}
}
