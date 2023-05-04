<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>title</title>
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
	<h2>성적 처리 결과</h2>
	<p>성명 : ${name} </p>
	<p>학번 : ${hakbun} </p>
	<p>국어 : ${kor} </p>
	<p>영어 : ${eng} </p>
	<p>수학 : ${mat} </p>
	<p>사회 : ${soc} </p>
	<p>과학 : ${sci} </p>
	<p>총점 : ${tot} </p>
	<p>평균 : ${avg} </p>
	<p>학점 : ${grade} </p>
	<p><a href="<%=request.getContextPath() %>/study/0423/test1.jsp" class="btn btn-secondary">돌아가기</p>
	<p><a href="<%=request.getContextPath() %>/study/0423/test1.jsp" class="btn btn-secondary">돌아가기</p>

	
</div>
<p><br/></p>
</body>
</html>