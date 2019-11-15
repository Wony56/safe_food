package com.ssafy.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dao.MemberDao;
import com.ssafy.model.Member;
import com.ssafy.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public int addMember(Member member) throws SQLException {
		return memberDao.addMember(member);
	}

	@Override
	public int updateMember(Member member) throws SQLException {
		return memberDao.updateMember(member);
	}

	@Override
	public int deleteMember(String id) throws SQLException {
		return memberDao.deleteMember(id);
	}

	@Override
	public Member logIn(Member member) throws SQLException {
		return memberDao.logIn(member);
	}

	@Override
	public Member findPassword(Member member) throws SQLException {
		return memberDao.findPassword(member);
	}

}
