package com.spring.booking.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.booking.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	private SqlSession session;

	@Override
	public MemberDTO selectOne(String userID) {
		return session.selectOne("com.spring.booking.MemberMapper.selectOne",userID);
	}

	@Override
	public int insert(MemberDTO mdto) {
		return session.insert("com.spring.booking.MemberMapper.insert",mdto);
	}

	@Override
	public void emailauthUpdate(String userID) {
		session.insert("com.spring.booking.MemberMapper.emailauthUpdate",userID);
		
	}

	//네이버 간편 가입
	@Override
	public int insertNaver(MemberDTO mdto) {
		return session.insert("com.spring.booking.MemberMapper.insertNaver",mdto);
	}

	@Override
	public MemberDTO selectOneNaver(String userEmail) {
		return session.selectOne("com.spring.booking.MemberMapper.selectOneNaver",userEmail);
	}


}
