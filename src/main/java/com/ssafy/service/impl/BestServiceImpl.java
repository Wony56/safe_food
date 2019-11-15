package com.ssafy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dao.BestDao;
import com.ssafy.model.Best;
import com.ssafy.model.Ingestion;
import com.ssafy.service.BestService;

@Service
public class BestServiceImpl implements BestService{
	
	@Autowired
	private BestDao bestDao;
	
	@Override
	public int addBest(Ingestion ingestion) throws Exception {
		return bestDao.addBest(ingestion);
	}

	@Override
	public int updateBestUp(Ingestion ingestion) throws Exception {
		return bestDao.updateBestUp(ingestion);
	}

	@Override
	public int updateBestQuantity(Ingestion ingestion) throws Exception {
		return bestDao.updateBestQuantity(ingestion);
	}

	@Override
	public List<Best> selectBestLimit(String id) throws Exception {
		return bestDao.selectBestLimit(id);
	}

}
