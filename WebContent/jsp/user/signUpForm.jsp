<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="<%=request.getContextPath()%>/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/vendor/bootstrap/js/validator.min.js"
	rel="stylesheet">
<link rel="icon" href="<%=request.getContextPath()%>/images/logo.ico"
	type="image/x-icon">
<title>Insert title here</title>
<style>
body {
	background-color: #FEF5EB;
}

.jumbotron {
	width: 100%;
	padding: 20px;
	background-color: #F6E3D0;
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="../../include/header.jsp"></jsp:include>
	<div align="center">
		<br> <br> <br> <br> <br> <br> <br>
		<br> <br>
		<form action="<%=request.getContextPath()%>/user/signUpForm.do"
			name="joinForm" method="post" data-toggle="validator" role="form">

			<table>
				<tr>
					<th style="padding-top: 25px;">아이디</th>
					<td><table>
							<tr>
								<td><input class="form-control" name="id" id="inputEmail"
									type="text" size="37" placeholder="*4자이상 20자 이하 " required
									autofocus></td>&nbsp;&nbsp; &nbsp;&nbsp;
								<td><input class="btn" type="button" value="중복확인"
									onclick="idCheck()"></td>
							</tr>
						</table></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input class="form-control" name="password"
						id="inputPassword" type="password" size="45" required></td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td><input class="form-control" name="pwCheck" type="password"
						id="inputPassword" data-match="#inputPassword"
						data-match-error="비밀번호와 서로 다릅니다" size="45" required></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input class="form-control" name="name" type="text"
						size="45" required autofocus></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><table>
							<tr>
								<td><input name="email_id" type="text" class="form-control"
									id="inlineFormInput" placeholder="asdf1234" size="16">

									<div class="input-group">
										<div class="input-group-prepend"></td>
								<td>
									<div class="input-group-text">@</div>
								</td>
								<td>
									</div> <input name="email_domain" type="text" class="form-control"
									id="inlineFormInputGroup" placeholder="gmail.com" size="16">
									</div>
								</td>
							</tr>
						</table></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input class="form-control" name="basic_addr" type="text"
						size="45" placeholder="예) 서울시 서초구 서초동" required autofocus></td>
				</tr>
				<tr>
					<th>상세주소</th>
					<td><input class="form-control" name="detail_addr" type="text"
						size="45" placeholder="예)광덕대로 123-1 100동 100호" required autofocus></td>
				</tr>
			</table>
			<br> <br> <input class="btn" type="submit" value="회원가입"
				id="join"> <input class="btn" type="reset" value="다시 입력">
		</form>
	</div>

</body>
</html>