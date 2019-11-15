package com.ssafy.dao.impl;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.dao.MemberDao;
import com.ssafy.model.Member;

@Repository
public class MemberDaoImpl implements MemberDao{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int addMember(Member member) throws SQLException {
		return sqlSession.insert("memberMapper.addMember", member);
	}

	@Override
	public int updateMember(Member member) throws SQLException {
		return sqlSession.update("memberMapper.updateMember", member);
	}

	@Override
	public int deleteMember(String id) throws SQLException {
		return sqlSession.delete("memberMapper.deleteMember", id);
	}

	@Override
	public Member logIn(Member member) throws SQLException {
		return sqlSession.selectOne("memberMapper.logIn", member);
	}

	@Override
	public Member findPassword(Member member) throws SQLException {
		return sqlSession.selectOne("memberMapper.findPassword", member);
	}

}
