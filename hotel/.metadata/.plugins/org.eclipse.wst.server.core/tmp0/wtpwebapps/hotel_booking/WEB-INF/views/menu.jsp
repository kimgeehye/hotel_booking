<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../views/include/includeFile.jsp" %>   
<!DOCTYPE html>
<script type="text/javascript">
	$(function() {
		//로그인,로그아웃,회원가입 show 여부
		if ('${sessionScope.userID}' == ''){
			$('#aLogin').show();	
			$('#aJoin').show();	
			$('#aLogout').hide();
			$('#aBookingList').hide();
		}else{
			$('#aLogin').hide();	
			$('#aJoin').hide();	
			$('#aLogout').show();
			$('#aBookingList').show();
		}
		
		//메인
		$('#aHome').on('click', function(e) {
			$(this).attr('href', '${path}/main');
		});
		
		//호텔위치
		$('#aHotel').on('click', function(e) {
			$(this).attr('href', '${path}/info/');
		});
		
		//문의사항
		$('#aBoardList').on('click', function(e) {
			$(this).attr('href', '${path}/board/')
		})
		
		//예약하기
		$('#aBooking').on('click', function(e) {
			$(this).attr('href', '${path}/booking/book_1')
		})
		
		//챗봇
		$('#aChat').on('click', function(e) {
			e.preventDefault();
			$(location).attr('href', '${path}/chatbot');
		})
		
		
		
		//로그아웃
		$('#aLogout').on('click', function(e) {
			e.preventDefault();
			var result = confirm ('로그아웃 하시겠습니까?');
			if (result){
				$(location).attr('href', '${path}/logout');
			}
		});
		
		//로그인
		$('#btnLogin').on('click', function(e) {
			//아이디/패스워드 체크
			e.preventDefault(); //객체의 기본기능을 소멸
			$('#loginForm').attr('action','${path}/login');
			$('#loginForm').attr('method','post');
			$('#loginForm').submit();
		});
		
		
		//로그인 취소
		$('#btnLoginCancel').on('click', function(e) {
			e.preventDefault();
			$('#loginModal').modal('hide');
		});
	
	});

</script>


<!-- Navbar -->
<nav class="navbar navbar-default">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>		
		</button>
		
		<a class = "navbar-brand" href="" id="aHome">메인</a>
		<a class = "navbar-brand" href="" id="aHotel">호텔위치</a>
		<a class = "navbar-brand" href="" id="aBoardList">문의사항</a>
		<a class = "navbar-brand" href="" id="aBooking">예약하기</a>
		<a class = "navbar-brand" href="" id="aChat" >챗봇</a>
		</div>
	
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
			<li><a href="#" data-toggle="modal" data-target="#loginModal" id="aLogin">로그인</a></li>
			<li><a href="${path}/member/add" target="myframe" id="aJoin">회원가입</a></li>
			<li><a href="#" id="aMyinfo" target="myframe">${sessionScope.userID}</a></li>
			<li><a href="${path}/booking/Bookinglist" target="myframe" id="aBookingList">예약조회</a></li>
			<li><a href="" id="aLogout">로그아웃</a></li>
		</ul>
	</div>	
</div>


  <!-- 로그인 Modal -->
  <div class="modal fade" id="loginModal" role="dialog">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
		<div class="modal-header">
	 		<h4 class="modal-title">로그인</h4>
	    </div>
        <div class="modal-body">	    
			<form id ="loginForm">
			  	<div class="input-group">
			    	<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
			    	<input id="id" type="text" class="form-control" name="userID" placeholder="id">
			  	</div>
			  	<div class="input-group">
			    	<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
			    	<input id="password" type="password" class="form-control" name="userPW" placeholder="Password">
			  	</div>
			</form>
			
		</div>
 		<div class="modal-footer">
 			<a href=""  class="btn btn-primary" id="btnLogin">로그인</a>
 			<a href="" class="btn btn-success" id="btnLoginCancel">취소</a>
		</div>      
 		<div class="modal-footer">
 			<a href="${apiURL}0" id="aNaverLogin"><img height="50" src="http://static.nid.naver.com/oauth/small_g_in.PNG" alt="네이버"/></a>
		</div>			

      </div>
    </div>
  </div>








</nav>