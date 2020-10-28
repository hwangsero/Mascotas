<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="<%= request.getContextPath() %>/js/checkForm.js"></script>
<script>
	<c:if test="${ empty userVO }">
		var conf = confirm('로그인이 필요한 서비스 입니다. \n 로그인 하시겠습니까?');
		
		if(conf == true) {
			location.href="<%= request.getContextPath() %>/user/login.do";
		} else {
			location.href="<%= request.getContextPath() %>/jsp/menu/com_Review/com_ReviewList.do?pageNo=1";
		}
	</c:if>
	$(document).ready(function() {
		$('#list').click(function(){
			location.href="<%= request.getContextPath() %>/jsp/menu/com_ReviewList.jsp";
		});
	});
	
	function checkForm() {
		var f = document.wForm;
		
		if(f.title.value == ''){
			alert('제목을 입력하세요');
			f.title.focus();
			return false
		}
		if(f.writer.value == ''){
			alert('글쓴이를 입력하세요');
			f.writer.focus();
			return false

		}
		
		if(f.content.value == ''){
			alert('내용을 입력하세요');
			f.content.focus();
			return false
		}
		
		//확장자 체크
	if(checkExt(f.attachfile1))
		return false;
	if(checkExt(f.attachfile2))
		return false;
	
	return true;	
	}
</script>
</head>
<body>
	<jsp:include page="../../../include/header.jsp"></jsp:include><br><br><br><br><br>
	<div align="center">
	<form method="post" action="<%=request.getContextPath()%>/menu/com_Review/com_ReviewRegForm.do" name="wForm"
			enctype="multipart/form-data" onsubmit="return checkForm()">
			<input type="hidden" value="후기게시판" name="cate">
			<input type="hidden" name="writer" value="${ userVO.id }">
			<table class="table-striped" style="width:100%;" border="1">
			<tr>
				<th>종류</th>
				<td>
					<select name="race" class="form-control" style="width:90px;">
						<option>강아지</option>
						<option>고양이</option>
					</select>
				</td>
			<tr>
			<tr>
				<th>분류</th>
				<td>
					<select name="com_cate" class="form-control" style="width:120px;">
						<option>재회후기</option>
						<option>나눔후기</option>
					</select>
				</td>
			<tr>
				<th>제목</th>
				<td>
					<input class="form-control" type="text" name="title" size="100">
				</td>
			</tr>
			<tr>
				<th>글쓴이</th>
					<td>${ userVO.id }</td>
			</tr>
			<tr>
				<th width="23%">내용</th>
				<td>
					<textarea class="form-control" rows="7" cols="100" name="content"></textarea>
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
					<input  class="form-control" type="file" name="attachfile1">
					<input class="form-control" type="file" name="attachfile2">
				</td>
			</tr>
		</table>
		<br>
		<div style="">
		<input class="btn" style="font-size: large;background-color:#B9826E;color:#ffffff" type="submit" value="등록">&nbsp;&nbsp;
		<input class="btn" style="font-size: large;background-color:#B9826E;color:#ffffff" type="button" id="list" value="목록"> 
		</div>
	</form>
	</div>
</body>
</html>
