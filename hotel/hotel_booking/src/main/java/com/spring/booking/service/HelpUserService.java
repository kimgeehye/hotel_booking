package com.spring.booking.service;

import com.spring.booking.dto.HelpUserDTO;

public interface HelpUserService {

	//type
	//1.문의글 조회
	//2.문의글 도움
	//3.문의글 비도움
	//4.댓글 도움
	//5.댓글 비도움
	
	//유저 추가
	public void insert(int type, int num, String userID);
	//유저 조회
	public HelpUserDTO selectOne(int type, int num, String userID);
	//유저 삭제
	public int delete(int type, int num, String userID);
	
}
