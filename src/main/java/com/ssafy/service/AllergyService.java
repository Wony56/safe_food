package com.ssafy.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.Allergy;

public interface AllergyService {
	public int addAllergy(Allergy allergy) throws SQLException;
	public int deleteAllergy(String id) throws SQLException;
	public List<Allergy> getAllergy(String id) throws SQLException;
}
