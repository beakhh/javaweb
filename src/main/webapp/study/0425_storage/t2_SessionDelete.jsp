<!-- t2_SessionDelete.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	session.invalidate();  // 현재 브라우저를 통해서 저장된 세션은 모두 삭제
%>
<script>
  alert("세션에 저장 완료!!!  세션 값 : ${sMid}");   // 저장소에 있기 때문에el 표기법으로 사용
  location.href = "t2_SessionMain.jsp";
</script>