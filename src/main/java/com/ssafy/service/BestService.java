package com.ssafy.service;

import java.util.List;

import com.ssafy.model.Best;
import com.ssafy.model.Ingestion;

public interface BestService {
	public int addBest(Ingestion ingestion) throws Exception;
	public int updateBestUp(Ingestion ingestion) throws Exception;
	public int updateBestQuantity(Ingestion ingestion) throws Exception;
	public List<Best> selectBestLimit(String id) throws Exception;
}
