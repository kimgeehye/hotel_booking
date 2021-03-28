package com.spring.booking.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.booking.dao.BoardFileDAO;
import com.spring.booking.dto.BoardDTO;
import com.spring.booking.dto.BoardFileDTO;

@Service
public class FileServiceImpl implements FileService {
	
	private static final Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);
	
	@Autowired
	private BoardFileDAO bfdao;
	
	@Autowired
	String saveDir;
	
	
	@Override
	public String fileUpload(MultipartFile file) throws Exception {
		//파일 폴더에 저장 후 파일명 리턴
		if (file.isEmpty()) return ""; //파일 없다면 리턴 (파일명 공백)
		
		//유일한 번호 생성 후 파일명 생성
		String filename = System.currentTimeMillis() + file.getOriginalFilename();
		logger.info(filename);
		
		File f = new File(saveDir, filename);
		file.transferTo(f); //파일 폴더에 저장
		
		return filename;
	}
	
	//파일 여러개 처리
	public List<String> fileUploadList(List<MultipartFile> files) throws Exception{
		List<String> flist = new ArrayList<String>();
		for (MultipartFile file:files) {
			String filename = fileUpload(file);
			if (!filename.equals("")) flist.add(filename);
		}

		return flist; //파일명의 리스트
	}
	

	@Override
	public void insert(BoardDTO bdto, List<MultipartFile> files) throws Exception {
		//파일 디렉토리에 저장
		List<String> fnamelist = fileUploadList(files);
		//파일명 DB에 저장
		for (String filename:fnamelist) {
			BoardFileDTO bfdto = new BoardFileDTO();
			bfdto.setBnum(bdto.getBnum());
			bfdto.setFilename(filename);
			bfdao.insert(bfdto);
		}
	}


	@Override
	public void delete(List<Integer> fileDeleteList) throws Exception {
		if (fileDeleteList==null) return;
		//파일 DB에서 삭제
		for (int fnum:fileDeleteList) {
			bfdao.delete(fnum);
		}
	}

	
	@Override
	public void deleteBoard(int bnum) throws Exception {
		bfdao.deleteBoard(bnum);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
