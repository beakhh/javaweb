<!-- test3Res.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
%>
	<script>
	  alert("<%=name%>자료가 저장되었습니다");
	  location.href = '<%=request.getContextPath()%>/study/0420/test3.jsp';  <%-- <% %> 사용한 이유는 자바 명령어를 jsp에서 사용하기 때문에 --%>
	</script>