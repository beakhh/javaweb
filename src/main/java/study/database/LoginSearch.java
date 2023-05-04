package study.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/database/LoginSearch")
public class LoginSearch extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = request.getParameter("mid")==null ? "" : request.getParameter("mid");
		
		LoginDAO dao = new LoginDAO();
		
		LoginVO vo = dao.getMidCheck(mid);
		
		PrintWriter out = response.getWriter();
		
		if(vo.getMid() != null) { // joinOk에서 가지고 옴
			//아이디 중복
			request.setAttribute("vo", vo);  //(담아온 vo, 보내야 하는 vo)
			String viewPage = "/study/0428_database/memberSearch.jsp";
			request.getRequestDispatcher(viewPage).forward(request, response);
		}
		else {
			dao.setJoinOk(vo);
			out.print("<script>");
			out.print("alert('회원정보가 업습니다.');");
			out.print("location.href='"+request.getContextPath()+"/study/0428_database/memberMain.jsp';");
			out.print("</script>");
			
		}
	}
}
