<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<script src="<%= request.getContextPath() %>/js/jquery-3.3.1.min.js"></script>
<script>

   $(document).ready(function() {
      $('#write').click(function() {
         location.href="<%= request.getContextPath()%>/menu/com_Free/com_FreeReg.do";
      });
   });
   
   function doAction(no) {
      <c:if test="${ not empty userVO }">
         location.href="<%= request.getContextPath() %>/menu/com_Free/com_FreeDetail.do?no="+no+"&type=list";
      </c:if>
      
      <c:if test="${ empty userVO }">
      var conf = confirm('로그인이 필요한 서비스 입니다. \n 로그인 하시겠습니까?');
      
      if(conf == true) {
         location.href="<%= request.getContextPath() %>/user/login.do?type=list";
      } else {
         location.href="<%= request.getContextPath()%>/menu/com_Free/com_FreeList.do?pageNo=1";
      }
      </c:if>
   }
</script>
<link href="<%=request.getContextPath()%>/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../../../include/header.jsp"></jsp:include><br><br><br><br>
<div align="center">
<br><br><br><jsp:include page="../../../include/header2.jsp"></jsp:include>
   <table style="width: 900px; text-align:center;" class="table table-striped">
   <tr>
   		
   </tr><tr></tr>
   <tr align="center">
      <th width="10%">번호</th>
      <th width="10%">품종</th>
      <th>제목</th>
      <th width="10%">글쓴이</th>
      <th width="10%">조회수</th>
      <th width="10%">등록일</th>
   </tr>
   <c:forEach items="${boardList}" var="board">
   <input type="hidden" value="자유게시판" name="cate">
      <tr>
         <td>${board.printno}</td>
         <td>${board.race}</td>
         <td style="text-align: left;">
            <a href="javascript:doAction(${board.no})">
               <c:out value="${ board.title }"/>
            </a>
         </td>
         <td>${board.writer}</td>
         <td>${board.view_cnt}</td>
         <td>${board.reg_date}</td>
      </tr>
   </c:forEach>
   </table>
   <br><br>
      <c:if test="${ not empty userVO }">
         <input type="button" class="btn" value="새글등록" id="write" style="background-color:#888888;">
      </c:if>
   <br><br>
   
    <c:forEach begin="1" end="${pageNum}" var="page"><a href="<%=request.getContextPath()%>/menu/com_Free/com_FreeList.do?pageNo=${page}">${page}</a> </c:forEach><br>
   <form method="post" action="<%=request.getContextPath() %>/menu/boardSearch.do">
   <input type="hidden" name="cate" value="자유게시판">
   <input type="hidden" name="url" value="/menu/com_Free/com_FreeList.jsp?pageNo=1">
    <select name="sel" style="height: 28px" class="control-label">
      <option name="title">제목</option>
      <option name="content">내용</option>      
      <option name="titcon">제목+내용</option>      
   </select>
   <input type="text" class="control-label" style="width:300px;" name="searchType">
   <input type="submit" class="btn" value="검색"> 
   </form>
</div>
</body>
</html>