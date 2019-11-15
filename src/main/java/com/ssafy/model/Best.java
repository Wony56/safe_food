package com.ssafy.model;

public class Best {
	private String id;
	private String foodName;
	private int count;
	private String imgurl;
	
	public Best() {
		
	}

	public Best(String id, String foodname, int count, String imgurl) {
		super();
		this.id = id;
		this.foodName = foodname;
		this.count = count;
		this.imgurl = imgurl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodname) {
		this.foodName = foodname;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	
}
