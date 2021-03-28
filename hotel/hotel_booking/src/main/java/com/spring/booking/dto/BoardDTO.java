package com.spring.booking.dto;

public class BoardDTO {
	private int bnum;
	private String userID;
	private String subject;
	private String content;
	private int readcount;
	private int goodcnt;
	private int nongoodcnt;
	private String ip;
	private String regdate;
	private String modifydate;
	
	public BoardDTO() {}
	public BoardDTO(int bnum, String userID, String subject, String content, int readcount, int goodcnt,
			int nongoodcnt, String ip, String regdate, String modifydate) {
		this.bnum = bnum;
		this.userID = userID;
		this.subject = subject;
		this.content = content;
		this.readcount = readcount;
		this.goodcnt = goodcnt;
		this.nongoodcnt = nongoodcnt;
		this.ip = ip;
		this.regdate = regdate;
		this.modifydate = modifydate;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public int getGoodcnt() {
		return goodcnt;
	}
	public void setGoodcnt(int goodcnt) {
		this.goodcnt = goodcnt;
	}
	public int getNongoodcnt() {
		return nongoodcnt;
	}
	public void setNongoodcnt(int nongoodcnt) {
		this.nongoodcnt = nongoodcnt;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getModifydate() {
		return modifydate;
	}
	public void setModifydate(String modifydate) {
		this.modifydate = modifydate;
	}
	
	@Override
	public String toString() {
		return "HotelBoardDTO [bnum=" + bnum + ", userID=" + userID + ", subject=" + subject + ", content=" + content
				+ ", readcount=" + readcount + ", goodcnt=" + goodcnt + ", nongoodcnt=" + nongoodcnt + ", ip=" + ip
				+ ", regdate=" + regdate + ", modifydate=" + modifydate + "]";
	}
	
	
	
}
