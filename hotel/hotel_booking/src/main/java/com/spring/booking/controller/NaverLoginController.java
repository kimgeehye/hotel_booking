package com.spring.booking.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.booking.service.NaverLoginService;

@Controller
public class NaverLoginController {
	private static final Logger logger = LoggerFactory.getLogger(NaverLoginController.class);
	
	@Autowired
	private NaverLoginService nservice;
	
	//네이버 로그인 폼 호출
//	@RequestMapping("naverlogin")
//	public String naverLogin(HttpSession session, Model model) throws Exception {
//		Map<String, String> resultMap = nservice.getApiUrl();
//		//클라이언트 인증값 세션에 저장
//		session.setAttribute("state", resultMap.get("state"));
//		model.addAttribute("apiURL", resultMap.get("apiURL"));
//		return "naverlogin/naverlogin";
//	}
	
	
	//네이버 로그인 인증코드 콜백
	@RequestMapping("callback")
	public void callback(String code, String state) throws Exception {

		 Map<String, Object> resultMap = nservice.getNaverUserInfo(code, state);	

//		
//		//이메일을 이용하여 회원가입 및 로그인
//		nservice.loginNaver(userEmail, userPhone);
//		//세션에 email 저장
//		session.setAttribute("userID", userEmail);
//		session.setMaxInactiveInterval(60*60*100);
//		return "redirect:/main"; //절대경로
	}
	
	
	
	
	

}
