package com.ssafy.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.model.Allergy;
import com.ssafy.model.Food;
import com.ssafy.model.Material;
import com.ssafy.model.Member;
import com.ssafy.model.Nutrition;
import com.ssafy.model.Search;
import com.ssafy.service.AllergyService;
import com.ssafy.service.FoodService;
import com.ssafy.service.SearchService;

@Controller
public class FoodController {

	@Autowired
	private FoodService foodService;

	@Autowired
	private AllergyService allergyService;
	
	@Autowired
	private SearchService searchService;

	@RequestMapping("addFood.do")
	public ModelAndView addFood(HttpServletRequest request, HttpServletResponse response, Food food) throws Exception {
		foodService.addFood(food);
		return new ModelAndView("");
	}

	@RequestMapping("updateFood.do")
	public ModelAndView updateFood(HttpServletRequest request, HttpServletResponse response, Food food)
			throws Exception {
		foodService.updateFood(food);
		return new ModelAndView("");
	}

	@RequestMapping("deleteFood.do")
	public ModelAndView deleteFood(HttpServletRequest request, HttpServletResponse response, String foodName)
			throws Exception {
		foodService.deleteFood(foodName);
		return new ModelAndView("");
	}

	@RequestMapping("searchFood.do")
	public ModelAndView searchFood(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String dir = request.getParameter("location");
		String category = request.getParameter("category");
		String word = request.getParameter("word");
		Member member = (Member)request.getSession().getAttribute("member");
		String id = "none";
		if(member != null) {
			id = member.getId();
		}
		int re = searchService.updateSearch(new Search(id, word, ""));
		if(re == 0) {
			searchService.addSearch(new Search(id, word, ""));
		}
		
		List<Food> foodList = null;

		if (category.equals("foodName")) {
			foodList = foodService.getFoodByName(word);
		} else if (category.equals("maker")) {
			foodList = foodService.getFoodByMaker(word);
		} else if (category.equals("material")) {
			foodList = foodService.getFoodByMaterial(word);
		}

		if (foodList != null) {
			for (Food food : foodList) {
				food.setNutrition(foodService.getNutrition(food.getFoodName()));
				food.setMaterialList(foodService.getMaterial(food.getFoodName()));
			}
		}
		
		ArrayList<String> values = new ArrayList<String>();
		Cookie[] cookies = request.getCookies();
		
		if(cookies.length != 0) {
			for (int i = cookies.length - 1; i >= 0; i--) {
				String key = URLDecoder.decode(cookies[i].getName(), "UTF-8");
				if (key.startsWith("todayList")) {
					values.add(cookies[i].getValue());
				}
			}
		}

		request.setAttribute("todayList", values);

		return new ModelAndView(dir, "foodList", foodList);
	}

	@RequestMapping("getAllFood.do")
	public ModelAndView getAllFood(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		List<Food> fList = foodService.getAllFood();
		List<Material> mList = null;
		for (Food f : fList) {
			mList = foodService.getMaterial(f.getFoodName());
			f.setMaterialList(mList);
		}

		// 브라우저의 쿠키정보를 바탕으로 오늘 본 식품리스트만들기
		ArrayList<String> values = new ArrayList<String>();
		Cookie[] cookies = request.getCookies();
		
		if(cookies.length != 0) {
			for (int i = cookies.length - 1; i >= 0; i--) {
				String key = URLDecoder.decode(cookies[i].getName(), "UTF-8");
				if (key.startsWith("todayList")) {
					values.add(cookies[i].getValue());
				}
			}
		}

		request.setAttribute("todayList", values);

		return new ModelAndView("productInfo", "foodList", fList);
	}

	@RequestMapping("getFoodInfo.do")
	public ModelAndView getFoodInfo(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			String foodName) throws Exception {
		if (foodName == null || foodName.contains("?")) {
			foodName = (String) session.getAttribute("foodName");
		}
		Food f = foodService.getFoodInfo(foodName);
		Nutrition n = foodService.getNutrition(foodName);
		f.setNutrition(n);
		List<Material> mList = foodService.getMaterial(foodName);
		f.setMaterialList(mList);

		// 해당 상품에 대한 쿠키생성
		String key = URLEncoder.encode(foodName, "UTF-8");
		Cookie cookie = new Cookie("todayList" + key, f.getImgurl());
		
		//쿠키 중복 체크
		Cookie[] cookies = request.getCookies();
		for(Cookie c : cookies) {
			
			if(c.getName().equals(cookie.getName())) {
				c.setMaxAge(0);
				response.addCookie(c);
				break;
			}
		}
		
		cookie.setMaxAge(24 * 60 * 60);
		response.addCookie(cookie);

		if (session.getAttribute("member") != null) {
			Member member = (Member) session.getAttribute("member");
			String id = member.getId();
			List<Allergy> aList = allergyService.getAllergy(id);
			HashSet<Material> mSet = new HashSet<>();

			for (Material m : mList) {
				for (Allergy a : aList) {
					if (m.getMat().contains(a.getAllergyMat())) {
						mSet.add(m);
					}
				}
			}
			request.setAttribute("mSet", mSet);
		}

		return new ModelAndView("foodView", "food", f);
	}
}
