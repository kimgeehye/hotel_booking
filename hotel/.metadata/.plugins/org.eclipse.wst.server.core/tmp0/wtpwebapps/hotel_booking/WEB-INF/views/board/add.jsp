<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의사항 등록</title>
<script type="text/javascript">
	$(function() {
		//파일 추가
		$('#btnFileAdd').on('click', function(e) {
			e.preventDefault();
			var appendHtml = '<li><input type="file" name="uploadfiles" >' +
								'<button class="btnFileRemove">삭제</button></li>';
			
			$('#fileGroup').append(appendHtml);
		});
		
		//파일 삭제
		$('#fileGroup').on('click', 'button', function(e) {
			e.preventDefault();
			$(this).parent().remove();
		});
		
		//등록버튼 클릭
		$('#btnAdd').on('click', function(e) {
			e.preventDefault();
			
			//로그인 유무 체크
			const session_userID = '${sessionScope.userID}';
			if(session_userID==''){
				alert('권한이 없습니다.\n로그인 하세요.');
				return;
			}
			
			//유효성 체크
			const subject = frmAdd.subject.value;
			const content = frmAdd.content.value;
			
			if (subject==''){
				alert('제목을 입력해 주세요.');
				frmAdd.subject.focus();
				return;
			}else if (content==''){
				alert('내용을 입력해 주세요.');
				frmAdd.content.focus();
				return;
			}
			
			//form의 속성 변경
			$('#frmAdd').attr('action', '${path}/board/add');
			$('#frmAdd').attr('method', 'post');
			$('#frmAdd').attr('enctype', 'multipart/form-data');
			$('#frmAdd').submit();
			
			
		});
	});


</script>
</head>
<body>
<%@include file="../menu.jsp" %>
<div class="container">
	<h2>문의사항 등록</h2>
	
	<form id="frmAdd" name="frmAdd">
		제목 : <input type="text" name="subject" id="subject" size="35"><br>
		내용 :
		<textarea rows="10" cols="35" name="content" id="content"></textarea><br>
		<hr>
		파일 :
			<button id="btnFileAdd">추가</button>
			<ul id="fileGroup">
				<li><input type="file" name="uploadfiles"><button class="btnFileRemove">삭제</button></li>
			</ul>
		
		<hr>
		<button id="btnAdd">등록</button>
		<input type="reset" value="취소">
		
	</form>


<%@include file="../footer.jsp" %>
</div>
</body>
</html>