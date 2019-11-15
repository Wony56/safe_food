package com.ssafy.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.Notice;

public interface NoticeService {
	public int addNotice(Notice notice) throws SQLException;
	public int updateNotice(Notice notice) throws SQLException;
	public int deleteNotice(int idx) throws SQLException;
	public Notice getNotice(int idx) throws SQLException;
	public List<Notice> getAllNotice() throws SQLException;
}
