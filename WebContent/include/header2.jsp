<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
</head>
<div class="container" ><nav class="navbar navbar-expand-lg navbar-dark "
			style="background-color: #B9826E;width:900px;" >
			<a class="navbar-brand" href="#"> <img src="images/logo.png"
				width="30" height="30" alt="">
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="navbar-brand" href="<%= request.getContextPath()%>/menu/Search.do"
						style="padding-right: 30px;">유기정보</a></li>
					<li class="nav-item active"><a class="navbar-brand" href="<%= request.getContextPath()%>/menu/com_Free/com_FreeList.do?pageNo=1"
						style="padding-right: 30px;">자유게시판</a></li>
					<li class="nav-item active"><a class="navbar-brand" href="<%=request.getContextPath()%>/menu/petTip.do?pageNo=1"
						style="padding-right: 30px;">애견상식</a></li>
					<li class="nav-item active"><a class="navbar-brand" href="<%=request.getContextPath()%>/menu/findPlzList.do?pageNo=1"
						style="padding-right: 30px;">찾아주세요</a></li>
					<li class="nav-item active"><a class="navbar-brand" href="<%=request.getContextPath()%>/jsp/menu/page.jsp"
						style="padding-right: 30px;">관련사이트</a></li>
					<li class="nav-item active"><a class="navbar-brand" href="<%=request.getContextPath()%>/jsp/menu/page.jsp"
						style="padding-right: 30px;">관련사이트</a></li>
					<li class="nav-item active"><a class="navbar-brand" href="<%=request.getContextPath()%>/jsp/menu/page.jsp"
						style="padding-right: 30px;">관련사이트</a></li>
					<li class="nav-item active"><a class="navbar-brand" href="<%= request.getContextPath()%>/menu/com_Review/com_ReviewList.do?pageNo=1"
						style="padding-right: 215px;">후기게시판</a></li>
					</li>
				</ul>
			</div>
		</nav></div>