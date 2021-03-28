package com.spring.booking.dto;

public class MemberDTO {
	private String userID;
	private String userPW;
	private String userEmail;
	private String userPhone;
	private String zip;
	private String addr1;
	private String addr2;
	private String admin;
	private String emailauth;
	private String simplejoin;
	private String regdate;
	
	public MemberDTO(){}
	

	public MemberDTO(String userID, String userPW) {
		this.userID = userID;
		this.userPW = userPW;
	}

	public MemberDTO(String userID, String userPW, String userEmail, String userPhone, String zip, String addr1,
			String addr2, String admin, String emailauth, String simplejoin, String regdate) {
		this.userID = userID;
		this.userPW = userPW;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.zip = zip;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.admin = admin;
		this.emailauth = emailauth;
		this.simplejoin = simplejoin;
		this.regdate = regdate;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserPW() {
		return userPW;
	}

	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getEmailauth() {
		return emailauth;
	}

	public void setEmailauth(String emailauth) {
		this.emailauth = emailauth;
	}

	public String getSimplejoin() {
		return simplejoin;
	}

	public void setSimplejoin(String simplejoin) {
		this.simplejoin = simplejoin;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}


	@Override
	public String toString() {
		return "MemberDTO [userID=" + userID + ", userPW=" + userPW + ", userEmail=" + userEmail + ", userPhone="
				+ userPhone + ", zip=" + zip + ", addr1=" + addr1 + ", addr2=" + addr2 + ", admin=" + admin
				+ ", emailauth=" + emailauth + ", simplejoin=" + simplejoin + ", regdate=" + regdate + "]";
	}

	

	
	
	
	
}
