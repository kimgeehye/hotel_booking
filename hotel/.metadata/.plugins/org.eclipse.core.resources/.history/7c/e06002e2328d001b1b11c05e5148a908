package com.spring.booking.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.booking.dto.ReplyDTO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Autowired	
	private SqlSession session;
	
	@Override
	public void insert(ReplyDTO rdto) throws Exception {
		session.insert("com.spring.booking.ReplyMapper.insert",rdto);
		
	}
	
	//기존등록된 글순서 +1
	@Override
	public void updateReStep(ReplyDTO rdto) throws Exception {
		session.update("com.spring.booking.ReplyMapper.updateReStep",rdto);
		
	}

	@Override
	public List<ReplyDTO> selectList(int bnum) throws Exception{
		return session.selectList("com.spring.booking.ReplyMapper.selectList",bnum);
	}

	@Override
	public void update(ReplyDTO rdto) throws Exception {
		session.update("com.spring.booking.ReplyMapper.update",rdto);
	}

	@Override
	public void delete(int rnum) throws Exception {
		session.delete("com.spring.booking.ReplyMapper.delete",rnum);
	}

	@Override
	public ReplyDTO selectOne(int rnum) throws Exception {
		return session.selectOne("com.spring.booking.ReplyMapper.select",rnum);
	}
	//댓글의 존재여부
	@Override
	public int selectReplyCnt(ReplyDTO rdto) throws Exception {
		return session.selectOne("com.spring.booking.ReplyMapper.selectReplyCnt",rdto);
	}

	@Override
	public void deleteBoard(int bnum) throws Exception {
		session.delete("com.spring.booking.ReplyMapper.deleteBoard",bnum);
	}

}
