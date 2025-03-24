import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bill")
public class Bill extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String type = request.getParameter("hidden");

		BillDTO bill = new BillDTO();
		BillDAO dao = new BillDAO();

		// DTO를 통해 JSP에서 넘어온 각 값을 필드에 저장
		// c_c의 null 값을 예방하기 위해 try-catch를 이용
		Date c_d;
		Integer c_c;
		try {
			c_c = Integer.parseInt(request.getParameter("c_c"));
		} catch (Exception e) {
			c_c = 0;
		}
		bill.setC_c(c_c);
		bill.setC_n(request.getParameter("c_n"));
		bill.setC_p(request.getParameter("c_p"));
		bill.setC_j(request.getParameter("c_j"));
		Integer c_b;
		try {
			c_b = Integer.parseInt(request.getParameter("c_b"));
		} catch (Exception e) {
			c_b = 0;
		}
		bill.setC_b(c_b);
		Integer c_i;
		try {
			c_i = Integer.parseInt(request.getParameter("c_i"));
		} catch (Exception e) {
			c_i = 0;
		}
		bill.setC_i(c_i);
		Integer c_q;
		try {
			c_q = Integer.parseInt(request.getParameter("c_q"));
		} catch (Exception e) {
			c_q = 0;
		}
		bill.setC_q(c_q);
		bill.setC_a(request.getParameter("c_a"));

		System.out.println("type의 값은" + type);

		if ("search".equals(type)) {

			System.out.println("search 진입");

			System.out.println("bill.getC_n(): " + bill.getC_n());
			System.out.println("bill.getC_i(): " + bill.getC_i());
			System.out.println("bill.getC_p(): " + bill.getC_p());
			System.out.println("bill.getC_a(): " + bill.getC_a());
			System.out.println("bill.getC_c(): " + bill.getC_c());

			if ((bill.getC_d() == null) && (bill.getC_p() == null || bill.getC_p().isEmpty())
					&& (bill.getC_a() == null || bill.getC_a().isEmpty()) && 0 >= bill.getC_q() && 0 >= bill.getC_i()) {
				System.out.println("search 실행");

				// 전체 조회후 항목에 추가하는 코드
				List resultset = dao.all_selectBill();

				System.out.println("java 가격: " + bill.getC_b());

				request.setAttribute("resultset", resultset);

				System.out.println("java 가격: " + bill.getC_b());

				request.getRequestDispatcher("/bill.jsp").forward(request, response);
			} else {

				System.out.println("조건 검색");

				System.out.println("java 가격: " + bill.getC_b());

				List<BillDTO> resultset = dao.selectBill(bill);

				request.setAttribute("resultset", resultset);

				// response.sendRedirect("/vendor.jsp");

				request.getRequestDispatcher("/bill.jsp").forward(request, response);
			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// response.setContentType("text/html; charset=utf-8");

		String type = request.getParameter("hidden");

		BillDTO bill = new BillDTO();
		BillDAO dao = new BillDAO();

		// DTO를 통해 JSP에서 넘어온 각 값을 필드에 저장
		// c_c의 null 값을 예방하기 위해 try-catch를 이용

		String date = request.getParameter("c_d");
		SimpleDateFormat type_2 = new SimpleDateFormat("yyyy-MM-dd");
		Date get_date;
		try {
			get_date = type_2.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			get_date = new Date();
		}
		
		bill.setC_d(get_date);
		Integer c_c;
		try {
			c_c = Integer.parseInt(request.getParameter("c_c"));
		} catch (Exception e) {
			c_c = 0;
		}
		bill.setC_c(c_c);
		bill.setC_n(request.getParameter("c_n"));
		bill.setC_p(request.getParameter("c_p"));
		bill.setC_j(request.getParameter("c_j"));
		Integer c_b;
		try {
			c_b = Integer.parseInt(request.getParameter("c_b"));
		} catch (Exception e) {
			c_b = 0;
		}
		bill.setC_b(c_b);
		Integer c_i;
		try {
			c_i = Integer.parseInt(request.getParameter("c_i"));
		} catch (Exception e) {
			c_i = 0;
		}
		bill.setC_i(c_i);
		Integer c_q;
		try {
			c_q = Integer.parseInt(request.getParameter("c_q"));
		} catch (Exception e) {
			c_q = 0;
		}
		bill.setC_q(c_q);
		bill.setC_a(request.getParameter("c_a"));

		// 값이 제대로 왔는지 마지막 key-value 출력
		System.out.println(bill.getC_q());

		System.out.println("type값은: " + type);

		if ("insert".equals(type)) {

			// input창에 기입된 값이 없거나 null이거나 0이하일 경우 JSP의 DIV로 오류를 날려 보내는 조건문
			if ((bill.getC_d() == null) && (bill.getC_n() == null || bill.getC_n().isEmpty())
					&& (bill.getC_p() == null || bill.getC_p().isEmpty())
					&& (bill.getC_j() == null || bill.getC_j().isEmpty())
					&& (bill.getC_a() == null || bill.getC_a().isEmpty()) && 0 >= bill.getC_b() && 0 >= bill.getC_q()
					&& 0 >= bill.getC_i()) {

				System.out.println(bill.getC_q());
				System.out.println("INPUT 오류입니다.");

				response.setContentType("text/html; charset=utf-8");

				String error = "{\"error\": \"필수 기입값 오류입니다.\"}";

				response.getWriter().print(error);
				return;

			} else {
				System.out.println("DB Insert를 시작합니다.");

				// input창에 값이 전부 기입되어 있으면 input창의 값을 db에 저장
				int result = dao.insertBill(bill);
				System.out.println(result);

				List resultset = dao.all_selectBill();

				request.setAttribute("resultset", resultset);

				System.out.println("브라우저로 응답");

				request.getRequestDispatcher("/bill.jsp").forward(request, response);
			}

		}

		if ("delete".equals(type)) {
			System.out.println("delet 진입");

			String[] array = request.getParameterValues("box");

			for (String arr : array) {
				System.out.println(arr);

				bill.setCheck(arr);
			}

			System.out.println("DTO에 값 추가 완료");

			dao.deleteBill(bill);
			List resultset = dao.all_selectBill();

			request.setAttribute("resultset", resultset);

			System.out.println("브라우저로 응답");

			request.getRequestDispatcher("/bill.jsp").forward(request, response);
		}

		if ("update".equals(type)) {
			System.out.println("update구간 진입");

			dao.updateBill(bill);

			List resultset = dao.all_selectBill();

			request.setAttribute("resultset", resultset);

			System.out.println("브라우저로 응답");

			request.getRequestDispatcher("/bill.jsp").forward(request, response);

		}
	}

}
