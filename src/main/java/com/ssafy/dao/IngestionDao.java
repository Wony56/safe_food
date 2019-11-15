package com.ssafy.dao;

import java.util.List;

import com.ssafy.model.Ingestion;

public interface IngestionDao {
	public int addIngestion(Ingestion ingestion);
	public int updateIngestionQuantity(Ingestion ingestion);
	public int updateIngestionDown(Ingestion ingestion);
	public int updateIngestionUp(Ingestion ingestion);
	public int deleteIngestion(Ingestion ingestion);
	public Ingestion selectIngestion(Ingestion ingestion);
	public List<Ingestion> selectIngestionById(String id);
}
