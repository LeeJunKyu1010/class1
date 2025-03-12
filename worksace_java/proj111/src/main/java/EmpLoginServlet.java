import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class EmpLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String empId = request.getParameter("empId");
        String pw = request.getParameter("pw");

        try {
            // DAO 인스턴스 생성
            EmpDAO dao = new EmpDAO();

            // Validate login credentials
            EmpDTO emp = dao.login(empId, pw);

            if (emp != null) { // Login successful
                HttpSession session = request.getSession();
                session.setAttribute("user", emp); // Store user info in session

                response.sendRedirect("mainpage.jsp"); // Redirect to main page
            } else { // Login failed
                request.setAttribute("errorMessage", "아이디 또는 비밀번호가 잘못되었습니다.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
