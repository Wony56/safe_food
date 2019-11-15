package com.ssafy.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.dao.LikesDao;
import com.ssafy.model.Likes;

@Repository
public class LikesDaoImpl implements LikesDao{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int addLikes(Likes likes) {
		return sqlSession.insert("likesMapper.addLikes", likes);
	}

	@Override
	public int updateLikesQuantity(Likes likes) {
		return sqlSession.update("likesMapper.updateLikesQuantity", likes);
	}

	@Override
	public int updateLikesDown(Likes likes) {
		return sqlSession.update("likesMapper.updateLikesDown", likes);
	}

	@Override
	public int updateLikesUp(Likes likes) {
		return sqlSession.update("likesMapper.updateLikesUp", likes);
	}

	@Override
	public int deleteLikes(Likes likes) {
		return sqlSession.delete("likesMapper.deletelikes", likes);
	}

	@Override
	public Likes selectLikes(Likes likes) {
		return sqlSession.selectOne("likesMapper.selectLikes", likes);
	}

	@Override
	public List<Likes> selectLikesById(String id) {
		return sqlSession.selectList("likesMapper.selectLikesById", id);
	}

	

}
