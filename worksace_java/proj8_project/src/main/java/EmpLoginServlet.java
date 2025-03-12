import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class EmpLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empId = request.getParameter("id");
        String password = request.getParameter("pw");

        EmpDAO dao = new EmpDAO();
        if (dao.validateLogin(empId, password)) { // 로그인 성공
            HttpSession session = request.getSession();
            session.setAttribute("empId", empId);

            response.sendRedirect("main.jsp");
        } else { // 로그인 실패
            response.sendRedirect("login.jsp?error=invalid");
            System.out.println("입력된 아이디: " + empId);
            System.out.println("입력된 비밀번호: " + password);

        }
    }
}
