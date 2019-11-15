package com.ssafy.service;

import java.util.List;

import com.ssafy.model.Search;

public interface SearchService {
	public int addSearch(Search search) throws Exception;
	public int updateSearch(Search search) throws Exception;
	public List<Search> selectSearch(Search search) throws Exception;
}
