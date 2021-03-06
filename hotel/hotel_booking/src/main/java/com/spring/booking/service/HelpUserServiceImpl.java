package com.spring.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.booking.dao.HelpUserDAO;
import com.spring.booking.dto.HelpUserDTO;

@Service
public class HelpUserServiceImpl implements HelpUserService{

	@Autowired
	private HelpUserDAO hudao;
	
	@Override
	public void insert(int type, int num, String userID) {
		HelpUserDTO hudto = setHelpUserDTO(type, num, userID);
		hudao.insert(hudto);
		
	}

	@Override
	public HelpUserDTO selectOne(int type, int num, String userID) {
		HelpUserDTO hudto = setHelpUserDTO(type, num, userID);
		return hudao.selectOne(hudto);
	}
	
	@Override
	public int delete(int type, int num, String userID) {
		HelpUserDTO hudto = setHelpUserDTO(type, num, userID);
		return hudao.delete(hudto);
	}

	//HelpUserDTO 세팅
	private HelpUserDTO setHelpUserDTO(int type, int num, String userID) {
		//type
		//1.문의글 조회
		//2.문의글 도움
		//3.문의글 비도움
		//4.댓글 도움
		//5.댓글 비도움
		HelpUserDTO hudto = new HelpUserDTO();
		if (type==1) {
			hudto.setGubun("1"); //문의글
			hudto.setNum(num); //문의글 번호
			hudto.setUserID(userID); //조회한 userID
			hudto.setHelpgubun("0"); //조회
		}else if (type==2) {
			hudto.setGubun("1"); //문의글
			hudto.setNum(num); //문의글 번호
			hudto.setUserID(userID); //조회한 userID
			hudto.setHelpgubun("1"); //도움		
		}else if (type==3) {
			hudto.setGubun("1"); //문의글
			hudto.setNum(num); //문의글 번호
			hudto.setUserID(userID); //조회한 userID
			hudto.setHelpgubun("2");//비도움		
		}
		
		return hudto;

	}
	
	


}
