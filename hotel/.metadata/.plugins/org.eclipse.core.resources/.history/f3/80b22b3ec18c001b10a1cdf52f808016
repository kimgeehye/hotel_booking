package com.spring.booking.dao;

import java.util.List;

import com.spring.booking.dto.BoardDTO;
import com.spring.booking.dto.PageDTO;

public interface BoardDAO {
	
	public List<BoardDTO> selectList(PageDTO pdto) throws Exception; //전체 조회
	public BoardDTO selectOne(int bnum) throws Exception; //한건 조회
	
	public void insert(BoardDTO bdto) throws Exception; //문의글 추가
	public void update(BoardDTO bdto) throws Exception; //문의글 수정
	public void delete(int bnum) throws Exception; //문의글 삭제
	
	
	public void updateReadCount(int bnum) throws Exception; //조회수+1
	public void updateGoodCnt(int bnum) throws Exception; //도움+1
	public void updateNonGoodCnt(int bnum) throws Exception; //비도움+1
	public void updateGoodCntMinus(int bnum) throws Exception; //도움-1
	public void updateNonGoodCntMinus(int bnum) throws Exception; //도움-1
	
	
	public int selectTotCnt(PageDTO pdto); //전체 건수 조회
	
}
