<!-- test1ResJaje -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String mid = request.getParameter("mid")==null? "" :request.getParameter("mid") ;
	String pwd = request.getParameter("pwd")==null? "" :request.getParameter("pwd") ;
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>test1ResInsa.jsp</title>
	<jsp:include page="/include/bs4.jsp"/>
  <style>
  </style>
  <script>
    'use strict';
  </script>
</head>
<body>
<p><br/></p>
<div class="container">
	<h2>이곳은 자제과 화면 입니다.</h2>
	<p>아이디 : <%=mid %></p>
	<%-- <p>비밀번호 : <%=pwd %></p> --%>
	<hr/>
	<p><a href="test1.jsp" class="btn btn-info">돌아가기</a></p>
</div>
<p><br/></p>
</body>
</html>