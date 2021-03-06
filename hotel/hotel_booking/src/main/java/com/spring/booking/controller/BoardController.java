package com.spring.booking.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.spring.booking.dto.BoardDTO;
import com.spring.booking.dto.PageDTO;
import com.spring.booking.service.BoardService;

@Controller
@RequestMapping("board")
@SessionAttributes("pdto")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService bservice;
	
	
	//문의글 작성폼으로 이동
	@RequestMapping(value = "add", method=RequestMethod.GET)
	public String add() {
		return "board/add";
	}
	
	//문의글 작성
	@RequestMapping(value = "add", method=RequestMethod.POST)
	public String add(BoardDTO bdto, List<MultipartFile> uploadfiles, HttpSession session, HttpServletRequest request) throws Exception {
		//세션에서 userID
		bdto.setUserID((String) session.getAttribute("userID"));
		//사용자의 ip
		bdto.setIp(request.getRemoteAddr());
		bservice.insert(bdto, uploadfiles);
		
		return "redirect:/board/";
	}
	
	//문의사항 조회폼
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String list(PageDTO pdto, HttpSession session) {
		session.getAttribute("pdto");
		return "board/list";
	}
	
	//조회버튼 또는 페이지를 눌렀을때
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Map<String, Object> listdata(@ModelAttribute("pdto") PageDTO pdto) throws Exception {
		return bservice.selectList(pdto);
	}
	
	//한건조회
	@RequestMapping(value = "/detail/{bnum}", method = RequestMethod.GET)
	public String detail(@PathVariable("bnum") int bnum, Model model, 
					HttpSession session, HttpServletRequest request) throws Exception {
		String userID = (String) session.getAttribute("userID");
		if (userID==null) userID = request.getRemoteAddr();
		logger.info(userID);

		//조회수+1
		bservice.updateReadCount(bnum, userID);
		
		//한건조회
		Map<String,Object> resultMap = bservice.selectOne(bnum);
		
		model.addAttribute("resultMap", resultMap);
		
		return "board/detail";
	}
		
	//좋아요 버튼
	@ResponseBody
	@RequestMapping(value = "goodcnt/{bnum}")
	public Map<String,Integer> goodcnt(@PathVariable("bnum") int bnum, HttpSession session) throws Exception {
		//도움 update
		bservice.updateGoodCnt(bnum, (String)session.getAttribute("userID"));
			
		Map<String, Integer> resultMap = new HashMap<>(); 
		//도움/비도움 select
		BoardDTO bdto = bservice.selectOneBoard(bnum);
		resultMap.put("goodcnt", bdto.getGoodcnt());
		resultMap.put("nongoodcnt", bdto.getNongoodcnt());
		
		return resultMap;
	}	
	
	//싫어요 버튼
	@ResponseBody
	@RequestMapping(value = "nongoodcnt/{bnum}")
	public Map<String,Integer> nongoodcnt(@PathVariable("bnum") int bnum, HttpSession session) throws Exception {
		//싫어요 update
		bservice.updateNonGoodCnt(bnum, (String)session.getAttribute("userID")); 
		
		Map<String, Integer> resultMap = new HashMap<>(); 
		//도움/비도움 select
		BoardDTO bdto = bservice.selectOneBoard(bnum);
		resultMap.put("goodcnt", bdto.getGoodcnt());
		resultMap.put("nongoodcnt", bdto.getNongoodcnt());
		
		return resultMap;
	}
	
	//수정폼으로 이동
	@RequestMapping(value = "modify/{bnum}", method = RequestMethod.GET)
	public String modify(@PathVariable("bnum") int bnum, Model model) throws Exception {
		//한건조회
		model.addAttribute("resultMap", bservice.selectOne(bnum));
		
		return "board/modify";
	}
	
	//수정
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String modify(BoardDTO bdto,
			@RequestParam(value="fileDelete", required = false) List<Integer> fileDeleteList,
			List<MultipartFile> uploadfiles) throws Exception {
		bservice.update(bdto, uploadfiles, fileDeleteList);
		
		return "redirect:/board/detail/"+bdto.getBnum();
	}
	
	//삭제
	@RequestMapping(value = "delete/{bnum}", method = RequestMethod.GET)
	public String delete(@PathVariable("bnum") int bnum, Model model) throws Exception {
		bservice.delete(bnum);
		
		return "redirect:/board/";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
