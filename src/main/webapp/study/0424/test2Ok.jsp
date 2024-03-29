<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 스쿠릿틀릿 대신에 jstl을 사용한다. -->
<!-- 앞에서 전송된 값들을 변수!!에 담아보자! -->
<!-- jsp에서 객체를 사용하기 위해선 해당 객체를 jsp액션태그(useBean) 생성해야 한다.  -->
<jsp:useBean id="vo" class="study.t0424.Test1VO" />

<!-- 서블릿에선,getProperty(getter())와 setProperty(setter())을 이용해서 값을 불러오거나 저장시켜준다. -->
<!-- jsp에서는 getProperty와 setProperty을 이용해서 값을 불러오거나 저장시켜준다. -->

<jsp:setProperty property="*" name="vo"/>  <!-- 변수명을 통일하는 이유 -->

 
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>test2Ok.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
</head>
<body>
<p><br/></p>
<div class="container">
  <h3>처리된 자료를 view에 출력시켜본다.</h3>
  <div>
    <table class="table table-bordered">
      <tr>                              
        <th>성명</th>
        <td><%=vo.getName() %></td>
      </tr>
      <tr>
        <th>나이</th>
        <td><%=vo.getAge() %></td>
      </tr>
      <tr>
        <th>성별</th>
        <td><%=vo.getGender() %></td>
      </tr>
      <tr>
        <th>직업</th>
        <td><%=vo.getJob() %></td>
      </tr>
      <tr>
        <th>주소</th>
        <td><%=vo.getAddress() %></td>
      </tr>
    </table>
    <p>
      <a href="test2.jsp" class="btn btn-warning">돌아가기</a>
    </p>
  </div>
</div>
<p><br/></p>
</body>
</html>