package study.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LoginDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	String sql = "";
	
	private LoginVO vo = null;
	
	public LoginDAO() {
		String url = "jdbc:mysql://localhost:3306/javaweb";
		String user = "root";
		String password = "1234";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패~~~");
		} catch (SQLException e) {
			System.out.println("Database 연동 실패~~~");
		}
	}
	
	// 사용한 객체의 반납(해제)
	public void pstmtClose() {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {}
		}
	}
	
	public void rsClose() {
		if(rs != null) {
			try {
				rs.close();
				pstmtClose();
			} catch (SQLException e) {}
		}
	}

	// 로그인 체크
	public LoginVO getLoginCheck(String mid, String pwd) {
		vo = new LoginVO();
		
		try {
			sql = "select * from login where mid=? and pwd=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setMid(rs.getString("mid"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setPoint(rs.getInt("point"));
				vo.setLastDate(rs.getString("lastDate"));
				vo.setTodayCount(rs.getInt("todayCount"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}

	// 방문포인트 증가시키기
	public void setPointPlus(String mid, int point, int todayCount) {
		try {
			sql = "update login set point=?, todayCount=?, lastDate=now() where mid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, point);
			pstmt.setInt(2, todayCount);
			pstmt.setString(3, mid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		
	}
	
	//아이디 검색 처리
	public LoginVO getMidCheck(String mid) {//1-1항상 리턴타입을 먼저 생각해야함
		LoginVO vo = new LoginVO();//1-2
		try {
			sql="select * from login where mid = ?";
			pstmt = conn.prepareStatement(sql); // 주의 틀림
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery(); // 자료 읽어오는 거
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setMid(rs.getString("mid"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setPoint(rs.getInt("point"));
				vo.setLastDate(rs.getString("lastDate"));
				vo.setTodayCount(rs.getInt("todayCount"));
				
				/*
        // 날짜 비교
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strToday = sdf.format(today); //오늘날짜!
        String lastDate = vo.getLastDate();
        if(!strToday.equals(lastDate.substring(0,10))) vo.setTodayCount(0);
        */
				vo.setTodayCount(compareDate(vo.getLastDate(),vo.getTodayCount()));
			}
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		
		return vo;//1-3  자료가 있으면 if 안에 들아가 자료를 다 넘기고 자료가 없으면 빈 값을 넘긴다.
	}

	// 회원가입 자료를 저장
	public void setJoinOk(LoginVO vo) {
		try {
			sql= "insert into login values (default,?,?,?,default,default,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.executeLargeUpdate();
		} catch (Exception e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		
		
	}
	//전체회원 조회
	public ArrayList<LoginVO> getLoginList() {
		ArrayList<LoginVO> vos = new ArrayList<>();
		try {
			sql = "select * from login order by idx desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) { //한건 이상일 확률이 높아서 if 가 아니라 while 사용
				vo = new LoginVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setMid(rs.getString("mid"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setPoint(rs.getInt("point"));
				vo.setLastDate(rs.getString("lastDate"));
				vo.setTodayCount(rs.getInt("todayCount"));
				
				/*
        // 날짜 비교
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strToday = sdf.format(today); //오늘날짜!
        String lastDate = vo.getLastDate();
        if(!strToday.equals(lastDate.substring(0,10))) vo.setTodayCount(0);
        */
				vo.setTodayCount(compareDate(vo.getLastDate(),vo.getTodayCount()));
				
				
				vos.add(vo);
			}
		} catch (Exception e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vos;
	}
	//날짜 비교 처리
	private int compareDate(String lastDate, int todayCount) {
		
		Date today = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String strToday = sdf.format(today); //시스템의 오늘날짜!
    //String lastDate = vo.getLastDate(); 위에서 lastDate을 넘겨 받았기 때문에 불필요
    if(!strToday.equals(lastDate.substring(0,10))) todayCount = 0; 
    
		return todayCount;
	}
	//개인정보 수정하기
	public int setUpdateOk(LoginVO vo) {
		int res = 0; //전에 int로 받아서 
		try {
			sql="update login set pwd=?, name=? where mid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPwd());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getMid());
			pstmt.executeUpdate();
			res=1;
			
		} catch (Exception e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
	//탈퇴 처리
	public int setDeleteOk(String mid) {
		int res = 0;
		try {
			sql = "delete from login where mid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.executeUpdate();
			res=1;
		} catch (Exception e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
	
}