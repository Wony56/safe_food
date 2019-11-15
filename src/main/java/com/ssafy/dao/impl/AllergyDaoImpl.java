package com.ssafy.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.dao.AllergyDao;
import com.ssafy.model.Allergy;

@Repository
public class AllergyDaoImpl implements AllergyDao{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int addAllergy(Allergy allergy) throws SQLException {
		return sqlSession.insert("allergyMapper.addAllergy", allergy);
	}

	@Override
	public int deleteAllergy(String id) throws SQLException {
		return sqlSession.delete("allergyMapper.deleteAllergy", id);
	}

	@Override
	public List<Allergy> getAllergy(String id) throws SQLException {
		return sqlSession.selectList("allergyMapper.getAllergy", id);
	}

}
