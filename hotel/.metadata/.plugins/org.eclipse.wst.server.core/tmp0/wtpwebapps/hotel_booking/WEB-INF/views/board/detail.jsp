<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/includeFile.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의사항 상세조회</title>
<!-- 핸들바 탬플릿 cdn추가 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>
 <!-- 탬플릿 소스 :게시판 리스트-->
 <script id="template_source" type="text/x-handlebars-template">
    {{#each .}}
		{{level relevel}}
		<div>
			<input type="hidden" class="restep" value="{{restep}}">
			<input type="hidden" class="relevel" value="{{relevel}}">
			<input type="hidden" class="rnum" value="{{rnum}}">
			<input type="text" class="userID" value="{{userID}}">
			<br>
			<textarea rows="3" cols="20" class="content">{{content}}</textarea><br>
			<button class="btnReplyUpdate">수정</button>
			<button class="btnReplyDelete">삭제</button>
			<button class="btnReply">댓글</button>
			<div class='replyAdd'></div>
		</div>

    {{/each}}

</script>

<!-- 탬플릿 소스 : 댓글 추가 -->
 <script id="template_source_reply" type="text/x-handlebars-template">
	<div>
		<input type="hidden" id="restep" value="{{restep}}">
		<input type="hidden" id="relevel" value="{{relevel}}"><br>
		<textarea rows="5" cols="20" id="replycontent"></textarea><br>
		<button class="btnReplyAdd">추가</button>
	</div>
</script>

<script type="text/javascript">

		$(function() {
			//도움 버튼
			$('#btnGood').click(function() {
				const bnum = $('#bnum').val();
				
				$.ajax({
					type:'get',
					url:'${path}/board/goodcnt/'+bnum,
					dataType:'json',
					success: function(result) {
						$('#goodcnt').html(result.goodcnt);
						$('#nongoodcnt').html(result.nongoodcnt);
						
					},
					error: function(result) {
						alert('error');
					}
					
				});
			});
			//비도움 버튼
			$('#btnNonGood').click(function() {
				const bnum = $('#bnum').val();
				
				$.ajax({
					type:'get',
					url:'${path}/board/nongoodcnt/'+bnum,
					dataType:'json',
					success: function(result) {
						//alert(result);
						$('#goodcnt').html(result.goodcnt);
						$('#nongoodcnt').html(result.nongoodcnt);
						
					},
					error: function(result) {
						alert('error');
					}
					
				});
			});
			
			//수정버튼을 눌렀을때
			$('#btnModify').click(function() {
				const bnum = $('#bnum').val();
		
				//userID 체크
				const session_userID = '${sessionScope.userID}';
				const userID = $('#userID').val();
		
				if (userID != session_userID){
					alert('수정권한이 없습니다');
					return ;				
				}
				
				location.href="${path}/board/modify/"+bnum;	
			});
			
			//목록버튼을 눌렀을때
			$('#btnList').click(function(e) {
				e.preventDefault();
				location.href="${path}/board/";	
			});
			
			
			
			/* -------------------댓글처리------------------------- */
			
			//댓글추가 버튼을 눌렀을때
			$('body').on('click', '.btnReplyAdd', function() {
				//userID체크
				const session_userID = '${sessionScope.userID}';
				if (session_userID==''){
					alert('로그인 후 이용해 주세요');
					return ;				
				}			
				
				const bnum = $('#bnum').val();
				const replycontent = $(this).parent().find('#replycontent').val(); 
				const restep = $(this).parent().find('#restep').val();
				const relevel = $(this).parent().find('#relevel').val();

				
				if (replycontent==''){
					alert('댓글 내용을 입력해주세요');
					$('#replycontent').focus();
					return;
				}
				
				$.ajax({
					type:'post',
					contentType: "application/json",
					url: '${path}/reply/',
					data : JSON.stringify({bnum:bnum,content:replycontent,restep:restep,relevel:relevel}),//json문자열
					dataType: 'text',
					success: function(result) {
						//alert(result);
						//원본 댓글추가 html삭제
						$('#replyAdd').html('');
						//댓글의 댓글 추가 삭제
						console.log($(this).parent().parent().html());
						replyList() ; //댓글 리스트 
					},
					error: function(result) {
						alert('error');
					}
					
				});
				
			});
			
			//원본의 댓글 버튼을 눌렀을때
			$('#btnReply').on('click',function() {
				//alert(restep);
				//alert(relevel);
							
				const data = {'restep':0, 'relevel':0}; 
				
				//탬플릿을 이용하여 화면에 출력
				var source = $('#template_source_reply').html();
		        var template = Handlebars.compile(source);
		        $('#replyAdd').html(template(data));				
				
			});
		
			//댓글의 댓글 버튼을 눌렀을때
			$('#replyList').on('click', '.btnReply', function() {
				const restep = $(this).parent().find('.restep').val();
				const relevel = $(this).parent().find('.relevel').val();
				const data = {restep:restep, relevel:relevel};
				
				//탬플릿을 이용하여 화면에 출력
				var source = $('#template_source_reply').html();
		        var template = Handlebars.compile(source);
		        $(this).parent().find('.replyAdd').html(template(data));
				
			});
			
		      //댓글의 수정 버튼을 눌렀을때
				$('#replyList').on('click', '.btnReplyUpdate', function() {
					const rnum = $(this).parent().find('.rnum').val();
					const userID = $(this).parent().find('.userID').val();
					const content = $(this).parent().find('.content').val();
					console.log(rnum);
					console.log(userID);
					console.log(content);
					
					//userID체크
					const session_userID = '${sessionScope.userID}';
					if (userID != session_userID){
						alert('수정권한이 없습니다');
						return ;				
					}
					
					$.ajax({
						type:'put', //수정
						contentType: "application/json",
						url: '${path}/reply/',
						data : JSON.stringify({rnum:rnum,userID:userID,content:content}),//json문자열
						dataType: 'text',
						success: function(result) {
							alert(result);
							
						},
						error: function(result) {
							alert('error');
						}
						
					});
				});
			
				//댓글의 삭제 버튼을 눌렀을때
				$('#replyList').on('click', '.btnReplyDelete', function() {
					const rnum = $(this).parent().find('.rnum').val();
					const userID = $(this).parent().find('.userID').val();
					console.log(rnum);
					console.log(userID);
					
					//userID 체크
					const session_userID = '${sessionScope.userID}';
					if (userID != session_userID) {
						alert('삭제권한이 없습니다');
						return ;				
					}
					
					$.ajax({
						type:'delete', //삭제
						url: '${path}/reply/'+rnum,
						dataType: 'text',
						success: function(result) {
							alert(result);
							replyList() ; //댓글 리스트 
						},
						error: function(result) {
							alert('error');
						}
					});
				});
			
				//댓글 리스트 조회
				function replyList() {
					const bnum = $('#bnum').val();
					//alert(bnum);
					$.ajax({
						type:'get',
						url: '${path}/reply/'+bnum,
						dataType: 'json',
						success: function(result) {
							//alert(result);
							console.log(result);
							//핸들바 헬퍼 작성
							Handlebars.registerHelper('level', function(relevel) {
								var result = '';
								for(i=0; i<relevel; i++){
									result += '@';
								}
								return result;
							});
								
							//탬플릿을 이용하여 화면에 출력
							var source = $('#template_source').html();
				            var template = Handlebars.compile(source);
				            $('#replyList').html(template(result));	
							
						},
						error: function(result) {
							alert('error');
						}

					});

				}		
					
	
			
		replyList();
	});


</script>
</head>
<body>

<%@include file="../menu.jsp" %>
<div class="container">
	<%-- 	${resultMap.bdto}
			${resultMap.bflist}--%>
	<h2>상세조회</h2>
	번호 : <input type="text" id="bnum" value="${resultMap.bdto.bnum}" readonly="readonly"> <br>
	아이디 : <input type="text" id="userID" value="${resultMap.bdto.userID}" readonly="readonly"> <br>
	제목 : ${resultMap.bdto.subject} <br>
	내용 : <textarea rows="5" cols="20" readonly>${resultMap.bdto.content}</textarea><br>
	<hr>
	파일 : <br>
	<c:forEach var="file" items="${resultMap.bflist}">
		${file.filename} <br>
	</c:forEach>
	
	<hr>	
	조회수 :  ${resultMap.bdto.readcount} 
	<button id="btnGood">도움</button><span id="goodcnt">${resultMap.bdto.goodcnt}</span>
	<button id="btnNonGood">비도움</button><span id="nongoodcnt">${resultMap.bdto.nongoodcnt}</span>
	<hr>	
	등록일자 :  ${resultMap.bdto.regdate} <br>
	수정일자 :  ${resultMap.bdto.modifydate} <br>
	<hr>	
	<button id="btnModify">수정</button>
	<button id="btnReply">댓글</button>
	<button id="btnList">목록</button>
	
	<!-- 댓글 추가 -->
	<div id="replyAdd"></div>
	
	<!-- 댓글의 리스트 -->
	<div id="replyList">
	</div>

	
</div>
</body>
</html>