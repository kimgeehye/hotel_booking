package com.spring.booking.service;

import java.util.Map;

import com.spring.booking.dto.MemberDTO;

public interface MemberService {
	public Map<String, String> idCheck(String userID) throws Exception; //아이디 중복 처리
	public Map<String, Object> insert(MemberDTO mdto) throws Exception; //회원가입
	public void emailauthUpdate(String userID) throws Exception; //이메일 인증
}
