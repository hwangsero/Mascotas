<%@page import="miniproject.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	UserVO log = (UserVO) session.getAttribute("userVO");
	session.removeAttribute("userVO");
%>
<script>
	alert('�α׾ƿ��Ͽ����ϴ�');
	location.href = "<%=request.getContextPath()%>/index.jsp";
</script>