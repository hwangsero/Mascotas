<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     --%>
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
  }
   a:link { color: black; text-decoration: none;}
   a:visited { color: black; text-decoration: none;}
   a:hover { color: blue; text-decoration: underline;}
	.order-md-1{
		 margin: 0 auto; 
		 text-align:center;
	}
</style>
<body class="bg-light">
   	<span style="background-color:rgba( 255, 255, 255, 0 );">
	<jsp:include page="../../include/header.jsp"></jsp:include></span>
	<h1>회원탈퇴 페이지</h1>
	<div class="container">

		<!-- header -->
		<div class="py-5 text-center">
			<img class="d-block mx-auto mb-4" src="../../images/leave.png">
		</div>
		<!-- header -->

		<div class="row">
			<!--  /* 마이페이지 목록 -->
			<div class="col-md-8 order-md-1">
				<h4 class="mb-3">회원탈퇴</h4><br>
				<form class="needs-validation" novalidate>

					<div class="mb-3" style="text-align: left;">
						[회원탈퇴 방법] <br>
① 회원 직접 탈퇴 방법 - 고객님께서 직접 인터넷으로 통해 회원탈퇴를 하실려면 인터파크
   홈페이지 로그인을 하신 후 [마이페이지 > 회원 정보 조회/수정 > 비밀번호 한번더 입력 > 오른쪽 위
   회원탈퇴] 를 클릭해 주세요. <br>
② 이동한 회원탈퇴 페이지에서 [ 회원탈퇴하기  탈퇴사유 선택 > 남기고 싶으신 말]을
   적어주시고, 탈퇴신청을 클릭하시면 회원탈퇴가 완료됩니다.<br>
③고객센터를 통한 탈퇴 방법 - 고객님의 주민등록증 사본을 고객센터 회원정보 담당자 앞으로<br>
   보내주시고 고객센터(1588 - 1555)로 전화를 주시거나 SOS 메일 상담하기을 통해 탈퇴요청을
   해주셔야 합니다. [팩스 02-6923-5498 회원정보 담당자 앞] <br>
④ 주민등록증 사본을 팩스로 보내기 어려우신 경우에는 아이디, 성함, 주민등록번호, 주민등록증
   발급일자를 고객센터에 알려주시거나,  SOS 메일로 보내주시면 담당자에게 전달하여 강제탈퇴
   처리를 해드리겠습니다.
<br><br>
[회원탈퇴 시 유의사항]<br>
① S-Money를 보유한 고객님께서 회원탈퇴 신청을 하시면 보유하고 있는 현금/비현금성 <br>
   S-Money금액을 알려주는 창이 팝업됩니다.<br>
   팝업 창에 S-Money 출금하러가기를 클릭하시면 S-Money 통장으로, 쇼핑하러가기 클릭 시<br> 
   쇼핑 메인화면으로 이동되며 탈퇴하기를 클릭하시면 바로 탈퇴가 되어 보유한 S-Money는 <br>
   모두 삭제됩니다.<br>
② 탈퇴하시면 I-포인트, S-Money, 인터파크Gift Card, 쿠폰, 영화예매권, 하트 등은 자동으로 소멸되며,
   재가입하시더라도 복구되지 않습니다.<br>
③ 회원탈퇴 시 유료회원 티키(TiKi) 권리도 상실되며, 재가입하더라도 복구되지 않습니다.<br><br>

단, 인터파크가 약관 및 정책상 규정한 위반행위 적발시 (인터파크 이용약관 제7조, 제20조) <br>
 회원자격이 정지되며, 소정의 소명 절차를 거쳐(1개월) 강제 탈퇴 처리됩니다.<br>
<br>
 

즉 회원 탈퇴가 정상적으로 않될 경우 인터파크 고객센터:1588-1555로 직접 문의 하셔서 회원
<br>
 

탈퇴 요청을 하시면 처리해 주실것입니다.
<br>
 

회원 탈퇴전에 물품 구매 및 진행되는 상품이 있을 경우 그것을 완료해 주시면 될것 같습니다.
<br>
 

이상입니다.

 <br><br>

좋은 하루 되세요.
<br><br>
[인터파크 이용약관]
					</div>
					
					<h4 class="mb-3">회원탈퇴를 하시겠습니까</h4>
					<div class="py-5 text-center">
						<input type="button" id="address" value="탈퇴" onclick="location.href='<%=request.getContextPath()%>/menu/leave.do'">&nbsp;&nbsp; <input type="button" id="address" value="취소" onclick="location.href='<%=request.getContextPath()%>/menu/myPage.do'">
					</div>
					<br>
				</form>
			</div>
			<!--  마이페이지 목록*/ -->
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
