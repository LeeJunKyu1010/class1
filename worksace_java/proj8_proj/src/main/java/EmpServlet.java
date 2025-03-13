
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    HttpSession session = request.getSession();
	    EmpDTO user = (EmpDTO) session.getAttribute("user");
	    
	    if (user != null) {
	        
	    	request.setAttribute("user", user); // 사용자 정보를 request attribute로 설정
	        request.getRequestDispatcher("mainpage.jsp").forward(request, response);
	    } else {
	        // 로그인되지 않은 경우 로그인 페이지로 리다이렉트
	        response.sendRedirect("login.jsp");
	    }
	}



}


