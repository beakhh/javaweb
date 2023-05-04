package study2.mapping2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Test5miInterface {
	//public void execute(); // 추상 메소드 
	public void execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException ; // 웹에서 요류나는거 막아줌 throws ServletException, IOException
	
}
