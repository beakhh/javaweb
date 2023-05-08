package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BoardContentCommand implements BoardInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = request.getParameter("idx")==null ? 0 : Integer.parseInt(request.getParameter("idx"));
		
		HttpSession session = request.getSession();
//		session.setAttribute("sRs", 0);
		session.getAttribute("sRs");
		int rs = (int) session.getAttribute("sRs");
		
		BoardDAO dao = new BoardDAO();
		System.out.println("rs1 " + rs);
		if(rs==0) {
			dao.setReadNumUpdate(idx);
			session.setAttribute("sRs", 1);
		}
		else {
			
		}
		BoardVO vo = dao.getBoardContent(idx); 
		request.setAttribute("vo", vo);
		System.out.println("rs2 " + rs);
		
	}
}
