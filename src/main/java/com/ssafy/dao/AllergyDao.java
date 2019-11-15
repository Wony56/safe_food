package com.ssafy.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.Allergy;

public interface AllergyDao {
	public int addAllergy(Allergy allergy) throws SQLException;
	public int deleteAllergy(String id) throws SQLException;
	public List<Allergy> getAllergy(String id) throws SQLException;
}
