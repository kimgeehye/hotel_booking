<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약하기</title>
<script type="text/javascript">
	$(function() {
		//예약하기(예약페이지)
		$('#btnBooking').on('click', function() {
			location.href="${path}/booking/book_2"
		});
				
		//메인으로
		$('#btnMain').on('click', function() {
			location.href="${path}/main"
		});	
				
				
	});

</script>
</head>
<body>
<%@include file="../menu.jsp" %>

	<div class="container">
		<img src="${path}/resources/images/Deluxe.jpg" class="" style="float: left" alt="Deluxe" align="left" width="500" height="500">
		<h2>Deluxe Double</h2>
		
		<h3>객실정보</h3>
		<h2>룸넘버 : Deluxe</h>
		<div>
			<p>침대타입 더블/트윈</p>
			<p>투숙인원 2명 / 엑베 불가 객실</p>
			<p>객실면적 28.5 m²</p>
		</div>
		
		<button id="btnBooking">예약하기</button> 
		<button id="btnMain">메인으로</button>
	</div>



<%@include file="../footer.jsp" %>
</body>
</html>