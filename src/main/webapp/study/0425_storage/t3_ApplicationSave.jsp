<!-- t2_SessionSave.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String mid = request.getParameter("mid")==null? "admin": request.getParameter("mid");
	String nickName = request.getParameter("nickName")==null? "관리맨": request.getParameter("nickName");
	String name = request.getParameter("name")==null? "관리자": request.getParameter("name");
	
	application.setAttribute("aMid", mid);
	application.setAttribute("aNickName", nickName);
	application.setAttribute("aName", name);
%>
<script>
  alert("세션에 저장 완료!!!  세션 값 : ${aMid}");   // 저장소에 있기 때문에el 표기법으로 사용
  location.href = "t3_ApplicationMain.jsp";
</script>