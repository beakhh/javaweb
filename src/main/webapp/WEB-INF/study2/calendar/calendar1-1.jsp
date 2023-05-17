<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>calendar.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
</head>
<body>
<jsp:include page="/include/header.jsp" />
<p><br/></p>
<div class="container">
  <div class="text-center">
	  <button type="button" onclick="location.href='${ctp}/Calendar.st?yy=${yy-1}&mm=${mm}';" class="btn btn-secondary btn-sm" title="이전년도">◁◁</button>
	  <button type="button" onclick="location.href='${ctp}/Calendar.st?yy=${yy}&mm=${mm-1}';" class="btn btn-secondary btn-sm" title="이전월">◀</button>
	  <font size="5">${yy}년 ${mm+1}월</font>
	  <button type="button" onclick="location.href='${ctp}/Calendar.st?yy=${yy}&mm=${mm+1}';" class="btn btn-secondary btn-sm" title="다음월">▶</button>
		<button type="button" onclick="location.href='${ctp}/Calendar.st?yy=${yy+1}&mm=${mm}';" class="btn btn-secondary btn-sm" title="다음년도">▷▷</button>
		&nbsp;&nbsp;
		<button type="button" onclick="location.href='${ctp}/Calendar.st';" class="btn btn-secondary btn-sm" title="오늘날짜">홈</button>
  </div>
  <br/>
  <div class="text-center">
    <table class="table table-bordered" style="height:450px">
      <tr class="table-dark text-dark">
        <th style="color:red">일</th>
        <th>월</th>
        <th>화</th>
        <th>수</th>
        <th>목</th>
        <th>금</th>
        <th style="color:blue">토</th>
      </tr>
      <tr>
      	<!-- 시작일 이전을 공백처리한다.(오늘이 월요일이면 startWeek가 2이기에 1칸을 공백처리한다. -->
      	<c:set var="gap" value="1"/>
      	<c:forEach begin="1" end="${startWeek - 1}">
      	  <td>&nbsp;</td>
      	  <c:set var="gap" value="${gap + 1}"/>
      	</c:forEach>
      	
      	<!-- 해당월에 대한 첫째주 날짜부터 출력하되, gap이 7이되면 줄바꿈한다. -->
      	<c:forEach begin="1" end="${lastDay}" varStatus="st">
      	  <td>${st.count}</td>
      	  <c:if test="${gap % 7 == 0}"></tr><tr></c:if>
      	  <c:set var="gap" value="${gap + 1}"/>
      	</c:forEach>
      </tr>
    </table>
  </div>
</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp" />
</body>
</html>