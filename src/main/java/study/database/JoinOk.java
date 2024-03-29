package study.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/database/JoinOk")
public class JoinOk extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = request.getParameter("mid")==null ? "" : request.getParameter("mid");
		String pwd = request.getParameter("pwd")==null ? "" : request.getParameter("pwd");
		String name = request.getParameter("name")==null ? "" : request.getParameter("name");
		
		LoginVO vo = new LoginVO();
		vo.setMid(mid);
		vo.setPwd(pwd);
		vo.setName(name);
		
		LoginDAO dao = new LoginDAO();
		
		LoginVO vo2 = dao.getMidCheck(mid); // 21번줄 vo와 변수를 같이 두면 덮어쓰기가 되어서 변수를 다르게 줌
		
		PrintWriter out = response.getWriter();
		
		if(vo2.getMid() != null) {
			//아이디 중복
			out.print("<script>");
			out.print("alert('아이디가 중복되었습니다.');");
			out.print("location.href='"+request.getContextPath()+"/study/0428_database/join.jsp';"); // Path임 주의 틀림
			out.print("</script>");
			
		}
		else {
			//아이디가 중복이 되어 있지 않아서 자료를 등록
			dao.setJoinOk(vo);
			out.print("<script>");
			out.print("alert('회원에 가입되었습니다.');");
			out.print("location.href='"+request.getContextPath()+"/study/0428_database/login.jsp';");
			out.print("</script>");
			
		}
	}
}




























