//package board;
// 
//import java.io.IOException;
// 
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
// 
//public class BoardContentCommand implements BoardInterface {
// 
//  @Override
//  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    int idx = request.getParameter("idx")==null ? 0 : Integer.parseInt(request.getParameter("idx"));
//    
//    HttpSession session = request.getSession();
//    int rs = (int) session.getAttribute("sRs");
//    
//    BoardDAO dao = new BoardDAO();
//    
//    if(rs==0) {
//        dao.setReadNumUpdate(idx);
//        session.setAttribute("sRs", 1);
//    }
//    BoardVO vo = dao.getBoardContent(idx); 
//    request.setAttribute("vo", vo);
//  }
//}

package board;
 
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
public class BoardContentCommand implements BoardInterface {
 
  @SuppressWarnings("unchecked")
	@Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int idx = request.getParameter("idx")==null ? 0 : Integer.parseInt(request.getParameter("idx"));
    
    BoardDAO dao = new BoardDAO();
    
    // 글 조회수 1회 증가시키기 (조회수 중복방지처리 - 세션사용 : "'board' + 고유번호" 값을 객체배열(ArrayList)에 추가시킨다.)
    HttpSession session = request.getSession();
    
    ArrayList<String> contentIdx = (ArrayList<String>) session.getAttribute("sContentIdx");
    if(contentIdx == null) {
    	contentIdx = new ArrayList<String>();
    }
    String imsicontentIdx = "board"+idx;
    
    if(!contentIdx.contains(imsicontentIdx)) {
    	dao.setReadNumUpdate(idx);
    	contentIdx.add(imsicontentIdx);
    }
    
    session.setAttribute("sContentIdx", contentIdx);  // 첫번째 게시물에 들어왔을때 50~56
    
    // 현제 선택된 게시글(idx)의 전체내용물을 가져오기
    BoardVO vo = dao.getBoardContent(idx); 
    
    request.setAttribute("vo", vo);
  }
}







