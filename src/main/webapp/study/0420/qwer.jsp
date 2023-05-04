<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>title</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>  -->
  <script>
    'use strict';
    
    function fCheck() {
    	let su1 = document.getElementById("su1").value;
    	let su2 = document.getElementById("su2").value;
    	let su3 = document.getElementById("su3").value;
    	let su4 = document.getElementById("su4").value;
    	let su5 = document.getElementById("su5").value;
    	
    	if(isNaN(su1) || isNaN(su2) || isNaN(su3) || isNaN(su4) || isNaN(su5)) {
    		alert("다섯개의 숫자만 입력하셔야 합니다.");
    	}
    	else {
    	  myform.submit();
    	}
    }
  </script>
</head>
<body>
<p><br/></p>
<div class="container">
	<form name="myform" method="post" action="<%=request.getContextPath()%>/t0420/qwerOk">
		<h2>수 입력</h2>
		<div>
			수1 : <input type="number" name= "su" id="su1" class="form-control" />
		</div>
		<div>
			수2 : <input type="number" name= "su" id="su2" class="form-control"/>
		</div>
		<div>
			수3 : <input type="number" name= "su" id="su3" class="form-control"/>
		</div>
		<div>
			수4 : <input type="number" name= "su" id="su4" class="form-control"/>
		</div>
		<div>
			수5 : <input type="number" name= "su" id="su5" class="form-control"/>
		</div>
		<div>
			<input type="button" value="전송" onclick="fCheck()" class="btn btn-success mr-3"/>
		</div>
	</form>
</div>
<p><br/></p>
</body>
</html>