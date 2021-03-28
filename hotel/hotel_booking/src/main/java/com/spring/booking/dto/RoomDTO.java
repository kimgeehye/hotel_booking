package com.spring.booking.dto;

public class RoomDTO {
	private String roomnum;
	private String roomtype;
	private String content1;
	private String content2;
	
	public RoomDTO() {}
	public RoomDTO(String roomnum, String roomtype, String content1, String content2) {
		super();
		this.roomnum = roomnum;
		this.roomtype = roomtype;
		this.content1 = content1;
		this.content2 = content2;
	}
	public String getRoomnum() {
		return roomnum;
	}
	public void setRoomnum(String roomnum) {
		this.roomnum = roomnum;
	}
	public String getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}
	public String getContent1() {
		return content1;
	}
	public void setContent1(String content1) {
		this.content1 = content1;
	}
	public String getContent2() {
		return content2;
	}
	public void setContent2(String content2) {
		this.content2 = content2;
	}
	@Override
	public String toString() {
		return "HotelRoomDTO [roomnum=" + roomnum + ", roomtype=" + roomtype + ", content1=" + content1 + ", content2="
				+ content2 + "]";
	}
	
	
	
}
