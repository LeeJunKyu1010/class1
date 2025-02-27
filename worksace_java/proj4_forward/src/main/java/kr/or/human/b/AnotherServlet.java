package kr.or.human.b;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/another")
public class AnotherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/another doGet실행");
		
		String text = request.getParameter("text");
		System.out.println("text : " + text);
		
		// send라는 주소를 입력하면 send와 연결한 another꺼를 실행한다
		// 응답으로 가야할 곳을 알려줌
		// 클라이언트가 해당 주소로 이동해줌
//		response.sendRedirect("http://www.naver.com");
		
		response.getWriter().println("사실 another");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/another doPost실행");
		
		String text = request.getParameter("text");
		System.out.println("text : " + text);
	}

}
