package study2.calendar;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study2.StudyInterface;

public class Calendar2Commond implements StudyInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// 오늘 날짜처리(저장)
			Calendar calToday = Calendar.getInstance();
			int toYear = calToday.get(Calendar.YEAR);
			int toMonth = calToday.get(Calendar.MONTH);
			int toDay = calToday.get(Calendar.DATE);
			
			// 화면에 보여줄 해당 '년/월'을 셋팅
			Calendar calView = Calendar.getInstance();
			int yy = request.getParameter("yy")==null? calView.get(Calendar.YEAR) : Integer.parseInt(request.getParameter("yy"));
			int mm = request.getParameter("mm")==null? calView.get(Calendar.MONTH) : Integer.parseInt(request.getParameter("mm"));
			
			if(mm < 0) {
				yy--;
				mm = 11;
			}
			if(mm > 11) {
				yy++;
				mm = 0;
			}
			
			// 해당 '년/월'의 1일을 기준으로 날짜를 셋팅처리한다.
			calView.set(yy, mm, 1);
			
			// 앞에서 셋팅한 해당 '년/월'의 1일에 해당하는 요일값을 숫자로 가져온다.("일:1, 월:2, 화:3,~~~)
			int startWeek = calView.get(Calendar.DAY_OF_WEEK);
			//System.out.println("해당월의 첫번째 1일의 요일을 숫자로 반환 : " + startWeek);
			
			// 해당 '년/월'의 마지막 일자를 가져온다.
			int lastDay = calView.getActualMaximum(Calendar.DAY_OF_MONTH);
			//System.out.println("해당월의 마지막 날짜 ? " + lastDay);
			
			// 출력된 달력의 '앞쪽/뒷쪽'의 빈공간에 해당월의 '이전/다음'의 날짜를 채워보자
			int prevYear = yy;
			int prevMonth = (mm)-1;
			int nextYear = yy;
			int nextMonth = (mm)+1;
			
			if(prevMonth == -1) {
				prevYear--;
				prevMonth = 11;
			}
			if(nextMonth == 12) {
				nextYear++;
				nextMonth = 0;
			}
			
			//현재월의 이전월에 해당하는 마지막 날짜를 구한다.
			Calendar calPre = Calendar.getInstance();
			calPre.set(prevYear, prevMonth,1);
			int preLastDay = calPre.getActualMaximum(Calendar.DAY_OF_MONTH);
			
			//다음월의 1일에에 해당하는 요일의 숫자값을 구한다.
			Calendar calNext = Calendar.getInstance();
			calNext.set(nextYear, nextMonth,1);
			int nextStartWeek = calNext.get(Calendar.DAY_OF_WEEK);
			
			request.setAttribute("prevYear", prevYear);
			request.setAttribute("prevMonth", prevMonth);
			request.setAttribute("nextYear", nextYear);
			request.setAttribute("nextMonth", nextMonth);
			request.setAttribute("preLastDay", preLastDay);
			request.setAttribute("nextStartWeek", nextStartWeek);
			
			
			
			// 화면에 보여줄 달력의 해당 내역(년/월/요일숫자..) 저장소에 저장하여 넘겨준다.
			request.setAttribute("yy", yy);
			request.setAttribute("mm", mm);
			request.setAttribute("startWeek", startWeek);
			request.setAttribute("lastDay", lastDay);
			
			// 오늘 날짜를 저장소에 담아서 넘겨준다.
			request.setAttribute("toYear", toYear);
			request.setAttribute("toMonth", toMonth);
			request.setAttribute("toDay", toDay);
		}

	}
