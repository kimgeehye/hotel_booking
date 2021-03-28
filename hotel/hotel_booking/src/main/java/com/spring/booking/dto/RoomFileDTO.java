package com.spring.booking.dto;

public class RoomFileDTO {
	private int rfnum;
	private String roomnum;
	private String filename;
	private String regdate;
	
	public RoomFileDTO() {}
	public RoomFileDTO(int rfnum, String roomnum, String filename, String regdate) {
		this.rfnum = rfnum;
		this.roomnum = roomnum;
		this.filename = filename;
		this.regdate = regdate;
	}
	public int getRfnum() {
		return rfnum;
	}
	public void setRfnum(int rfnum) {
		this.rfnum = rfnum;
	}
	public String getRoomnum() {
		return roomnum;
	}
	public void setRoomnum(String roomnum) {
		this.roomnum = roomnum;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "HotelRoomfileDTO [rfnum=" + rfnum + ", roomnum=" + roomnum + ", filename=" + filename + ", regdate="
				+ regdate + "]";
	}
	
	
	
}
