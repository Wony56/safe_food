package com.ssafy.service;

import java.util.List;

import com.ssafy.model.Likes;

public interface LikesService {
	public int addLikes(Likes likes);
	public int updateLikesQuantity(Likes likes);
	public int updateLikesDown(Likes likes);
	public int updateLikesUp(Likes likes);
	public int deleteLikes(Likes likes);
	public Likes selectLikes(Likes likes);
	public List<Likes> selectLikesById(String id);
}
