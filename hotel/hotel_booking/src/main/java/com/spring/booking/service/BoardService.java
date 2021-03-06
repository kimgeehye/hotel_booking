package com.spring.booking.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.spring.booking.dto.BoardDTO;
import com.spring.booking.dto.PageDTO;

public interface BoardService {
	public Map<String, Object> selectList(PageDTO pdto) throws Exception; //전체 조회, 페이지 DTO
	public Map<String, Object> selectOne(int bnum) throws Exception; //한건조회 (게시물+파일)
	public BoardDTO selectOneBoard(int bnum) throws Exception; //한건조회(게시물 ONLY)
	
	public void insert(BoardDTO bdto, List<MultipartFile> files) throws Exception; //문의글 추가
	public void update(BoardDTO bdto,List<MultipartFile> files, List<Integer> fileDeleteList) throws Exception; //문의글 수정
	public void delete(int bnum) throws Exception; //문의글 삭제
	
	
	public void updateReadCount(int bnum, String userID) throws Exception; //조회수+1
	public void updateGoodCnt(int bnum, String userID) throws Exception; //도움+1	
	public void updateNonGoodCnt(int bnum, String userID) throws Exception; //비도움+1
	
}
