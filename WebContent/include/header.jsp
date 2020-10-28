<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>

<style>
@import url('https://fonts.googleapis.com/css?family=Noto+Sans+KR');
@import url('https://fonts.googleapis.com/css?family=Finger+Paint|Gloria+Hallelujah|Rock+Salt|Sacramento|Unkempt');

body{
	background-color: #F2F2F2;
}
* {
	font-family: 'Noto Sans KR', sans-serif;
}
</style>
</head>
<nav class="navbar navbar-expand-lg navbar-dark fixed-top"
	style="background-color: #B9826E;">
	<div class="container">
		<a class="navbar-brand" href="<%=request.getContextPath()%>/index.jsp" style="padding:0px;"> <img
			src="<%=request.getContextPath()%>/images/logo.png" width="45"
			height="45" alt="">
		</a> <a class="navbar-brand" href="<%=request.getContextPath()%>/index.jsp"><strong style="font-family:  'Finger Paint', cursive;font-size: x-large;">Familia de Mascotas</strong></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
					
			<c:if test="${not empty userVO}">
				<span style="margin-top:8px;color: #FEF5EB;font-family: 'Noto Sans KR', sans-serif;">${userVO.name}님</span>
			</c:if>
				<li class="nav-item active"><a class="nav-link" href="<%=request.getContextPath()%>/index.jsp">홈</a></li>
			<c:choose>
				<c:when test="${empty userVO}">
					<li class="nav-item active"><a class="nav-link" href="<%=request.getContextPath()%>/jsp/user/loginForm.jsp"><strong>로그인</strong></a></li>
					<li class="nav-item active"><a class="nav-link" href="<%=request.getContextPath()%>/jsp/user/signUpForm.jsp">회원가입</a></li>
				</c:when>
				 <c:otherwise>
				 	<li class="nav-item active"><a class="nav-link" href="<%=request.getContextPath()%>/jsp/user/logout.jsp"><strong>로그아웃</strong></a></li>
					<li class="nav-item active"><a class="nav-link" href="<%=request.getContextPath()%>/jsp/user/myPage.jsp">마이페이지</a></li>
				 </c:otherwise>
			</c:choose>
				
				
				
			</ul>
		</div>
	</div>
</nav>
