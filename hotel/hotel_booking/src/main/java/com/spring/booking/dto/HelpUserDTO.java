package com.spring.booking.dto;

public class HelpUserDTO {
	private String gubun;
	private int num;
	private String userID;
	private String helpgubun;
	
	
	public HelpUserDTO() {}
	public HelpUserDTO(String gubun, int num, String userID, String helpgubun) {
		this.gubun = gubun;
		this.num = num;
		this.userID = userID;
		this.helpgubun = helpgubun;
	}
	public String getGubun() {
		return gubun;
	}
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getHelpgubun() {
		return helpgubun;
	}
	public void setHelpgubun(String helpgubun) {
		this.helpgubun = helpgubun;
	}
	@Override
	public String toString() {
		return "HotelHelpuserDTO [gubun=" + gubun + ", num=" + num + ", userID=" + userID + ", helpgubun=" + helpgubun
				+ "]";
	}
	
	
	
	
	
}
