package com.spring.booking.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("booking")
public class BookingController {
	private static final Logger logger = LoggerFactory.getLogger(BookingController.class);
	
	//예약하기폼으로 이동
	@RequestMapping(value = "book_1", method=RequestMethod.GET)
	public String bookOne() {
		return "booking/book_1";
	}
	
	//예약페이지폼으로 이동
	@RequestMapping(value = "book_2", method=RequestMethod.GET)
	public String bookTwo() {
		return "booking/book_2";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
