package com.spring.booking.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.booking.controller.LoginController;
import com.spring.booking.dao.MemberDAO;
import com.spring.booking.dto.MemberDTO;

@Service
public class LoginServiceImpl implements LoginService {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	private MemberDAO mdao;
	
	//암호화 필드
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	
	
	@Override
	public Map<String, Object> loginCheck(String userID, String userPW) {
		//메시지 (0:성공, -1:실패)
		Map<String, Object> resultMap = new HashMap<>();
		
		//존재하는 회원인지 체크
		MemberDTO mdto = mdao.selectOne(userID);
		if (mdto==null) {
			//회원 미존재
			resultMap.put("msg", "아이디가 존재하지 않습니다.");
			resultMap.put("result", -1);
			return resultMap;
		}
		
		//존재하는 회원이면 패스워드 체크
		//사용자가 입력하는 패스워드, DB에 저장된 패스워드 매치, 패스워드 평문 암호화해서 매치여부 체크
		if (!bcryptEncoder.matches(userPW, mdto.getUserPW())) {
			//패스워드 불일치
			resultMap.put("msg", "패스워드가 일치하지 않습니다.");
			resultMap.put("result", -1);
			return resultMap;
		}
		
		//이메일 인증 체크
		if (!mdto.getEmailauth().equals("1")) {
			//이메일 인증 안함
			resultMap.put("msg", "이메일을 인증해주세요.");
			resultMap.put("result", -1);
			return resultMap;
		}
		
		//로그인 성공
		resultMap.put("msg", "로그인 성공되었습니다.");
		resultMap.put("result", 0);
		
		return resultMap;
	}

}
