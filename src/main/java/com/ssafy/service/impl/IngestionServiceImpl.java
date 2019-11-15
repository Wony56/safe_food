package com.ssafy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dao.IngestionDao;
import com.ssafy.model.Ingestion;
import com.ssafy.service.IngestionService;
@Service
public class IngestionServiceImpl implements IngestionService{
	
	@Autowired
	private IngestionDao ingestionDao;
	
	@Override
	public int addIngestion(Ingestion ingestion) {
		return ingestionDao.addIngestion(ingestion);
	}

	@Override
	public int updateIngestionQuantity(Ingestion ingestion) {
		return ingestionDao.updateIngestionQuantity(ingestion);
	}

	@Override
	public int updateIngestionDown(Ingestion ingestion) {
		return ingestionDao.updateIngestionDown(ingestion);
	}

	@Override
	public int updateIngestionUp(Ingestion ingestion) {
		return ingestionDao.updateIngestionUp(ingestion);
	}

	@Override
	public int deleteIngestion(Ingestion ingestion) {
		return ingestionDao.deleteIngestion(ingestion);
	}

	@Override
	public Ingestion selectIngestion(Ingestion ingestion) {
		return ingestionDao.selectIngestion(ingestion);
	}

	@Override
	public List<Ingestion> selectIngestionById(String id) {
		return ingestionDao.selectIngestionById(id);
	}

}
