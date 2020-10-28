<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Signin Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link
	href="<%=request.getContextPath()%>/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="icon" href="<%=request.getContextPath()%>/images/logo.ico"
	type="image/x-icon">
<style>
html, body {
	height: 100%;
}

body {
	display: -ms-flexbox;
	display: -webkit-box;
	display: flex;
	-ms-flex-align: center;
	-ms-flex-pack: center;
	-webkit-box-align: center;
	align-items: center;
	-webkit-box-pack: center;
	justify-content: center;
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #FEF5EB;
}

.form-signin {
	width: 100%;
	max-width: 330px;
	padding: 15px;
	margin: 0 auto;
}

.form-signin .checkbox {
	font-weight: 400;
}

.form-signin .form-control {
	position: relative;
	box-sizing: border-box;
	height: auto;
	padding: 10px;
	font-size: 16px;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="email"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>

<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
</head>

<body class="text-center">
	<jsp:include page="../../include/header.jsp"></jsp:include>
	<form class="form-signin"
		action="<%=request.getContextPath()%>/user/loginProcess.do">
		<img class="mb-4" src="<%=request.getContextPath()%>/images/logo.png"
			alt="" width="90" height="90">
		<h1 class="h3 mb-3 font-weight-normal">Familia de Mascotas</h1>
		<label for="inputEmail" class="sr-only">아이디</label> <input type="text"
			id="inputEmail" class="form-control" placeholder="아이디" required
			autofocus name="id"> <label for="inputPassword"
			class="sr-only">비밀번호</label> <input type="password"
			id="inputPassword" class="form-control" placeholder="비밀번호" required
			autofocus name="password">
		<div class="checkbox mb-3">



			<label> <a class="nav-link"
				href="<%=request.getContextPath()%>/jsp/user/signUpForm.jsp">회원가입</a>
			</label>
		</div>
		<button class="btn btn-lg btn-block" type="submit"
			style="background-color: #B9826E; color: #ffffff">로그인</button>

		<br>
		<br> <a id="kakao-login-btn"></a> <a
			href="http://developers.kakao.com/logout"></a>
		<script type='text/javascript'>
			//<![CDATA[
			// 사용할 앱의 JavaScript 키를 설정해 주세요.
			Kakao.init('a4f5e9d55f2847884536bb4fd3e04f1c');
			// 카카오 로그인 버튼을 생성합니다.
			Kakao.Auth.createLoginButton({
				container: '#kakao-login-btn',
			      success: function(authObj) {
			        // 로그인 성공시, API를 호출합니다.
			        Kakao.API.request({
			          url: '/v2/user/me',
			          success: function(res) {
 			            console.log(JSON.stringify(res));
			            console.log(res.id);
			            console.log(res.properties.nickname);
			            location.href = "<%=request.getContextPath()%>/user/kakaologin.do?id="+res.id+"&nickname="+res.properties.nickname;
			          },
			          fail: function(error) {
			            alert('카카오 계정 정보를 받아오는데 실패했습니다');
			          }
			        });
			      },
			      fail: function(err) {
			        alert('카카오 로그인에 실패했습니다');
			      }
			});
			//]]>
		</script>



		<p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
	</form>

</body>
</html>
