package com.spring.booking.dto;

public class BookingDTO {
	private int booknum;
	private String roomnum;
	private String startdate;
	private String enddate;
	private String userID;
	private String userName;
	private String userEmail;
	private String userPhone;
	private String regdate;
	
	public BookingDTO() {}
	public BookingDTO(int booknum, String roomnum, String startdate, String enddate, String userID,
			String userName, String userEmail, String userPhone, String regdate) {
		this.booknum = booknum;
		this.roomnum = roomnum;
		this.startdate = startdate;
		this.enddate = enddate;
		this.userID = userID;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.regdate = regdate;
	}
	public int getBooknum() {
		return booknum;
	}
	public void setBooknum(int booknum) {
		this.booknum = booknum;
	}
	public String getRoomnum() {
		return roomnum;
	}
	public void setRoomnum(String roomnum) {
		this.roomnum = roomnum;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "HotelBookingDTO [booknum=" + booknum + ", roomnum=" + roomnum + ", startdate=" + startdate
				+ ", enddate=" + enddate + ", userID=" + userID + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", userPhone=" + userPhone + ", regdate=" + regdate + "]";
	}

	
	
}
