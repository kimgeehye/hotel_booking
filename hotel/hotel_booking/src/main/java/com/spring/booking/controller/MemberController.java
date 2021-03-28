package com.spring.booking.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.booking.dto.MemberDTO;
import com.spring.booking.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService mservice;
	
	
	//가입폼으로
	@RequestMapping(value = "add", method=RequestMethod.GET)
	public String add() {
		return "member/add";
	}
	
	//회원가입
	@RequestMapping(value = "add", method=RequestMethod.POST)
	public String add(MemberDTO mdto, RedirectAttributes rd, Model model, HttpSession session) throws Exception{
		logger.info(mdto.toString());
		
		Map<String, Object> resultMap = mservice.insert(mdto);
		logger.info(resultMap.toString());
		
		//인증키 세션에 넣기 (Key = userID, Value = authKey)
		session.setAttribute(mdto.getUserID(), resultMap.get("authKey"));
		session.setMaxInactiveInterval(30*60); //30분
		
		//가입실패시(-1) add으로 이동, 성공(0) main으로 이동
		if ((int)resultMap.get("result") == 0) {
			rd.addAttribute("msg", resultMap.get("msg"));
			return "redirect:/main";
		}else {
			model.addAttribute("msg", resultMap.get("msg"));
			return "add";
		}
	}
	
	//인증 이메일 클릭시
	@RequestMapping("signUpConfirm")
	public String signUpConfirm(@RequestParam Map<String, String> map, HttpSession session, RedirectAttributes rd) throws Exception{
		//userID, authKey 일치시 emailauth 1로 업데이트
		logger.info(map.toString());
		
		String sessionAuthKey = (String) session.getAttribute(map.get("userID"));
		logger.info(sessionAuthKey); //세션에 저장된 authKey
		
		if (sessionAuthKey==null) {
			//인증세션이 종료되면 key 사라짐
			logger.info("세션 미존재");
			return "member/add";
		}
		
		if (sessionAuthKey.equals(map.get("authKey"))) {
			logger.info("메일 인증 성공");
			//member=>emailauth 수정
			mservice.emailauthUpdate(map.get("userID"));
			rd.addFlashAttribute("msg", "인증 완료되었습니다. \n 로그인을 해주세요.");
		}else {
			rd.addFlashAttribute("msg", "인증키가 일치하지 않습니다.");
		}
		
		return "redirect:/main";
	}
	
	//아이디 중복 체크
	@ResponseBody
	@RequestMapping(value = "idCheck", method=RequestMethod.POST)
	public Map<String, String> idCheck(String userID) throws Exception{
		logger.info(userID);
		Map<String, String> resultMap = mservice.idCheck(userID);
		logger.info(resultMap.toString());
		
		return resultMap;
	}
	
	//주소팝업창 띄우기
	@RequestMapping(value = "jusoPopup")
	public String jusoPopup() {
		return "member/jusoPopup";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
