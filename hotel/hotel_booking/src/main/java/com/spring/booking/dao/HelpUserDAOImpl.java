package com.spring.booking.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.booking.dto.HelpUserDTO;

@Repository
public class HelpUserDAOImpl implements HelpUserDAO{

	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(HelpUserDTO hudto) {
		session.insert("com.spring.booking.HelpUsergMapper.insert", hudto);
	}

	@Override
	public HelpUserDTO selectOne(HelpUserDTO hudto) {
		return session.selectOne("com.spring.booking.HelpUsergMapper.select", hudto);
	}

	@Override
	public int delete(HelpUserDTO hudto) {
		return session.insert("com.spring.booking.HelpUsergMapper.delete", hudto);
	}

	 
	
}
