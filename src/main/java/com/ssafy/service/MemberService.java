package com.ssafy.service;

import java.sql.SQLException;

import com.ssafy.model.Member;

public interface MemberService {
	public int addMember(Member member) throws SQLException;
	public int updateMember(Member member) throws SQLException;
	public int deleteMember(String id) throws SQLException;
	public Member logIn(Member member) throws SQLException;
	public Member findPassword(Member member) throws SQLException;
}
