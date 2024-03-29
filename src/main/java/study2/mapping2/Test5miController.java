package study2.mapping2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("*.mi")
public class Test5miController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Test5miInterface command = null; 
		String viewPage = "/WEB-INF/study2/mapping2";
		
		String uri = request.getRequestURI();
		String com = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		
		if(com.equals("/Test5")) {
			viewPage += "/test5.jsp";
		}
		else if(com.equals("/Test5_2")) {
			viewPage += "/test5_2.jsp";
		}
		else if(com.equals("/Test5_3")) {
			command = new Test5DanCommand();
			command.execute(request, response);
			viewPage += "/test5_3.jsp";
		}
		else if(com.equals("/Test5_4")) {
			command = new Test5MsgCommand();
			command.execute(request, response);
			viewPage += "/test5_4.jsp";
		}
		else if(com.equals("/Test5_5")) {
			command = new Test5miCommand();  // 인터페이스로 객체를 만듬 -> Test5miInterface -> Test5miCommand 순으로 갔다 다시 돌아옴
			command.execute(request, response); // 값들을 받기위해 있음
			viewPage += "/test5_5.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
