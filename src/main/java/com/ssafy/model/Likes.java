package com.ssafy.model;

import java.util.List;

public class Likes {
	private String id;
	private Food food;
	private List<Allergy> allergyList;
	private int quantity;
	
	public Likes() {
		
	}
	
	public Likes(String id, Food food, int quantity) {
		super();
		this.id = id;
		this.food = food;
		this.quantity = quantity;
	}
	
	public Likes(String id, Food food, List<Allergy> allergyList, int quantity) {
		this.id = id;
		this.food = food;
		this.allergyList = allergyList;
		this.quantity = quantity;
	}
	
	public void setFoodName(String foodName) {
		this.food = new Food(foodName);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public List<Allergy> getAllergyList() {
		return allergyList;
	}

	public void setAllergyList(List<Allergy> allergyList) {
		this.allergyList = allergyList;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Likes [id=" + id + ", food=" + food + ", allergyList=" + allergyList + ", quantity=" + quantity + "]";
	}
	
}
