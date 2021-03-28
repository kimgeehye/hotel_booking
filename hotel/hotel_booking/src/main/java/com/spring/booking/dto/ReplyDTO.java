package com.spring.booking.dto;

public class ReplyDTO {
	private int rnum;
	private int bnum ;
	private String userID;
	private String content;
	private String ip;
	private int restep;
	private int relevel;
	private String regdate;
	private String modifydate;
	
	
	public ReplyDTO() {}
	public ReplyDTO(int rnum, int bnum, String userID, String content, String ip, int restep, int relevel,
			String regdate, String modifydate) {
		this.rnum = rnum;
		this.bnum = bnum;
		this.userID = userID;
		this.content = content;
		this.ip = ip;
		this.restep = restep;
		this.relevel = relevel;
		this.regdate = regdate;
		this.modifydate = modifydate;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getRestep() {
		return restep;
	}
	public void setRestep(int restep) {
		this.restep = restep;
	}
	public int getRelevel() {
		return relevel;
	}
	public void setRelevel(int relevel) {
		this.relevel = relevel;
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
		return "HotelReplyDTO [rnum=" + rnum + ", bnum=" + bnum + ", userID=" + userID + ", content=" + content
				+ ", ip=" + ip + ", restep=" + restep + ", relevel=" + relevel + ", regdate=" + regdate
				+ ", modifydate=" + modifydate + "]";
	}
	
	
	
	
	
}

