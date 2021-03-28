package com.spring.booking.service;

import java.util.Map;

public interface LoginService {
	public Map<String, Object> loginCheck(String userID, String userPW); //로그인 체크
}
