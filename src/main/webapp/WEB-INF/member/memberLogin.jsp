<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1"/>
	<title>title</title>
	<jsp:include page="/include/bs4.jsp"/>
  <style>
  </style>
  <script>
    'use strict';
  </script>
</head>
<body>
<jsp:include page="/include/header.jsp" />
<p><br/></p>
<div class="container">
	<div class="modal-dialog ">
	<div class="modal-content p-4">
		<h2 class="text-center">회원 로그인</h2>
		<p class="text-center">회원 아이디와 비밀번호를 입력해 주세요</p>
	  <form name="myform" method="post" action="${ctp}/MemberInput.mem" class="was-validated">
	    <div class="form-group">
	      <label for="mid">회원 아이디</label>
	      <input type="text" class="form-control" id="mid" name="mid" value="${mid}" placeholder="Enter username"  required autofocus />
	      <div class="valid-feedback">Ok!!!</div>
	      <div class="invalid-feedback">아이디를 입력해 주세요</div>
	    </div>
	    <div class="form-group">
	      <label for="pwd">비밀번호</label>
	      <input type="password" class="form-control" id="pwd" name="pwd" placeholder="Enter password" required  />
	      <div class="valid-feedback">Ok!!!</div>
	      <div class="invalid-feedback">비밀번호를 입력해 주세요</div>
	    </div>
	    <div class="form-group text-center" >
	    	<button type="submit" class="btn btn-primary mr-1">로그인</button>
	    	<button type="reset" class="btn btn-warning mr-1">다시입력</button>
	    	<button type="button" onclick="location.href='${ctp}/';" class="btn btn-danger mr-1">돌아가기</button>
	    	<button type="button" onclick="location.href='${ctp}/MemberJoin.mem';" class="btn btn-success mr-1">회원가입</button>
	    </div>
	    <div class="row" style="font-size:12px">
	    	<span class="col"><input type="checkbox" name="idSave" checked/>아이디 저장</span>
	    	<span class="col">
	    		[<a href="#">아이디 찾기</a>] <!-- 이메일로 찾기 -->
	    		[<a href="#">비밀번호 찾기</a>]	<!-- 아이디랑 이메일로 -->
	    	</span>
	    </div>
	    </div>
	    <input type="hidden" name="hostIp" value="<%=request.getRemoteAddr()%>"/>
	  </form>
  </div>
</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp" />
</body>
</html>