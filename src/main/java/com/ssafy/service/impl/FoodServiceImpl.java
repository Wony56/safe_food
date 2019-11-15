package com.ssafy.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dao.FoodDao;
import com.ssafy.model.Food;
import com.ssafy.model.Material;
import com.ssafy.model.Nutrition;
import com.ssafy.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService{
	
	@Autowired
	private FoodDao foodDao;
	
	@Override
	public int addFood(Food food) throws SQLException {
		return foodDao.addFood(food);
	}

	@Override
	public int updateFood(Food food) throws SQLException {
		return foodDao.updateFood(food);
	}

	@Override
	public int deleteFood(String foodName) throws SQLException {
		return foodDao.deleteFood(foodName);
	}

	@Override
	public List<Food> getAllFood() throws SQLException {
		return foodDao.getAllFood();
	}

	@Override
	public List<Material> getMaterial(String foodName) throws SQLException {
		return foodDao.getMaterial(foodName);
	}

	@Override
	public Food getFoodInfo(String foodName) throws SQLException {
		return foodDao.getFoodInfo(foodName);
	}

	@Override
	public Nutrition getNutrition(String foodName) throws SQLException {
		return foodDao.getNutrition(foodName);
	}

	@Override
	public List<Food> getFoodByName(String foodName) throws SQLException {
		return foodDao.getFoodByName(foodName);
	}

	@Override
	public List<Food> getFoodByMaker(String maker) throws SQLException {
		return foodDao.getFoodByMaker(maker);
	}

	@Override
	public List<Food> getFoodByMaterial(String material) throws SQLException {
		return foodDao.getFoodByMaterial(material);
	}

}
