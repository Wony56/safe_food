package com.ssafy.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.dao.SearchDao;
import com.ssafy.model.Search;

@Repository
public class SearchDaoImpl implements SearchDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int addSearch(Search search) throws Exception {
		return sqlSession.insert("searchMapper.addSearch", search);
	}

	@Override
	public int updateSearch(Search search) throws Exception {
		return sqlSession.update("searchMapper.updateSearch", search);
	}

	@Override
	public List<Search> selectSearch(Search search) throws Exception {
		return sqlSession.selectList("searchMapper.selectSearch", search);
	}

}
