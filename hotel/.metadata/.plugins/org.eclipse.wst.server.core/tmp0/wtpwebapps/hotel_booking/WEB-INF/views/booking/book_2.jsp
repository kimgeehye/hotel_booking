<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 페이지</title>
<script type="text/javascript">
 	$(function() {
 		//예약하기 버튼 클릭
		$('#btnBooking').on('click', function(e) {
			e.preventDefault();
			
			//로그인 유무 체크
			const session_userID = '${sessionScope.userID}';
			if(session_userID==''){
				alert('권한이 없습니다.\n로그인 하세요.');
				return;
			}
			
			const roomnum = frmBooking.roomnum.value;
			const startdate = frmBooking.startdate.value;
			const enddate = frmBooking.enddate.value;
			const userName = frmBooking.userName.value;
			const userEmail = frmBooking.userEmail.value;
			const userPhone = frmBooking.startdate.value;
			
			console.log(roomnum); console.log(startdate); console.log(enddate);
			console.log(userName); console.log(userEmail); console.log(userPhone);
			
			if (roomnum==''){
				alert('룸번호를 입력하세요');
				frmBooking.roomnum.focus();
			}else if (startdate==''){
				alert('체크인 날짜를 입력하세요');
				frmBooking.startdate.focus();
			}else if (enddate==''){
				alert('체크아웃 날짜를 입력하세요');
				frmBooking.enddate.focus();
			}else if (userName==''){
				alert('이름을 입력하세요');
				frmBooking.userName.focus();
			}else if (userEmail==''){
				alert('이메일을 입력하세요');
				frmBooking.userEmail.focus();
			}else if (userPhone==''){
				alert('연락처를 입력하세요');
				frmBooking.userPhone.focus();
			}else {
				frmBooking.submit();
			}
			
			//form의 속성 변경
			$('#frmBooking').attr('action', '${path}/booking/book_2');
			$('#frmBooking').attr('method', 'post');
			$('#frmBooking').submit();

		});

 		//메인으로 가기
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
			<h2>예약 페이지</h2>
		<form name="frmBooking" id="frmBooking">
			<h3>예약자 정보</h3>
			<table>
				<tr>
					<th>룸번호</th>
					<td><input type="text" name="roomnum"></td>
				</tr>
				<tr>
					<th>체크인</th>
					<td><input type="date" name="startdate"></td>
				</tr>
				<tr>
					<th>체크아웃</th>
					<td><input type="date" name="enddate"></td>
				</tr>
				
				<tr>
					<th>이름</th>
					<td><input type="text" name="userName"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="email"  name="userEmail"></td>
				</tr>
				<tr>
					<th>연락처</th>
					<td><input type="text"  name="userPhone"></td>
				</tr>
				<tr>
					<th>요청사항</th>
					<td><textarea rows="10" cols="35" name="content" id="content"></textarea><td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<button id="btnBooking">예약하기</button>
						<input type="reset" value="취소">
						<button id="btnMain">메인으로</button>
					</td>
				</tr>
			</table>
		</form>
	</div>

	



<%@include file="../footer.jsp" %>
</body>
</html>