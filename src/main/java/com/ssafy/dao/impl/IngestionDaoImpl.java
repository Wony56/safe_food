package com.ssafy.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.dao.IngestionDao;
import com.ssafy.model.Ingestion;

@Repository
public class IngestionDaoImpl implements IngestionDao{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int addIngestion(Ingestion ingestion) {
		return sqlSession.insert("ingestionMapper.addIngestion", ingestion);
	}

	@Override
	public int updateIngestionQuantity(Ingestion ingestion) {
		return sqlSession.update("ingestionMapper.updateIngestionQuantity", ingestion);
	}

	@Override
	public int updateIngestionDown(Ingestion ingestion) {
		return sqlSession.update("ingestionMapper.updateIngestionDown", ingestion);
	}

	@Override
	public int updateIngestionUp(Ingestion ingestion) {
		return sqlSession.update("ingestionMapper.updateIngestionUp", ingestion);
	}

	@Override
	public int deleteIngestion(Ingestion ingestion) {
		return sqlSession.delete("ingestionMapper.deleteIngestion", ingestion);
	}

	@Override
	public Ingestion selectIngestion(Ingestion ingestion) {
		return sqlSession.selectOne("ingestionMapper.selectIngestion", ingestion);
	}

	@Override
	public List<Ingestion> selectIngestionById(String id) {
		return sqlSession.selectList("ingestionMapper.selectIngestionById", id);
	}
		
	

}
