package com.spring.booking.dao;

import com.spring.booking.dto.HelpUserDTO;

public interface HelpUserDAO {

	public void insert(HelpUserDTO hudto);
	public HelpUserDTO selectOne(HelpUserDTO hudto); //조회한 유저
	public int delete(HelpUserDTO hudto); //좋아요,싫어요 유저삭제
	
}
