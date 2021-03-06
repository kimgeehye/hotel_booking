package com.spring.booking.service;

import java.util.Map;

public interface NaverLoginService {
	
	public Map<String, String> getApiUrl() throws Exception; //네이버 인증 apiurl 생성
	
	public Map<String, Object> getNaverUserInfo(String code, String state) throws Exception; //네이버 회원 프로필 조회
	
	public int loginNaver(String userEmail, String userPhone) throws Exception; //네이버 간편가입 로그인





}
