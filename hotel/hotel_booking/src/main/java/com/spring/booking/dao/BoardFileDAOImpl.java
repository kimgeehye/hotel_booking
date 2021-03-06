package com.spring.booking.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.booking.dto.BoardFileDTO;

@Repository
public class BoardFileDAOImpl implements BoardFileDAO{

	@Autowired
	private SqlSession session;

	@Override
	public void insert(BoardFileDTO bfdto) throws Exception {
		session.insert("com.spring.booking.BoardFileMapper.insert", bfdto);
		
	}

	@Override
	public List<BoardFileDTO> selectList(int bnum) throws Exception {
		return session.selectList("com.spring.booking.BoardFileMapper.selectList", bnum);
	}

	@Override
	public void delete(int fnum) throws Exception {
		session.delete("com.spring.booking.BoardFileMapper.delete", fnum);
		
	}

	@Override
	public void deleteBoard(int bnum) {
		session.delete("com.spring.booking.BoardFileMapper.deleteBoard", bnum);
		
	}
	

	
}
