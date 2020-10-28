<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/board.css">
<script>
</script>
</head>
<body>
<div align="center">
<hr>
<h2>애견상식 게시판</h2>
<hr>
	<table style="width: 800px">
	<tr align="center">
		<th width="5%">번호</th>
		<th width="10%">품종</th>
		<th>제목</th>
		<th width="10%">글쓴이</th>
		<th width="7%">조회수</th>
		<th width="10%">등록일</th>
	</tr>
	<c:forEach items="${boardList }" var="board">
		<tr>
			<td >${board.printno }</td>
			<td >${board.race }</td>
			<td >${board.title }</td>
			<td >${board.writer }</td>
			<td >${board.view_cnt }</td>
			<td >${board.reg_date }</td>
		</tr>
	</c:forEach>

	</table>
	 <c:forEach begin="1" end="${pageNum }" var="page"><a href="<%=request.getContextPath()%>/menu/petTip.do?pageNo=${page}">${page }</a> </c:forEach><br>
	<form href="<%=request.getContextPath() %>/menu/boardSearch.do?pageNo=1">
	<input type="hidden" name="cate" value="애견상식">
	<input type="hidden" name="url" value="/petTip.jsp?pageNo=1">
	 <select name="sel" style="height: 20px">
		<option name="title">제목</option>
		<option name="content">내용</option>		
		<option name="titcon">제목+내용</option>		
	</select>
	<input type="text" style="height: 14px" name="searchType">
	<input type="submit" value="검색"> 
	</form>
</div>
</body>
</html>