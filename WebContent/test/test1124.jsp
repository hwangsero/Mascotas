<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link
	href="<%=request.getContextPath()%>/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<script src="<%= request.getContextPath() %>/js/jquery-3.3.1.min.js"></script>
<script src="<%= request.getContextPath() %>/vendor/bootstrap/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<p>
		<a class="btn btn-primary" data-toggle="collapse"
			href="#collapseExample" role="button" aria-expanded="false"
			aria-controls="collapseExample"> Link with href </a>
		<button class="btn btn-primary" type="button" data-toggle="collapse"
			data-target="#collapseExample" aria-expanded="false"
			aria-controls="collapseExample">Button with data-target</button>
	</p>
	<div class="collapse" id="collapseExample">
		<div class="card card-body">Anim pariatur cliche reprehenderit,
			enim eiusmod high life accusamus terry richardson ad squid. Nihil
			anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt
			sapiente ea proident.</div>
	</div>
</body>
</html>