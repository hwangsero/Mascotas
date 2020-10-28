<%@page import="miniproject.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	UserVO log = (UserVO) session.getAttribute("userVO");
	session.removeAttribute("userVO");
%>
<script>
	alert('로그아웃하였습니다');
	location.href = "<%=request.getContextPath()%>/index.jsp";
</script>