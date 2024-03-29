<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>upLoad2.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
  <script>
    'use strict';
    
    function fCheck() {
    	let fName1 = document.getElementById("file1").value;
    	let fName2 = document.getElementById("file2").value;
    	let fName3 = document.getElementById("file3").value;
			let ext1 = fName1.substring(fName1.lastIndexOf(".")+1).toUpperCase();
			let ext2 = fName2.substring(fName2.lastIndexOf(".")+1).toUpperCase();
			let ext3 = fName3.substring(fName3.lastIndexOf(".")+1).toUpperCase();
			let maxSize = 1024 * 1024 * 10; // 업로드 가능파일은 5MByte까지로 한다.
			
			if(fName1.trim() == "" || fName2.trim() == "" || fName3.trim() == "") {
				alert("업로드할 파일을 선택하세요");
			}
			
			let fileSize1 = document.getElementById("file1").files[0].size;
			let fileSize2 = document.getElementById("file2").files[0].size;
			let fileSize3 = document.getElementById("file3").files[0].size;
			let fileSize = fileSize1 + fileSize2 + fileSize3;
			if(ext1 != "JPG" && ext1 != "GIF" && ext1 != "PNG" && ext1 != "ZIP" && ext1 != "HWP" && ext1 != "PPT" && ext1 != "PPTX") {
				alert("업로드 가능한 파일은 'jpg/gif/png/zip/hwp/ppt/pptx' 입니다.");
			}
			else if(ext2 != "JPG" && ext2 != "GIF" && ext2 != "PNG" && ext2 != "ZIP" && ext2 != "HWP" && ext2 != "PPT" && ext2 != "PPTX") {
				alert("업로드 가능한 파일은 'jpg/gif/png/zip/hwp/ppt/pptx' 입니다.");
			}
			else if(ext3 != "JPG" && ext3 != "GIF" && ext3 != "PNG" && ext3 != "ZIP" && ext3 != "HWP" && ext3 != "PPT" && ext3 != "PPTX") {
				alert("업로드 가능한 파일은 'jpg/gif/png/zip/hwp/ppt/pptx' 입니다.");
			}
			else if(fileSize > maxSize) {
				alert("1회 업로드할 파일의 최대용량은 10MByte 입니다.")
			}
			else {
				//alert("전송완료");
				myform.submit();
			}
    }
  </script>
</head>
<body>
<jsp:include page="/include/header.jsp" />
<p><br/></p>
<div class="container">
  <h2>파일 업로드 연습(멀티파일처리)</h2>
  <p>COS라이브러리를 이용한 파일 업로드</p>
  <div>(http://servlets.com/cos/)</div>
  <hr/>
  <form name="myform" method="post" action="${ctp}/FileUpLoad2Ok.st" enctype="multipart/form-data">
    파일명 : 
    <input type="file" name="fName1" id="file1" class="form-control-file border mb-2">
    <input type="file" name="fName2" id="file2" class="form-control-file border mb-2">
    <input type="file" name="fName3" id="file3" class="form-control-file border mb-2">
    <input type="button" value="전송" onclick="fCheck()" class="btn btn-success form-control"/>
  </form>
   <hr/>
  <input type="button" value="다운로드사이트로이동" onclick="location.href='${ctp}/DownLoad.st';" class="btn btn-secondary"/>
</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp" />
</body>
</html>