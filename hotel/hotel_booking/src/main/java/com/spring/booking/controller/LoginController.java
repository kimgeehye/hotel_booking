package com.spring.booking.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.booking.service.LoginService;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService lservice;
	
	
	//로그인
	@RequestMapping(value = "login", method=RequestMethod.POST)
	public String login(String userID, String userPW, HttpSession session, RedirectAttributes rd, Model model) {
		logger.info(userID+":"+userPW);
		Map<String, Object> resultMap = lservice.loginCheck(userID, userPW);
		logger.info(resultMap.toString());
		//로그인 실패시(-1) login이동, 성공시(0) main으로 이동
		if ((int)resultMap.get("result")==0) {
			//세션에 userID저장
			session.setAttribute("userID", userID);
			session.setMaxInactiveInterval(60*60*100);
		}
		
		rd.addFlashAttribute("msg", resultMap.get("msg"));
		return "redirect:/main";
	}
	
	//로그아웃
	@RequestMapping(value = "logout", method=RequestMethod.GET)
	public String logout(HttpSession session, RedirectAttributes rd) {
		session.invalidate(); //세션 모든 정보 소멸
		rd.addFlashAttribute("msg","로그아웃 되었습니다.");
		return "redirect:/main";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
