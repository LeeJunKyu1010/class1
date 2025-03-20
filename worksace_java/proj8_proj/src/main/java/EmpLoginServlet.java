import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class EmpLoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("EmpLoginServlet doPost 실행");
		// 로그인 요청 파라미터 추출
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		// EmpDAO를 통해 사용자 정보 조회
		EmpDAO empDAO = new EmpDAO();
		EmpDTO user = empDAO.getUserInfo(id, pw);
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("EmpServlet");
		}
		else {
			// 로그인 실패 시 에러 메시지 전달
			request.setAttribute("error", "아이디 또는 비밀번호를 확인해주십시오.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}