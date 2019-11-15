package com.ssafy.model;

public class Allergy {
	private String id;
	private String allergyMat;
	
	public Allergy() {
	}

	public Allergy(String allergyMat) {
		this.allergyMat = allergyMat;
	}

	public Allergy(String id, String allergyMat) {
		this.id = id;
		this.allergyMat = allergyMat;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAllergyMat() {
		return allergyMat;
	}

	public void setAllergyMat(String allergyMat) {
		this.allergyMat = allergyMat;
	}

	@Override
	public String toString() {
		return "Allergy [allergyMat=" + allergyMat + "]";
	}
}
