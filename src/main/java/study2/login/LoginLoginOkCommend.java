package study2.login;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginLoginOkCommend implements LoginInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = request.getParameter("mid")==null ? "" : request.getParameter("mid");
		String pwd = request.getParameter("pwd")==null ? "" : request.getParameter("pwd");
		
		LoginDAO dao = new LoginDAO();
		
		LoginVO vo = dao.getLoginCheck(mid, pwd);
		
		if(vo.getName() != null) {
			// 날짜 비교
			Date today = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String strToday = sdf.format(today);
			
			int todayCount = vo.getTodayCount();
			int point = 0;
			String lastDate = vo.getLastDate();
			if(strToday.equals(lastDate.substring(0,10))) {
				todayCount++;
				if(vo.getTodayCount() < 5) point = vo.getPoint() + 10;
				else point = vo.getPoint();
			}
			else {
				todayCount = 1;
				point = vo.getPoint() + 10;
			}
			
			dao.setPointPlus(mid, point, todayCount);
			
			vo = dao.getLoginCheck(mid, pwd);			
			
			HttpSession session = request.getSession();
			session.setAttribute("sMid", mid);
			session.setAttribute("sName", vo.getName());
			session.setAttribute("sPoint", vo.getPoint());
			session.setAttribute("sLastDate", lastDate);
			session.setAttribute("sTodayCount", vo.getTodayCount());
			
			String idSave = request.getParameter("idSave")==null ? "off" : "on";
			System.out.println("idSave : " + idSave);
			Cookie cookieMid = new Cookie("cMid", mid);
			cookieMid.setPath("/");
			if(idSave.equals("on")) {
				cookieMid.setMaxAge(60*60*24*7);
			}
			else {
				cookieMid.setMaxAge(0);
			}
			response.addCookie(cookieMid);
			
			request.setAttribute("msg", mid + "님 로그인 되었습니다.");
			request.setAttribute("url", request.getContextPath()+"/MemberMain.re");
		}
		else {
			// 회원 인증 실패시 처리... 다시 로그인창으로 보내준다.
			request.setAttribute("msg", mid + "님 로그인 실패 하였습니다.");
			request.setAttribute("url", request.getContextPath()+"/Login.re");
			
		}
	}
}














