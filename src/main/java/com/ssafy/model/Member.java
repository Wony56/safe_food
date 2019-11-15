package com.ssafy.model;

import java.util.List;

public class Member {
	private String id;
	private String password;
	private String name;
	private String address;
	private String phone;
	private String signupDate;
	private List<Allergy> allergyList;
	
	public Member() {
		
	}
	
	public Member(String id, String password, String name, String address, String phone, String signupDate) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.signupDate = signupDate;
	}

	public Member(String id, String password, String name, String address, String phone, String signupDate,
			List<Allergy> allergyList) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.signupDate = signupDate;
		this.allergyList = allergyList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSignupDate() {
		return signupDate;
	}

	public void setSignupDate(String signupDate) {
		this.signupDate = signupDate;
	}

	public List<Allergy> getAllergyList() {
		return allergyList;
	}

	public void setAllergyList(List<Allergy> allergyList) {
		this.allergyList = allergyList;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", address=" + address + ", phone="
				+ phone + ", signupDate=" + signupDate + ", allergyList=" + allergyList + "]";
	}
}
