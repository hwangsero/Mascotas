<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%-- <c:import url="http://openapi.animal.go.kr/" /> --%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<!--     <link rel="icon" href="../../../../favicon.ico"> -->

<title>No title</title>

<!-- Bootstrap core CSS -->
<link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="https://getbootstrap.com/docs/4.1/examples/checkout/form-validation.css" rel="stylesheet">

</head>
<style>
.tables {
    width: 100%;
    border: 1px solid #444444;
  }
  th, td {
    border: 1px solid #444444;
    text-align: center;
  }
   a:link { color: black; text-decoration: none;}
   a:visited { color: black; text-decoration: none;}
   a:hover { color: blue; text-decoration: underline;}

</style>
<body class="bg-light">

	<div class="container">

		<!-- header -->
		<div class="py-5 text-center">
			<img class="d-block mx-auto mb-4" src="../../images/logo.png">
		</div>
		<!-- header -->

		<div class="row">
			<!--  /* 마이페이지 목록 -->
			<div class="col-md-8 order-md-1">
				<h4 class="mb-3">마이페이지</h4><br>
				<form action="<%=request.getContextPath()%>/jsp/user/myPageModified.jsp" method="post" class="needs-validation" novalidate>
					<input type="hidden" name="id" value="${userVO.id }">
					<input type="hidden" name="type" value="${userVO.type }">
					<div class="row">
						<div class="col-md-6 mb-3">
							<label for="firstName">아이디</label> 
							<input type="text" class="form-control" id="firstName"  value="${userVO.id }" disabled>
						</div>
					</div>
 	
					<div class="mb-3">
						<label for="username">이름</label>
						<div class="input-group">
							<input type="text" class="form-control" id="username" value="${userVO.name }" disabled>
						</div>
					</div>

					<div class="mb-3">
						<label for="email">Email</label>
						<input type="email" class="form-control" id="email" value="${userVO.email_id }@${userVO.email_domain }" disabled>
					</div>

					<div class="mb-3">
						<label for="address">Address</label> 
						<input type="text" class="form-control" id="address" value="${userVO.basic_addr} ${userVO.detail_addr }"disabled>
					</div>

					<div class="py-5 text-center">
						<input type="submit" id="address" value="수정">&nbsp;&nbsp; 
						<input type="button" id="address2" value="탈퇴" onclick="location.href='<%=request.getContextPath()%>/jsp/user/leave.jsp'">
					</div>
					</form>
					<br>

					<hr class="mb-4">
					<h4 class="mb-3">내가 쓴 게시글</h4><br>
					<div class="mb-3">
						<table class="tables">
							<tr>
							
								<th style="width: 20%;">카테고리</th>
								<th style="width: 60%;">제목</th>
								<th style="width: 20%;">작성일</th>
							</tr>
							<c:forEach items="${boardList }" var="board">
							<tr>
								<td><a href="#">${board.cate}</a></td>
								<td><a href="#">${board.title }</a></td>
								<td>${board.reg_date }</td>
							</tr>
							</c:forEach>
						</table>
					</div>

					<hr class="mb-4">
					<h4 class="mb-3">내가 쓴 댓글</h4><br>
					<div class="mb-3">
						<table class="tables">
							<tr>
								<th style="width: 70%;">댓글단 게시글</th>
								<th style="width: 30%;">작성일</th>
							</tr>
							<tr>
								<td><a href="#">하일</a></td>
								<td>2018.01.01</td>
							</tr>
							<tr>
								<td><a href="#">하이</a></td>
								<td>2018.03.04</td>
							</tr>
							<tr>
								<td><a href="#">하3</a></td>
								<td>2018.11.23</td>
							</tr>
						</table>
					</div>
					<hr class="mb-4">
				
			</div>
			<!--  마이페이지 목록*/ -->

			<!--  /* 관심지역 동물 -->
			<!-- <div class="col-md-4 order-md-2 mb-4">
	          <h4 class="d-flex justify-content-between align-items-center mb-3">
	            <span class="text-muted">서울특별시 서대문구</span>
	            <span class="badge badge-secondary badge-pill">3</span>
	          </h4>
	          <ul class="list-group mb-3">
	            <li class="list-group-item d-flex justify-content-between lh-condensed">
	              <div>
	                <img src="../../images/cat.jpg" style="width: 80px; height: 80px;"/>
	                <h6 class="my-0">Product name</h6>
	                <small class="text-muted">Brief description</small>
	              </div>
	            </li>
	            <li class="list-group-item d-flex justify-content-between lh-condensed">
	              <div>
	             	<img src="../../images/cat.jpg" style="width: 80px; height: 80px;"/>
	                <h6 class="my-0">Second pro</h6>
	                <small class="text-muted">Brief description</small>
	              </div>
	            </li>
	            <li class="list-group-item d-flex justify-content-between lh-condensed">
	              <div>
	             	<img src="../../images/cat.jpg" style="width: 80px; height: 80px;"/>
	                <h6 class="my-0">Third item</h6>
	                <small class="text-muted">Brief description</small>
	              </div>
	            </li>
	          </ul>
	        </div> -->
			<!--  관심지역 동물*/ -->
		</div>

		<!-- footer -->
		<footer class="my-5 pt-5 text-muted text-center text-small">
		</footer>
		<!-- footer -->
	</div>


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<!--     <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script> -->
	<script>
		window.jQuery || document .write('<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"><\/script>')
	</script>
	<script src="https://getbootstrap.com/docs/4.1/assets/js/vendor/popper.min.js"></script>
	<script src="https://getbootstrap.com/docs/4.1/dist/js/bootstrap.min.js"></script>
	<script src="https://getbootstrap.com/docs/4.1/assets/js/vendor/holder.min.js"></script>
	<script>
	// Example starter JavaScript for disabling form submissions if there are invalid fields
	(function() {
		'use strict';
			window.addEventListener('load', function() {
		// Fetch all the forms we want to apply custom Bootstrap validation styles to
		var forms = document.getElementsByClassName('needs-validation');

		// Loop over them and prevent submission
		var validation = Array.prototype.filter.call(forms,function(form) {
			form.addEventListener('submit', function(event) {
					if (form.checkValidity() === false) {
						event.preventDefault();
						event.stopPropagation();
					}
					
					form.classList.add('was-validated');
				}, false);
			});
		}, false);
	})();
	</script>
	
</body>
</html>
