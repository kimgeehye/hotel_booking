package com.spring.booking.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.booking.dto.BoardDTO;
import com.spring.booking.dto.PageDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(BoardDTO bdto) throws Exception {
		session.insert("com.spring.booking.BoardMapper.insert", bdto);
	}

	@Override
	public List<BoardDTO> selectList(PageDTO pdto) throws Exception {
		return session.selectList("com.spring.booking.BoardMapper.selectList", pdto);
	}

	@Override
	public BoardDTO selectOne(int bnum) throws Exception {
		return session.selectOne("com.spring.booking.BoardMapper.selectOne", bnum);
	}

	@Override
	public int selectTotCnt(PageDTO pdto) {
		return session.selectOne("com.spring.booking.BoardMapper.selectTotCnt", pdto);
	}

	@Override
	public void update(BoardDTO bdto) throws Exception {
		session.update("com.spring.booking.BoardMapper.update", bdto);
		
	}

	@Override
	public void delete(int bnum) throws Exception {
		session.delete("com.spring.booking.BoardMapper.delete", bnum);
		
	}

	@Override
	public void updateReadCount(int bnum) throws Exception {
		session.update("com.spring.booking.BoardMapper.updateReadCount", bnum);
		
	}

	@Override
	public void updateGoodCnt(int bnum) throws Exception {
		session.update("com.spring.booking.BoardMapper.updateGoodCnt", bnum);
		
	}

	@Override
	public void updateNonGoodCnt(int bnum) throws Exception {
		session.update("com.spring.booking.BoardMapper.updateNonGoodCnt", bnum);
		
	}

	@Override
	public void updateGoodCntMinus(int bnum) throws Exception {
		session.update("com.spring.booking.BoardMapper.updateGoodCntMinus", bnum);
		
	}

	@Override
	public void updateNonGoodCntMinus(int bnum) throws Exception {
		session.update("com.spring.booking.BoardMapper.updateNonGoodCntMinus", bnum);
		
	}

}
