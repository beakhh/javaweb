package study.t0420;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/t0420/qwerOk")
public class qwerOk extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String [] sus = request.getParameterValues("su");
		
		String strsu="";
		for(String su : sus) strsu += su + "/";
		
		System.out.println(strsu);
		
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/study/0420/qwerRes.jsp");
		 dispatcher.forward(request, response);
	}
	
}
