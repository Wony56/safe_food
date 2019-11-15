package com.ssafy.model;

public class Material {
	private String foodName;
	private String mat;
	
	
	public Material() {
		
	}

	public Material(String foodName, String mat) {
		super();
		this.foodName = foodName;
		this.mat = mat;
	}

	public String getMat() {
		return mat;
	}

	public void setMat(String mat) {
		this.mat = mat;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	@Override
	public String toString() {
		return "Material [foodName=" + foodName + ", mat=" + mat + "]";
	}	
}
