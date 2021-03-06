package com.spring.booking.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.spring.booking.dao.BoardDAO;
import com.spring.booking.dao.BoardFileDAO;
import com.spring.booking.dto.BoardDTO;
import com.spring.booking.dto.BoardFileDTO;
import com.spring.booking.dto.HelpUserDTO;
import com.spring.booking.dto.PageDTO;

@Service
public class BoardServiceImpl implements BoardService{
	
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Autowired
	private BoardDAO bdao;
	
	@Autowired
	private FileService fservice;
	
	@Autowired
	private ReplyService rservice;
	
	@Autowired
	private BoardFileDAO bfdao;
	
	@Autowired
	private HelpUserService huservice;


	//페이징 처리
	@Override
	public Map<String, Object> selectList(PageDTO pdto) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		
		//페이징 처리 계산
		int curPage = pdto.getCurPage(); //현재페이지번호
		int perPage = pdto.getPerPage(); //한페이지당 게시물수
		int perBlock = pdto.getPerBlock();  //페이지 블럭의 수
		
		//시작번호
		int startNo = (curPage-1)*perPage+1;
		//끝번호
		int endNo = startNo + perPage - 1;
		
		//시작페이지
		int startPage = curPage-((curPage-1)%perBlock);
		//끝페이지
		int endPage = startPage + perBlock-1;
		
		//전체게시물수
		int totCnt = bdao.selectTotCnt(pdto);
		//전체페이지수 
		int totPage = totCnt / perPage;
		//만약에 나머지가 있으면 +1
		if (totCnt%perPage != 0) {
			totPage ++;
		}
		//끝페이지 재수정
		if (endPage>totPage) endPage=totPage; 
		
		//pdto에 셋
		pdto.setStartNo(startNo);
		pdto.setEndNo(endNo);
		pdto.setStartPage(startPage);
		pdto.setEndPage(endPage);
		pdto.setTotPage(totPage);
		
		resultMap.put("blist", bdao.selectList(pdto)); //게시물 리스트
		resultMap.put("pdto", pdto); //페이지dto
		return resultMap;
	}
	
	//한건조회 (게시물 + 파일)
	@Override
	public Map<String, Object> selectOne(int bnum) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		
		BoardDTO bdto = bdao.selectOne(bnum); //게시물 조회
		List<BoardFileDTO> bflist = bfdao.selectList(bnum); //파일조회
		
		resultMap.put("bdto", bdto);
		resultMap.put("bflist", bflist);

		return resultMap;
	}


	//한건조회 (게시물 ONLY)
	@Override
	public BoardDTO selectOneBoard(int bnum) throws Exception {
		return bdao.selectOne(bnum);
	}


	//문의글 추가
	@Transactional
	@Override
	public void insert(BoardDTO bdto, List<MultipartFile> files) throws Exception {
		bdao.insert(bdto); //문의글 DB 저장
		logger.info(bdto.toString());
		fservice.insert(bdto, files); //문의글 파일 저장
	}
	
	
	//문의글 수정
	@Override
	public void update(BoardDTO bdto, List<MultipartFile> files, List<Integer> fileDeleteList) throws Exception {
		bdao.update(bdto); //게시물 수정
		fservice.delete(fileDeleteList); //파일 삭제
		fservice.insert(bdto, files); //게시물 파일 저장
	}

	
	//문의글 삭제
	@Transactional
	@Override
	public void delete(int bnum) throws Exception {
		//1)댓글 삭제
		rservice.deleteBoard(bnum);
		//2)게시물의 파일들 삭제
		fservice.deleteBoard(bnum);
		//3)게시물삭제
		bdao.delete(bnum);
	}

	//조회수 +1
	@Override
	public void updateReadCount(int bnum, String userID) throws Exception {
		//기존에 조회한 유저가 있는지 조회
		HelpUserDTO hudto = huservice.selectOne(1, bnum, userID);
		if (hudto!=null) return ; //유저가 있다면 return
		
		//만약에 조회 사용자가 없다면 
		//1)helpuser에 insert
		//2)조회수 +1
		//type
		//1.문의글 조회
		//2.문의글 도움
		//3.문의글 비도움
		//4.댓글 도움
		//5.댓글 비도움
		huservice.insert(1, bnum, userID);
		bdao.updateReadCount(bnum);//조회수 +1
	}


	@Override
	public void updateGoodCnt(int bnum, String userID) throws Exception {
		//type
		//1.문의글 조회
		//2.문의글 도움
		//3.문의글 비도움
		//4.댓글 도움
		//5.댓글 비도움
		
		//싫어요 유저 삭제
		int cnt = huservice.delete(3, bnum, userID);
		if (cnt >0) { //삭제가 됬다면 게시판 싫어요 -1
			bdao.updateNonGoodCntMinus(bnum);
		}
		
		//기존에 좋아요한 유저가 있는지 조회
		HelpUserDTO ludto = huservice.selectOne(2, bnum, userID);
		if (ludto!=null) return ; //유저가 있다면 return
		
		//만약에 좋아요한 사용자가 없다면 
		//1)helpuser에 insert
		huservice.insert(2, bnum, userID);
		//2)좋아요+1
		bdao.updateGoodCnt(bnum);
	}


	@Override
	public void updateNonGoodCnt(int bnum, String userID) throws Exception {
		//type
		//1.문의글 조회
		//2.문의글 도움
		//3.문의글 비도움
		//4.댓글 도움
		//5.댓글 비도움
		
		//좋아요 유저 삭제
		int cnt = huservice.delete(2, bnum, userID);
		if (cnt >0) { //삭제가 됬다면 게시판 좋아요 -1
			bdao.updateGoodCntMinus(bnum);
		}

		//기존에 싫어요한 유저가 있는지 조회
		HelpUserDTO ludto = huservice.selectOne(3, bnum, userID);
		if (ludto!=null) return ; //유저가 있다면 return
		
		//만약에 싫어요한 사용자가 없다면 
		//1)helpuser에 insert
		huservice.insert(3, bnum, userID);
		//2)싫어요+1
		bdao.updateNonGoodCnt(bnum);
	}

	
	
	
	
	
	
	
	
	
}
