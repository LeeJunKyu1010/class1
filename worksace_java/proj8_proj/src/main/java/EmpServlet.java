import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("EmpServlet doGet 실행");
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("user") != null) {
			System.out.println("EmpServlet 세션 실행");
			EmpDTO user = (EmpDTO) session.getAttribute("user");
			System.out.println("사용자 정보:");
			System.out.println("사원 번호: " + user.getEmpNo());
			System.out.println("아이디: " + user.getEmpId());
			System.out.println("이름: " + user.getEmpName());
			System.out.println("이메일: " + user.getEmail());
			System.out.println("연락처: " + user.getPhone());
			System.out.println("등급: " + user.getGrade());

			request.getRequestDispatcher("mainpage.jsp").forward(request, response);
		} else {
			response.sendRedirect("login.jsp");
		}
	}
}
