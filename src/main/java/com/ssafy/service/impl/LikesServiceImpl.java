package com.ssafy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dao.LikesDao;
import com.ssafy.model.Likes;
import com.ssafy.service.LikesService;
@Service
public class LikesServiceImpl implements LikesService{

	@Autowired
	private LikesDao likesDao;
	
	@Override
	public int addLikes(Likes likes) {
		return likesDao.addLikes(likes);
	}

	@Override
	public int updateLikesQuantity(Likes likes) {
		return likesDao.updateLikesQuantity(likes);
	}

	@Override
	public int updateLikesDown(Likes likes) {
		return likesDao.updateLikesDown(likes);
	}

	@Override
	public int updateLikesUp(Likes likes) {
		return likesDao.updateLikesUp(likes);
	}

	@Override
	public int deleteLikes(Likes likes) {
		return likesDao.deleteLikes(likes);
	}

	@Override
	public Likes selectLikes(Likes likes) {
		return likesDao.selectLikes(likes);
	}

	@Override
	public List<Likes> selectLikesById(String id) {
		return likesDao.selectLikesById(id);
	}

}
