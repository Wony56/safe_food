package com.ssafy.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dao.AllergyDao;
import com.ssafy.model.Allergy;
import com.ssafy.service.AllergyService;

@Service
public class AllergyServiceImpl implements AllergyService{
	@Autowired
	private AllergyDao allergyDao;

	@Override
	public int addAllergy(Allergy allergy) throws SQLException {
		return allergyDao.addAllergy(allergy);
	}

	@Override
	public int deleteAllergy(String id) throws SQLException {
		return allergyDao.deleteAllergy(id);
	}

	@Override
	public List<Allergy> getAllergy(String id) throws SQLException {
		return allergyDao.getAllergy(id);
	}
	
}
