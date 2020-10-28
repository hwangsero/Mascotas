<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="<%= request.getContextPath() %>/js/jquery-3.3.1.min.js"></script>
<script src="<%= request.getContextPath() %>/js/checkForm.js"></script>
<script>
<%--    
   $(document).ready(function() {
      $('input[type=file]')[0].value = '${ fileList[0].file_ori_name }';
      $('#list').click(function(){
         location.href="<%= request.getContextPath() %>/jsp/menu/com_FreeList.jsp";
      });
   });
   
    --%>
    
   $(document).ready(function() {
      $('#list').click(function(){
         location.href="<%= request.getContextPath() %>/menu/com_Free/com_FreeList.do?pageNo=1";
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
   <div class="container"align="center">
   <form method="post" action="<%=request.getContextPath()%>/menu/com_Free/com_FreeUpdateProcess.do?no=<%=request.getParameter("no")%>" name="wForm"
         enctype="multipart/form-data" onsubmit="return checkForm()">
         <input type="hidden" value="자유게시판" name="cate">
         <input type="hidden" value="<%=request.getParameter("no")%>" name="no">
         <input type="hidden" name="writer" value="${ userVO.id }">
         <table class="table-striped" style="width:100%;">
         <tr>
            <th>종류</th>
            <td>
            <c:if test="${board.race eq '강아지' }">
               <select name="race" class="form-control" style="width:90px;">
                  <option selected="selected">강아지</option>
                  <option>고양이</option>
               </select>
            </c:if>
            
            <c:if test="${board.race eq '고양이' }">
               <select name="race" class="form-control" style="width:90px;">
                  <option>강아지</option>
                  <option selected="selected">고양이</option>
               </select>
            </c:if>
               
            </td>
         <tr>
            <th>제목</th>
            <td>
               <input class="form-control" type="text" name="title" size="100" value="${board.title}">
            </td>
         </tr>
         <tr>
            <th>글쓴이</th>
               <td>${ userVO.id }</td>
         </tr>
      </table>
      <br>
      <div class="container" style="background-color:#ffffff;border-radius:10px;padding-top:16px;padding-bottom: 16px;">
      		<textarea class="form-control" rows="7" cols="100" name="content" >${board.content}</textarea>
      </div>
      <br>
       
      <table class="table-striped" style="width:100%;">
      	<tr>
            <th>첨부파일</th>
            <td>
               <input class="form-control"  type="file" name="attachfile1"> 
               <input class="form-control" type="file" name="attachfile2"> 
            </td>
         </tr>
      </table><br>
      <div style="">
      <input class="btn" style="font-size: large;background-color:#B9826E;color:#ffffff" type="submit" value="수정">&nbsp;&nbsp;
      <input class="btn" style="font-size: large;background-color:#B9826E;color:#ffffff" type="button" id="list" value="목록"> 
      </div><br>
   </form>
   </div>
</body>
</html>