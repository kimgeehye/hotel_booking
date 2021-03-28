package com.spring.booking.dao;

import com.spring.booking.dto.MemberDTO;

public interface MemberDAO {
	//일반유저
	public MemberDTO selectOne(String userID); //회원조회
	public int insert(MemberDTO mdto); //회원가입
	
	//네이버 간편가입 유저
	public int insertNaver(MemberDTO mdto); //네이버 간편 가입
	public MemberDTO selectOneNaver(String userEmail); //네이버 간편 회원조회
	
	public void emailauthUpdate(String userID); //이메일인증
}
