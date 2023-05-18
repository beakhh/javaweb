<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>crimeApi.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
  <script>
    'use strict';
    
    const API_KEY = 'V0sC01r5SrGj8fQpV6rU7gjEAA%2F%2F7PhasyuGhxJcwPQL%2Bq86d2Vp7E2be%2FOc4Z%2F4MiB%2FVcpv5dbMENEIQWVs7Q%3D%3D';
    
    // 외부 데이터를 가져오는 방식? fetch방식 -> JSON형식
    		
    async function getCrimeData() {
    	let apiYear = "";
    	
    	apiYear = "/15084592/v1/uddi:fbbfd36d-d528-4c8e-aa9b-d5cdbdeec669";
    	
    	let url = "https://api.odcloud.kr/api" + apiYear;
    	url += "?serviceKey="+API_KEY;
    	
    	const response = await fetch(url);
    	
    	const res = await response.json();
    	
    	console.log("res : ", res);
    	
    	/*
    	let str = "";
    	for(let i=0; i<res.data.length; i++) {
    		str += res.data[i] + "<br/>";
    	}
    	*/
    	
    	let str = res.data.map((item, i) => [
    		(i+1) + "." 
    		+ "발생년도: " + item.발생년도 + "년"
    		+ ",경찰서: " + item.경찰서
    		+ ", 강도 " + item.강도 + "건"
    		+ ", 살인 " + item.살인 + "건"
    		+ ", 절도 " + item.절도 + "건"
    		+ ", 폭력 " + item.폭력 + "건"
    		+ "<br/>" 
    	]);
    	
    	$("#demo").html(str);
    }
  </script>
</head>
<body>
<jsp:include page="/include/header.jsp" />
<p><br/></p>
<div class="container">
  <h2>경찰청_전국 경찰서별 강력범죄 발생 현황</h2>
  <hr/>
  <p>
    <input type="button" value="강력범죄자료조회" onclick="getCrimeData()" class="btn btn-success"/>
  </p>
  <p>
    <input type="button" value="돌아가기" onclick="location.href='${ctp}/ApiTest.st';" class="btn btn-warning"/>
  </p>
  <hr/>
  <div id="demo"></div>
  <hr/>
</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp" />
</body>
</html>