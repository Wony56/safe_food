package com.ssafy.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dao.NoticeDao;
import com.ssafy.model.Notice;
import com.ssafy.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public int addNotice(Notice notice) throws SQLException {
		return noticeDao.addNotice(notice);
	}

	@Override
	public int updateNotice(Notice notice) throws SQLException {
		return noticeDao.updateNotice(notice);
	}

	@Override
	public int deleteNotice(int idx) throws SQLException {
		return noticeDao.deleteNotice(idx);
	}

	@Override
	public Notice getNotice(int idx) throws SQLException {
		return noticeDao.getNotice(idx);
	}

	@Override
	public List<Notice> getAllNotice() throws SQLException {
		return noticeDao.getAllNotice();
	}

}
