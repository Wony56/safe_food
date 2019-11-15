package com.ssafy.model;

import java.util.List;

public class Food {
	private String foodName;
	private String maker;
	private String imgurl;
	private Nutrition nutrition;
	private List<Material> materialList;
	
	public Food() {
		
	}
	
	public Food(String foodName) {
		this.foodName = foodName;
	}
	
	public Food(String foodName, String maker, String img) {
		this.foodName = foodName;
		this.maker = maker;
		this.imgurl = img;
	}

	public Food(String foodName, String maker, String img, Nutrition nutrition, List<Material> materialList) {
		this.foodName = foodName;
		this.maker = maker;
		this.imgurl = img;
		this.nutrition = nutrition;
		this.materialList = materialList;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	
	public Nutrition getNutrition() {
		return nutrition;
	}

	public void setNutrition(Nutrition nutrition) {
		this.nutrition = nutrition;
	}

	public List<Material> getMaterialList() {
		return materialList;
	}

	public void setMaterialList(List<Material> materialList) {
		this.materialList = materialList;
	}

	@Override
	public String toString() {
		return "Food [foodName=" + foodName + ", maker=" + maker + ", img=" + imgurl + ", nutriion=" + nutrition
				+ ", materialList=" + materialList + "]";
	}
	
}
