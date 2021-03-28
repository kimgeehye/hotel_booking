package com.spring.booking.dao;

import java.util.List;

import com.spring.booking.dto.ReplyDTO;

public interface ReplyDAO {

	public void insert(ReplyDTO rdto) throws Exception; //댓글 추가
	public void update(ReplyDTO rdto) throws Exception; //댓글 수정
	public void delete(int rnum) throws Exception; //댓글 삭제
	public void deleteBoard(int bnum) throws Exception; //문의글에 해당하는 댓글 삭제
	
	public ReplyDTO selectOne(int rnum) throws Exception; //댓글조회
	
	//기존등록된 글순서 +1
	public void updateReStep(ReplyDTO rdto) throws Exception;
	public List<ReplyDTO> selectList(int bnum) throws Exception;
	public int selectReplyCnt(ReplyDTO rdto) throws Exception;
	
}
