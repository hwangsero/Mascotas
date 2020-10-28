<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function doAction(type) {
		
		switch(type) {
		
		case 'L' : 
			location.href="<%= request.getContextPath() %>/menu/com_Review/com_ReviewList.do?pageNo=1";
			break;
		case 'U' :
			location.href = "<%= request.getContextPath() %>/menu/com_Review/com_ReviewUpdate.do?no=${param.no}";
			break; 
		case 'D' : 
			if(confirm("삭제하시겠습니까?")){
				location.href="<%= request.getContextPath() %>/menu/com_Review/com_ReviewDelete.do?no=${param.no}";
			}
			break;
		}
	}

</script>
</head>
<body>
		<div align="center">
		<hr width="80%">
		<h2>게시판 상세</h2>
		<hr width="80%">
		<br>
		<input type="hidden" value="${board.cate}" name="cate">
		<table>
			<tr>
				<th width="25%">번호</th>
				<td>${ board.printno }</td>
			</tr>
			<tr>
			<tr>
				<th width="25%">품종</th>
				<td>${ board.race }</td>
			</tr>
			<tr>
			<tr>
				<th width="25%">분류</th>
				<td>${ board.com_cate }</td>
			</tr>
			<tr>
				<th width="25%">제목</th>
				<td><c:out value="${ board.title }"/></td>
			</tr>
			<tr>
				<th width="25%">글쓴이</th>
				<td>${ board.writer }</td>
			</tr>
			<tr>
				<th width="25%">내용</th>
				<td><c:out value="${ board.content }"/></td>
				<c:forEach items="${ fileList }" var="file">
						<img style="width:500px; height:500x;"
						src="<%= request.getContextPath() %>/upload/${ file.file_save_name }">
						<%-- ${ file.file_ori_name } --%>
						<%-- <a href="/Mission-Web/jsp/board/download.jsp?fileName=${file.fileSaveName}" >
							다운로드
						</a> --%>
					</c:forEach>
			</tr>
			<tr>
				<th width="25%">조회수</th>
				<td>${ board.view_cnt }</td>
			</tr>
			<tr>
				<th width="25%">등록일</th>
				<td>${ board.reg_date }</td>
			</tr>
		</table>
		<br>
		<input type="button" value="수정" onclick="doAction('U')">&nbsp;&nbsp;
		<input type="button" value="삭제" onclick="doAction('D')">&nbsp;&nbsp;
		<input type="button" value="목록" onclick="doAction('L')">
	</div>
</body>
</html>