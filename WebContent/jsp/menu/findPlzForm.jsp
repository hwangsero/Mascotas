<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
찾아주세요 양식

<form method = "post" action="<%=request.getContextPath() %>/menu/findPlzProcess.do" enctype="multipart/form-data">
<input type="text" name = "cate">
<input type="text" name = "race">
<input type="text" name = "sex">
<input type="text" name = "age">
<input type="text" name = "name">
<input type="text" name = "lostDate">
<input type="text" name = "lostSpot">
<input type="text" name = "feature">
<input type="text" name = "etc">
<input type="text" name = "writer">
<input type="text" name = "tel">
<input type="submit">
</form>
</body>
</html>