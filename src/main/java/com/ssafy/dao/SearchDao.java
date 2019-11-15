package com.ssafy.dao;

import java.util.List;

import com.ssafy.model.Search;

public interface SearchDao {
	public int addSearch(Search search) throws Exception;
	public int updateSearch(Search search) throws Exception;
	public List<Search> selectSearch(Search search) throws Exception;
}
