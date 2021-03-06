package com.spring.booking.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.spring.booking.dto.BoardDTO;

public interface FileService {
	
	public void insert(BoardDTO bdto, List<MultipartFile> files) throws Exception; //파일저장 (디렉토리+DB)
	public String fileUpload(MultipartFile file) throws Exception; //파일을 폴더에 저장 후 파일명 리턴
	public void delete(List<Integer> fileDeleteList) throws Exception; //게시물 수정시 파일들 삭제
	public void deleteBoard(int bnum) throws Exception; //게시물 삭제시 파일들 삭제
	
}
