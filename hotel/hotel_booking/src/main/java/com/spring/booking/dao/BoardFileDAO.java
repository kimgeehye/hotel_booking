package com.spring.booking.dao;

import java.util.List;

import com.spring.booking.dto.BoardFileDTO;

public interface BoardFileDAO {
	
	public void insert(BoardFileDTO bfdto) throws Exception; //파일 추가
	public List<BoardFileDTO> selectList(int bnum) throws Exception; //파일 리스트 조회
	public void delete(int fnum) throws Exception; //파일 삭제
	public void deleteBoard(int bnum); //게시물의 파일 삭제
	
	
}
