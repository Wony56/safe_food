package com.ssafy.test;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ssafy.model.Member;

public class JUnitTest {
	
	public static void main(String[] args) throws Exception{
		Reader r = Resources.getResourceAsReader("mybatis/mybatis_config.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		Member member  = new Member();
		member.setId("id");
		member.setPassword("pass");
		
		Member rvo = session.selectOne("memberMapper.logIn", member);
		
		System.out.println(session.delete("memberMapper.deleteMember", "jiji"));
	}
}
