package com.spring.booking.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.spring.booking.dao.MemberDAO;
import com.spring.booking.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

	
	@Autowired
	private MemberDAO mdao;
	
	@Autowired
	private MailSendService mailservice;

	//암호화 필드
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	
	//아이디 체크
	@Override
	public Map<String, String> idCheck(String userID) throws Exception {
		Map<String, String> resultMap = new HashMap<>();
		MemberDTO mdto = mdao.selectOne(userID);
		if (mdto==null) { //userID 미존재시
			resultMap.put("msg","사용 가능한 아이디입니다.");
			resultMap.put("yn","y");
		}else { //userID 존재시
			resultMap.put("msg","존재하는 아이디입니다. \n다른 아이디를 입력하세요.");
			resultMap.put("yn","n");
		}
		
		return resultMap;
	}

	//가입
	@Override
	public Map<String, Object> insert(MemberDTO mdto) throws Exception {
		logger.info(mdto.toString());
		
		//메시지 성공여부 (0:성공, -1:실패)
		Map<String, Object> resultMap = new HashMap<>();
		
		//기존 가입한 회원일경우 리턴
		MemberDTO rdto = mdao.selectOne(mdto.toString());
		
		//기존회원 존재 체크 (rdto==null 기존회원 존재)
		if (rdto != null) {
			logger.info("기존회원 존재: " + rdto.toString());
			resultMap.put("msg","기존 회원이 존재합니다.");
			resultMap.put("result: ", -1); //가입실패
			return resultMap;
		}
		
		//패스워드 암호화처리
		mdto.setUserPW(bcryptEncoder.encode(mdto.getUserPW()));
		logger.info(mdto.toString());
		
		//회원가입완료 (중복 없는 경우)
		mdao.insert(mdto);
		
		//이메일 전송
		String authKey = mailservice.sendsendAuthMail(mdto.getUserEmail(),mdto.getUserID());
		logger.info(authKey);
		
		resultMap.put("authKey", authKey); //이메일 전송 인증키
		resultMap.put("msg", "가입 완료되었습니다.");
		resultMap.put("result", 0); //가입 성공
		
		
		return resultMap;
	}

	@Override
	public void emailauthUpdate(String userID) throws Exception {
		mdao.emailauthUpdate(userID);
	}

	


	
	

	
	


}
