import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");

        UserDAO userDAO = new UserDAO();
        UserDTO userDTO = userDAO.getUser(id, pw);
//
        if (userDTO != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", userDTO); // 세션에 사용자 정보 저장
            response.getWriter().write("success"); // 로그인 성공
        } else {
            response.getWriter().write("failure"); // 로그인 실패
        }
    }
}
