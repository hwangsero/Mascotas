<%@page import="miniproject.vo.BoardFileVO"%>
<%@page import="miniproject.dao.BoardDAO"%>
<%@page import="miniproject.vo.FindPlzVO"%>
<%@page import="java.util.List"%>
<%@page import="miniproject.dao.FindPlzDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	List<FindPlzVO> findPlzList = new ArrayList<>();
	FindPlzDAO findDAO = new FindPlzDAO();	
	findPlzList = findDAO.FindPlzMainList();
	BoardDAO boardDAO = new BoardDAO();
	
	HttpSession session2 = request.getSession();
	
	session.setAttribute("findPlzList", findPlzList);
	
	int no1 = findPlzList.get(0).getNo();
	int no2 = findPlzList.get(1).getNo();
	int no3 = findPlzList.get(2).getNo();
	
	List<BoardFileVO> fileList1 = boardDAO.selectFileByNo(no1);
	List<BoardFileVO> fileList2 = boardDAO.selectFileByNo(no2);
	List<BoardFileVO> fileList3 = boardDAO.selectFileByNo(no3);

	String url1 = null;
	String url2 = null;
	String url3 = null;
	
	if(fileList1.size()==0) {
		url1 = "images/dog2.jpg";
	} else {
		url1 = fileList1.get(0).getFile_save_name();
	}
	
	if(fileList2.size()==0) {
		url2 = "images/dog2.jpg";
	} else {
		url2 = fileList2.get(0).getFile_save_name();
	}
	
	if(fileList1.size()==0) {
		url3 = "images/dog2.jpg";
	} else {
		url3 = fileList3.get(0).getFile_save_name();
	}
	
	
	
	
	
%>
<!DOCTYPE html>
<html lang="ko">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="icon" href="<%=request.getContextPath()%>/images/logo.ico" type="image/x-icon">
<title>Small Business - Start Bootstrap Template</title>

<style>
body {

	height:100%;
}
</style>
</head>

<body>
	<span style="background-color:rgba( 255, 255, 255, 0 );">
	<jsp:include page="include/header.jsp"></jsp:include></span>
	<!-- Navigation -->
	<br>
	<br>
	<img src="images/dog2.jpg" width="100%" height="10%">
	<br>
	<br>
	
	<div class="container-fluid" style="width: 1350px;">
		<!-- Heading Row -->
		<div class="row my-4">	
			<!-- <div class="col-lg-8">
				<img class="img-fluid rounded" src="http://placehold.it/900x400"
					alt="">
			</div>
			/.col-lg-8
			<div class="col-lg-4">
				<h1>Business Name or Tagline</h1>
				<p>This is a template that is great for small businesses. It
					doesn't have too much fancy flare to it, but it makes a great use
					of the standard Bootstrap core components. Feel free to use this
					template for any project you want!</p>
			</div> -->
		</div>
		<!-- /.row -->
		<br> <br> <br>
		<!-- Call to Action Well -->
		<nav class="navbar navbar-expand-lg navbar-dark "
			style="background-color: #B9826E;">
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
						style="padding-right: 70px;">유기정보</a></li>
					<li class="nav-item active"><a class="navbar-brand" href="<%= request.getContextPath()%>/menu/com_Free/com_FreeList.do?pageNo=1"
						style="padding-right: 70px;">자유게시판</a></li>
					<li class="nav-item active"><a class="navbar-brand" href="<%=request.getContextPath()%>/menu/petTip.do?pageNo=1"
						style="padding-right: 70px;">애견상식</a></li>
					<li class="nav-item active"><a class="navbar-brand" href="<%=request.getContextPath()%>/menu/findPlzList.do?pageNo=1"
						style="padding-right: 70px;">찾아주세요</a></li>
					<li class="nav-item active"><a class="navbar-brand" href="<%=request.getContextPath()%>/jsp/menu/page.jsp"
						style="padding-right: 70px;">관련사이트</a></li>
					<li class="nav-item active"><a class="navbar-brand" href="<%=request.getContextPath()%>/menu/findPlzMainList.do"
						style="padding-right: 215px;">게시판6</a></li>
					</li>
				</ul>
			</div>
		</nav>
		<br> <br>
		<!-- Content Row -->
		<div class="row">
			<div class="col-md-4 mb-4">
				<div class="card h-100">
					<div class="card-body">
						<img src="<%=url1 %>" alt="..." class="img-thumbnail">
						<h2 class="card-title"><%=findPlzList.get(0).getName() %></h2>
						<p class="card-text"><%=findPlzList.get(0).getFeature() %></p>
					</div>
					<div class="card-footer" style="background-color: #3C4359;">
						<a href="#" class="btn"
							style="background-color: #BFA893; color: #1C110E;">More Info</a>
					</div>
				</div>
			</div>
			<!-- /.col-md-4 -->
			<div class="col-md-4 mb-4">
				<div class="card h-100">
					<div class="card-body">
						<img src="<%=url2 %>" alt="..." class="img-thumbnail">
						<h2 class="card-title"> <%=findPlzList.get(1).getName() %></h2>
						<p class="card-text"><%=findPlzList.get(1).getFeature() %></p>
					</div>
					<div class="card-footer">
						<a href="#" class="btn"
							style="background-color: #BFA893; color: #1C110E;">More Info</a>
					</div>
				</div>
			</div>
			<!-- /.col-md-4 -->
			<div class="col-md-4 mb-4">
				<div class="card h-100">
					<div class="card-body">
						<img src="<%=url3 %>" alt="..." class="img-thumbnail">
						<h2 class="card-title"><%=findPlzList.get(2).getName() %></h2>
						<p class="card-text"><%=findPlzList.get(2).getFeature() %></p>
					</div>
					<div class="card-footer" style="background-color: #BF625A;">
						<a href="#" class="btn"
							style="background-color: #BFA893; color: #1C110E;">More Info</a>
					</div>
				</div>
			</div>
			<!-- /.col-md-4 -->

		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
			</p>
		</div>
		<!-- /.container -->
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
