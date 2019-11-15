package com.ssafy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dao.SearchDao;
import com.ssafy.model.Search;
import com.ssafy.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService{

	@Autowired
	private SearchDao searchDao;
	
	@Override
	public int addSearch(Search search) throws Exception {
		return searchDao.addSearch(search);
	}

	@Override
	public int updateSearch(Search search) throws Exception {
		return searchDao.updateSearch(search);
	}

	@Override
	public List<Search> selectSearch(Search search) throws Exception {
		return searchDao.selectSearch(search);
	}

}
