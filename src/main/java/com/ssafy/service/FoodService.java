package com.ssafy.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.Food;
import com.ssafy.model.Material;
import com.ssafy.model.Nutrition;

public interface FoodService {
	public int addFood(Food food) throws SQLException;
	public int updateFood(Food food) throws SQLException;
	public int deleteFood(String foodName) throws SQLException;
	public List<Food> getFoodByName(String foodName) throws SQLException;
	public List<Food> getFoodByMaker(String maker) throws SQLException;
	public List<Food> getFoodByMaterial(String material) throws SQLException;
	public List<Food> getAllFood() throws SQLException;
	public List<Material> getMaterial(String foodName) throws SQLException;
	public Food getFoodInfo(String foodName) throws SQLException;
	public Nutrition getNutrition(String foodName) throws SQLException;
}
