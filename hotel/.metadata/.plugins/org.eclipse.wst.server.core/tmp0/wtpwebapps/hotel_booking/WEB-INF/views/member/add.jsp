<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/includeFile.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script type="text/javascript">
	//주소찾기 버튼 클릭시 실행할 함수
	function goPopup(){
		// 주소검색을 수행할 팝업 페이지를 호출합니다.
		// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
		var pop = window.open("${path}/member/jusoPopup","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	}
	
	//주소 팝업에서 실행할 함수 (callback 함수)
	// roadAddrPart1, addrDetail,zipNo
	function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,detBdNmList,bdNm,bdKdcd,siNm,sggNm,emdNm,liNm,rn,udrtYn,buldMnnm,buldSlno,mtYn,lnbrMnnm,lnbrSlno,emdNo){
			// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
			document.frmAdd.addr1.value = roadAddrPart1;
			document.frmAdd.addr2.value = addrDetail;
			document.frmAdd.zip.value = zipNo;
	}
	
	$(function() {
		//아이디 중복체크
		$('#btnIdCehck').click(function() {
			const userID = frmAdd.userID.value;
			console.log(userID);
			if (userID==''){
				alert('아이디를 입력하세요');
				frmAdd.userID.focus();
				return;
			}
			
			$.ajax({
				type: 'post',
				url: '${path}/member/idCheck',
				data: {userID:userID},
				dataType: 'json',
				success: function(result) {
					alert(result.msg);
					if (result.yn=='y'){ //사용가능한 아이디
						$('#idCheckYn').val('y');
					}else{
						$('#idCheckYn').val('n'); //사용 불가 아이디
					}
				},
				error: function(result) {
					alert('error...');
					console.log(result);
				}
			});
		});
			//가입버튼을 눌렀을 때
			$('#btnAdd').click(function(e) {
				e.preventDefault();
				const userID = frmAdd.userID.value;
				const userPW = frmAdd.userPW.value;
				const userEmail = frmAdd.userEmail.value;
				const userPhone = frmAdd.userPhone.value;
				const idCheckYn = frmAdd.idCheckYn.value; //아이디 중복 체크 여부
				
				console.log(userID);
				console.log(userPW);
				console.log(userEmail);
				console.log(userPhone);
				
				if (userID==''){
					alert('아이디를 입력하세요');
					frmAdd.userID.focus();
				}else if (userPW==''){
					alert('패스워드를 입력하세요');
					frmAdd.userPW.focus();
				}else if (userEmail==''){
					alert('이메일을 입력하세요');
					frmAdd.userEmail.focus();
				}else if (userPhone==''){
					alert('연락처를 입력하세요');
					frmAdd.userPhone.focus();
				}else {
					frmAdd.submit();
				}
			});
			
			//userID change 이벤트
			$('#userID').change(function() {
				$('#idCheckYn').val('n'); //중복체크 해제
			});
			
			//주소찾기
			$('#btnAddrFind').click(function(e) {
				e.preventDefault();
				goPopup();
			});
					
		});
		

	
</script>
</head>
<body>
<%@include file="../menu.jsp" %>
<div class="container">
 	<h2>회원가입</h2>
 	<form name="frmAdd" id="frmAdd" action="${path}/member/add" method="post">
 		<table>
 			<tr>
 				<th>아이디</th>
 				<td>
 					<input type="text" size="10" name="userID">
 					<input type="hidden" id="idCheckYn"> <!-- value가 y이면 체크 완료(사용가능) -->
 					<input type="button" value="중복체크" id="btnIdCehck">
 				</td>
 			</tr>
 			<tr>
 				<th>패스워드</th>
 				<td>
 					<input type="password" name="userPW">
 				</td>
 			</tr>
 			<tr>
 				<th>이메일</th>
 				<td><input type="email" id="userEmail" name="userEmail"></td>
 			</tr>
 			<tr>
 				<th>연락처</th>
 				<td><input type="text" id="userPhone" name="userPhone"></td>
 			</tr>
 			<tr>
				<th rowspan="3">주소</th>
				<td><input type="text" name="zip" size="5"><button id="btnAddrFind">주소찾기</button></td>
			</tr>
			<tr>
				<td><input type="text" name="addr1" size="30"></td>
			</tr>
			<tr>
				<td><input type="text" name="addr2" size="30"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button id="btnAdd">가입</button>
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