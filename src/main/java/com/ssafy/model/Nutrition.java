package com.ssafy.model;

public class Nutrition {
	private String foodName;
	private double dailyServing;
	private double callory;
	private double carbo;
	private double protein;
	private double fat;
	private double sugars;
	private double natrium;
	private double cholesterol;
	private double saturatedFattyAcid;
	private double transFat;
	
	public Nutrition() {
		
	}

	public Nutrition(String foodName, double dailyServing, double callory, double carbo, double protein, double fat,
			double sugars, double natrium, double cholesterol, double saturatedFattyAcid, double transFat) {
		super();
		this.foodName = foodName;
		this.dailyServing = dailyServing;
		this.callory = callory;
		this.carbo = carbo;
		this.protein = protein;
		this.fat = fat;
		this.sugars = sugars;
		this.natrium = natrium;
		this.cholesterol = cholesterol;
		this.saturatedFattyAcid = saturatedFattyAcid;
		this.transFat = transFat;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public double getDailyServing() {
		return dailyServing;
	}

	public void setDailyServing(double dailyServing) {
		this.dailyServing = dailyServing;
	}

	public double getCallory() {
		return callory;
	}

	public void setCallory(double callory) {
		this.callory = callory;
	}

	public double getCarbo() {
		return carbo;
	}

	public void setCarbo(double carbo) {
		this.carbo = carbo;
	}

	public double getProtein() {
		return protein;
	}

	public void setProtein(double protein) {
		this.protein = protein;
	}

	public double getFat() {
		return fat;
	}

	public void setFat(double fat) {
		this.fat = fat;
	}

	public double getSugars() {
		return sugars;
	}

	public void setSugars(double sugars) {
		this.sugars = sugars;
	}

	public double getNatrium() {
		return natrium;
	}

	public void setNatrium(double natrium) {
		this.natrium = natrium;
	}

	public double getCholesterol() {
		return cholesterol;
	}

	public void setCholesterol(double cholesterol) {
		this.cholesterol = cholesterol;
	}

	public double getSaturatedFattyAcid() {
		return saturatedFattyAcid;
	}

	public void setSaturatedFattyAcid(double saturatedFattyAcid) {
		this.saturatedFattyAcid = saturatedFattyAcid;
	}

	public double getTransFat() {
		return transFat;
	}

	public void setTransFat(double transFat) {
		this.transFat = transFat;
	}

	@Override
	public String toString() {
		return "Nutrition [foodName=" + foodName + ", dailyServing=" + dailyServing + ", callory=" + callory
				+ ", carbo=" + carbo + ", protein=" + protein + ", fat=" + fat + ", sugars=" + sugars + ", natrium="
				+ natrium + ", cholesterol=" + cholesterol + ", saturatedFattyAcid=" + saturatedFattyAcid
				+ ", transFat=" + transFat + "]";
	}
	
	
}
