package com.ssafy.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.dao.FoodDao;
import com.ssafy.model.Food;
import com.ssafy.model.Material;
import com.ssafy.model.Nutrition;

@Repository
public class FoodDaoImpl implements FoodDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int addFood(Food food) throws SQLException {
		return sqlSession.insert("foodMapper.addFood", food);
	}

	@Override
	public int updateFood(Food food) throws SQLException {
		return sqlSession.update("foodMapper.updateFood", food);
	}

	@Override
	public int deleteFood(String foodName) throws SQLException {
		return sqlSession.delete("foodMapper.deleteFood", foodName);
	}

	@Override
	public List<Food> getAllFood() throws SQLException {
		return sqlSession.selectList("foodMapper.getAllFood");
	}

	@Override
	public List<Material> getMaterial(String foodName) throws SQLException {
		return sqlSession.selectList("foodMapper.getMaterial",foodName);
	}

	@Override
	public Food getFoodInfo(String foodName) throws SQLException {
		return sqlSession.selectOne("foodMapper.getFoodInfo", foodName);
	}

	@Override
	public Nutrition getNutrition(String foodName) throws SQLException {
		return sqlSession.selectOne("foodMapper.getNutrition",foodName);
	}

	@Override
	public List<Food> getFoodByName(String foodName) throws SQLException {
		return sqlSession.selectList("foodMapper.getFoodByName", foodName);
	}

	@Override
	public List<Food> getFoodByMaker(String maker) throws SQLException {
		return sqlSession.selectList("foodMapper.getFoodByMaker", maker);
	}

	@Override
	public List<Food> getFoodByMaterial(String material) throws SQLException {
		return sqlSession.selectList("foodMapper.getFoodByMaterial", material);
	}

}
