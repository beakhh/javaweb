package study.t0419;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/t10")
public class Test10 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("text/html; charset=utf-8");
		PrintWriter out = response.getWriter(); //이거 써야 out 에러 사라짐
		
		String mid = request.getParameter("mid");
	  String pwd = request.getParameter("pwd");
	  
	  // admin, hkd1234, ~~~~~~  비밀번호: 1234
	  if((mid.equals("admin") || mid.equals("hkd1234")) && pwd.equals("1234")) {
	  	out.println("<script>");
	  	out.println("alert('회원인증 성공!!!!!!!!!!!!!!!!!!!');");
	  	out.println("location.href = '"+request.getContextPath()+"/study/0419/test10Success.jsp';");  // webapp이 현 주소임 여길 기준으로 경로 계산
	  	out.println("</script>");
	  }
	  else {
			out.println("<script>");
	  	out.println("alert('회원인증 실패~~~~~~~~~~~~~~~~~~~');");
	  	out.println("location.href = '"+request.getContextPath()+"/study/0419/test10.jsp';");
	  	out.println("</script>");
	  }
	}
}
