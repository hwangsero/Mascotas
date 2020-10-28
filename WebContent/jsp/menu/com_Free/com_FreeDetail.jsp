<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="<%=request.getContextPath()%>/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%= request.getContextPath() %>/js/jquery-3.3.1.min.js"></script>
<script src="<%= request.getContextPath() %>/vendor/bootstrap/js/bootstrap.min.js"></script>
<script>
function ajaxjs(number){
	var res = $('#co'+number).val();
	$.ajax({
		url : "<%= request.getContextPath() %>/menu/com_Free/comment.do",
		type : "get",
		data : {
			no :"${param.no}",
			parrent_no : number,
			id : "${userVO.id}",
			comment : res
		},
		success : callback
	});
}
$(document).ready(function() {
	var result = $('.copr').val();
	$.ajax({
		url : "<%= request.getContextPath() %>/menu/com_Free/comment.do",
		type : "get",
		data : {
			no :"${param.no}"
		},
		success : callback
	});
	$('#commentbtn').click(function() {
		
		var commentval = $('#comment').val();
		
		$.ajax({
			url : "<%= request.getContextPath() %>/menu/com_Free/comment.do",
			type : "get",
			data : {
				no :"${param.no}",
				id : "${userVO.id}",
				comment : commentval,
			}, 
			success : callback
		});
	});
});
function callback(data) {
/* 	$('#searchResult').empty(); */
	$('.copr').empty();
	$('.copr').append(data);
	/* var list = data.boxOfficeResult.dailyBoxOfficeList;
	var range = data.boxOfficeResult.showRange;
	for(var i = 0; i < list.length; i++) {
		var rank = list[i].rank;
		var name = list[i].movieNm;
		var audiCnt = list[i].audiCnt;
		var audiAcc = list[i].audiAcc;
		
		$('#searchResult').append('<hr>');
		$('#searchResult').append('<h4>조회날짜 : ' + range.split('~')[0] + '</h4>');
		$('#searchResult').append('<hr>');
		$('#searchResult').append('<h4>' + rank + '위</h4>');
		$('#searchResult').append('<strong>' + name + '</strong>(일 ' 
									+ audiCnt + '명/누적 ' + audiAcc + '명)<br>');
	} */
}
	function doAction(type) {
		
		switch(type) {
		
		case 'L' : 
			location.href="<%=request.getContextPath()%>/menu/com_Free/com_FreeList.do?pageNo=1";
			break;
		case 'U' :
			location.href = "<%=request.getContextPath()%>/menu/com_Free/com_FreeUpdate.do?no=${param.no}";
			break; 
		case 'D' : 
			if(confirm("삭제하시겠습니까?")){
				location.href="<%=request.getContextPath()%>/menu/com_Free/com_FreeDelete.do?no=${param.no}";
			}
			break;
		}
	}
</script>
</head>
<body>
	<jsp:include page="../../../include/header.jsp"></jsp:include><br>
	<br>
	<br>
	<br>
	<br>
	<div class="container" align="center"
		style="background-color: white; border-radius: 10px; text-align: left;">
		<input type="hidden" value="${board.cate}" name="cate"> <br>
		<h5>no.${board.printno}</h5>
		<hr class="hr-primary">
		<h2>${board.title}<h5 style="text-align: right">${board.reg_date}</h5></h2>
		<hr>

		<table>
			<tr style="color:#333;">
				<th width="25%">글쓴이&nbsp;</th>
				<td>${ board.writer }</td>
			</tr>
			<span style="float: right; margin-right: 30px;"><strong
				style="text-align: right;">조회수 </strong>&nbsp;&nbsp;${ board.view_cnt }</span>

			<%-- <tr>
				<th width="25%">내용</th>
				<td><c:out value="${ board.content }" /></td>
			</tr>
			<tr>
				<th width="25%">조회수</th>
				<td>${ board.view_cnt }</td>
			</tr>
			<tr>
				<th width="25%">등록일</th>
				<td>${ board.reg_date }</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td><c:forEach items="${ fileList }" var="file">
						<a
							href="<%= request.getContextPath() %>/upload/${file.file_save_name}">
							${ file.file_ori_name } </a>
						<a href="/Mission-Web/jsp/board/download.jsp?fileName=${file.fileSaveName}" >
							다운로드
						</a>
					</c:forEach></td>
			</tr> --%>
		</table>
		<br> <br>
		<tr>
				<td><c:forEach items="${ fileList }" var="file">
						<img
							src="<%= request.getContextPath() %>/upload/${file.file_save_name}">
					</c:forEach></td>
			</tr>
		<h4>${board.content}</h4>
		<br> <br>
		<div style="text-align: center;">
			<input type="button" class="btn" value="수정" onclick="doAction('U')">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" class="btn" value="삭제" onclick="doAction('D')">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" class="btn" value="목록" onclick="doAction('L')">
		</div>
		<br>
	</div>
	<br>
	<br>
	<div class="container"
		style="background-color: #B9826E; border-top-left-radius: 5px; border-top-right-radius: 5px; text-align: left; font-size: x-large;padding:5px;width:160px;margin-left:20%;color: #333;">
		&nbsp;&nbsp;
		<bold>댓글 목록</bold>
	</div>
	<div class="container"
		style="background-color: #ffffff; border-bottom-left-radius: 5px; border-bottom-right-radius: 5px;">
		<!-- &nbsp;&nbsp;<bold>댓글 쓴사람: 댓글</bold><br>
		&nbsp;&nbsp;<bold>댓글 쓴사람: 댓글</bold> -->
		<div>
				<h5 style="padding-top:7px;">${userVO.id}</h5>
				<table>
				<tr>
				<td width="93%">
				<textarea class="form-control" rows="2" cols="170" name="content" id="comment"></textarea>
				</td>
				<td width="7%">
				<input class="btn"
					style="font-size: large; background-color: #B9826E; color: #ffffff;float:right;margin-top:8px;"
					type="button" id="commentbtn" value="등록">&nbsp;&nbsp;
		</div><br><br></td>
		</tr>
		</table>
		<div class="copr">
		</div>
	</div>
</body>
</html>