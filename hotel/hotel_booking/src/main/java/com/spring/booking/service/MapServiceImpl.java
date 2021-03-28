package com.spring.booking.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class MapServiceImpl implements MapService{

	@Override
	public Map<String, Double> geocoding(String address) throws Exception {
		String clientID = "auv1scjwz6";
		String clientSecret = "5PcGSXdEplOFo80UTR9KYk8e5ThrhfezFfbDWU2H";
		String mapuri = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode";
		
		//url생성
		StringBuilder urlBuilder = new StringBuilder(mapuri); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("query","UTF-8") + "=" +  URLEncoder.encode(address,"UTF-8")); /*검색주소*/
        System.out.println(urlBuilder.toString());
        URL url = new URL(urlBuilder.toString());
        //url을 이용한 접속
        HttpURLConnection conn = (HttpURLConnection) url.openConnection(); 
        //request 헤더값 세팅
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientID);
        conn.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
        
        System.out.println("Response code: " + conn.getResponseCode());
        
        //응답코드 200번 댜이면 성공
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) { //접속 성공이라면
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream())); //에러일때
        }
        StringBuilder sb = new StringBuilder(); //응답결과를 저장하기 위한 문자열 객체
        String line;
        while ((line = rd.readLine()) != null) { //응답결과가 없을 때까지 계속 반복해서 
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString()); //json 구조의 문자열
        
        
		return null;
	}

}
