<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../views/include/includeFile.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>찾아오시는길</title>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=auv1scjwz6"></script>
<script type="text/javascript">
	$(function() {
		//호텔의 경도 위도 알기
		const x = 126.9301180;
		const y = 37.4847794;
		//맵의 옵션
		var mapOptions = {
		    center: new naver.maps.LatLng(y, x),
		    zoom: 18
		};
		
		//맵 생성
		var map = new naver.maps.Map('map', mapOptions);
		
		//마커 생성
		var marker = new naver.maps.Marker({
		    position: new naver.maps.LatLng(y, x),
		    map: map
		});
		
	});


</script>
</head>
<body>
<%@include file="../views/menu.jsp" %>
<div class="container">
	<h2>The Renaissance Location</h2>
	<br>
	<div id="map" style="width:100%;height:400px;"></div>


</div>

	
	
	
	
</body>
</html>