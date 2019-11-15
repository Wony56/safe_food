package com.ssafy.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.dao.BestDao;
import com.ssafy.model.Best;
import com.ssafy.model.Ingestion;

@Repository
public class BestDaoImpl implements BestDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int addBest(Ingestion ingestion) throws Exception {
		return sqlSession.insert("bestMapper.addBest",ingestion);
	}

	@Override
	public int updateBestUp(Ingestion ingestion) throws Exception {
		return sqlSession.update("bestMapper.updateBestUp",ingestion);
	}

	@Override
	public int updateBestQuantity(Ingestion ingestion) throws Exception {
		return sqlSession.update("bestMapper.updateBestQuantity",ingestion);
	}

	@Override
	public List<Best> selectBestLimit(String id) throws Exception {
		return sqlSession.selectList("bestMapper.selectBestLimit",id);
	}

}
