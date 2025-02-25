

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/req")
public class RequestServlet extends HttpServlet {

    public RequestServlet() {
        super();
        System.out.println("RequestServlet 생성자 실행");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/req doGet 실행");
		
		
		// 요청 내용의 한글 깨짐 방지
		request.setCharacterEncoding("UTF-8");
		
		// 응답 내용의 한글 깨짐 방지
		response.setContentType("text/html; charset=utf-8");
		
		// getParameter
		// 전달받은 파라메터의 key를 적어서 해당 값을 얻어오기
		String num1 = request.getParameter("num1");
		System.out.println("num1 :"+num1);
		
		// num2는 값이 없어서 null이 나온다.
		String num2 = request.getParameter("num2");
		System.out.println("num2 :"+num2);
		
		String[] nums = request.getParameterValues("num1");
		if(nums != null) {
			// 첫번째 for문
//		for(String num : nums) {
//			System.out.println(num);
//		}
			// 두번째 for문
			for(int i=0; i<nums.length; i++) {
				System.out.println(nums[i]);
			}
		}
		
		
		response.getWriter().println("<strong>nul1</strong>의 값은 :"+ num1);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
