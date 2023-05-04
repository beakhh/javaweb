<!-- t2_SessionMidDelete.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	session.removeAttribute("sMid");
	session.removeAttribute("sName");
%>
<script>
  alert("세션에 저장된 아이디/성명 삭제 완료");   // 저장소에 있기 때문에el 표기법으로 사용
  location.href = "t2_SessionMain.jsp";
</script>