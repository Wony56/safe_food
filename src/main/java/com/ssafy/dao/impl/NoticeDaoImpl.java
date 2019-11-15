package com.ssafy.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.dao.NoticeDao;
import com.ssafy.model.Notice;

@Repository
public class NoticeDaoImpl implements NoticeDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int addNotice(Notice notice) throws SQLException {
		return sqlSession.insert("noticeMapper.addNotice", notice);
	}

	@Override
	public int updateNotice(Notice notice) throws SQLException {
		return sqlSession.update("noticeMapper.updateNotice", notice);
	}

	@Override
	public int deleteNotice(int idx) throws SQLException {
		return sqlSession.delete("noticeMapper.deleteNotice", idx);
	}

	@Override
	public Notice getNotice(int idx) throws SQLException {
		return sqlSession.selectOne("noticeMapper.getNotice", idx);
	}

	@Override
	public List<Notice> getAllNotice() throws SQLException {
		return sqlSession.selectList("noticeMapper.getAllNotice");
	}

}
