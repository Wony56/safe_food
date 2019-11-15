package com.ssafy.service;

import java.util.List;

import com.ssafy.model.Ingestion;

public interface IngestionService {
	public int addIngestion(Ingestion ingestion);
	public int updateIngestionQuantity(Ingestion ingestion);
	public int updateIngestionDown(Ingestion ingestion);
	public int updateIngestionUp(Ingestion ingestion);
	public int deleteIngestion(Ingestion ingestion);
	public Ingestion selectIngestion(Ingestion ingestion);
	public List<Ingestion> selectIngestionById(String id);
}
