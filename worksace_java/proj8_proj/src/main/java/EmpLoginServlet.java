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
        
        // 로그인 요청 파라미터 추출
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");

        // EmpDAO를 통해 사용자 정보 조회
        EmpDAO empDAO = new EmpDAO();
        EmpDTO user = empDAO.getUserInfo(id, pw);

     // EmpLoginServlet.java
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            // 응답으로 JavaScript 코드 작성
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();

            out.println("<script>");
            out.println("sessionStorage.setItem('empNo', '" + user.getEmpNo() + "');");
            out.println("sessionStorage.setItem('empName', '" + user.getEmpName() + "');");
            out.println("sessionStorage.setItem('email', '" + user.getEmail() + "');");
            out.println("sessionStorage.setItem('phone', '" + user.getPhone() + "');");
            out.println("sessionStorage.setItem('grade', '" + user.getGrade() + "');");
            out.println("console.log('Session Storage updated:', sessionStorage);");
            out.println("window.location.href = 'mainpage.jsp';"); // mainpage.jsp로 이동
            out.println("</script>");

        } else {
            // 로그인 실패 시 에러 메시지 출력
            request.setAttribute("error", "아이디 또는 비밀번호를 확인해주십시오.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
