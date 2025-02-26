import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ip")
public class IpServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// ip주소 가져오는 것 중 하나
        System.out.println("getRemoteAddr : "+ request.getRemoteAddr());
        
        // 접근 method 확인
        System.out.println("getMethod : "+ request.getMethod());
        
        // 주소 전체. 단, 쿼리스트링 제외
        System.out.println("getRequestURL : "+ request.getRequestURL());
        
        // ip, port, 쿼리스트링 제외한 주소
        System.out.println("getRequestURI : " + request.getRequestURI());

        // Context path; 프로젝트 구분하는 주소
        System.out.println("getContextPath : "+ request.getContextPath());
        
        // Context path 까지와 쿼리스트링 제외한 주소
        System.out.println("getServletPath : "+ request.getServletPath());
        
        // 접근 method 확인
        System.out.println("getQueryString : "+ request.getQueryString());
        
    }




}