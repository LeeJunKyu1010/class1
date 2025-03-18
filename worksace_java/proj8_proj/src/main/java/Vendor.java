import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/vendor")
public class Vendor extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String type = request.getParameter("hidden");

		VendorDTO vendor = new VendorDTO();
		VendorDAO dao = new VendorDAO();

		// DTO를 통해 JSP에서 넘어온 각 값을 필드에 저장
		// c_c의 null 값을 예방하기 위해 try-catch를 이용
		Integer c_c;
		try {
			c_c = Integer.parseInt(request.getParameter("c_c"));
		} catch (Exception e) {
			c_c = 0;
		}
		vendor.setC_c(c_c);
		vendor.setC_n(request.getParameter("c_n"));
		vendor.setC_m(request.getParameter("c_m"));
		vendor.setC_p(request.getParameter("c_p"));
		vendor.setC_a(request.getParameter("c_a"));
		Integer c_i;
		try {
			c_i = Integer.parseInt(request.getParameter("c_i"));
		} catch (Exception e) {
			c_i = 0;
		}
		;
		vendor.setC_i(c_i);

		System.out.println("type의 값은" + type);

		if ("search".equals(type)) {

			System.out.println("search 진입");

			System.out.println("vendor.getC_n(): " + vendor.getC_n());
			System.out.println("vendor.getC_m(): " + vendor.getC_m());
			System.out.println("vendor.getC_p(): " + vendor.getC_p());
			System.out.println("vendor.getC_a(): " + vendor.getC_a());
			System.out.println("vendor.getC_c(): " + vendor.getC_c());
			System.out.println("vendor.getC_i(): " + vendor.getC_i());

			if ((vendor.getC_n() == null || vendor.getC_n().isEmpty())
					&& (vendor.getC_m() == null || vendor.getC_m().isEmpty())
					&& (vendor.getC_p() == null || vendor.getC_p().isEmpty())
					&& (vendor.getC_a() == null || vendor.getC_a().isEmpty()) && 0 >= vendor.getC_c()
					&& 0 >= vendor.getC_i()) {
				System.out.println("search 실행");

				// 전체 조회후 항목에 추가하는 코드
				List resultset = dao.all_selectVendor();

				request.setAttribute("resultset", resultset);

				request.getRequestDispatcher("/vendor.jsp").forward(request, response);
			} else {

				System.out.println("조건 검색");

				List<VendorDTO> resultset = dao.selectVendor(vendor);

				request.setAttribute("resultset", resultset);

				// response.sendRedirect("/vendor.jsp");

				request.getRequestDispatcher("/vendor.jsp").forward(request, response);
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		// response.setContentType("text/html; charset=utf-8");

		VendorDTO vendor = new VendorDTO();
		VendorDAO dao = new VendorDAO();

		String type = request.getParameter("hidden");

		// DTO를 통해 JSP에서 넘어온 각 값을 필드에 저장
		// c_c의 null 값을 예방하기 위해 try-catch를 이용
		Integer c_c;
		try {
			c_c = Integer.parseInt(request.getParameter("c_c"));
		} catch (Exception e) {
			c_c = 0;
		}
		vendor.setC_c(c_c);
		vendor.setC_n(request.getParameter("c_n"));
		vendor.setC_m(request.getParameter("c_m"));
		vendor.setC_p(request.getParameter("c_p"));
		vendor.setC_a(request.getParameter("c_a"));
		Integer c_i;
		try {
			c_i = Integer.parseInt(request.getParameter("c_i"));
		} catch (Exception e) {
			c_i = 0;
		}
		;
		vendor.setC_i(c_i);

		// 값이 제대로 왔는지 마지막 key-value 출력
		System.out.println(vendor.getC_i());

		System.out.println("type값은: " + type);

		if ("insert".equals(type)) {

			// input창에 기입된 값이 없거나 null이거나 0이하일 경우 JSP의 DIV로 오류를 날려 보내는 조건문
			if ((vendor.getC_m() == null || vendor.getC_m().isEmpty())
					&& (vendor.getC_p() == null || vendor.getC_p().isEmpty())
					&& (vendor.getC_a() == null || vendor.getC_a().isEmpty()) && 0 >= vendor.getC_c()
					&& 0 >= vendor.getC_i()) {

				System.out.println("INPUT 오류입니다.");

				response.setContentType("text/html; charset=utf-8");

				String error = "{\"error\": \"필수 기입값 오류입니다.\"}";

				response.getWriter().print(error);
				return;

			} else {
				System.out.println("DB Insert를 시작합니다.");

				// input창에 값이 전부 기입되어 있으면 input창의 값을 db에 저장
				int result = dao.insertVendor(vendor);
				System.out.println(result);

				List resultset = dao.all_selectVendor();

				request.setAttribute("resultset", resultset);

				System.out.println("브라우저로 응답");

				request.getRequestDispatcher("/vendor.jsp").forward(request, response);
			}

		}

		if ("delet".equals(type)) {
			System.out.println("delet 진입");

			String[] array = request.getParameterValues("box");

			for (String arr : array) {
				System.out.println(arr);

				vendor.setCheck(arr);
			}

			System.out.println("DTO에 값 추가 완료");

			dao.deleteVendor(vendor);
			List resultset = dao.all_selectVendor();

			request.setAttribute("resultset", resultset);

			System.out.println("브라우저로 응답");

			request.getRequestDispatcher("/vendor.jsp").forward(request, response);
		}

		if ("update".equals(type)) {
			System.out.println("update구간 진입");

			dao.updateVendor(vendor);

			List resultset = dao.all_selectVendor();

			request.setAttribute("resultset", resultset);

			System.out.println("브라우저로 응답");

			request.getRequestDispatcher("/vendor.jsp").forward(request, response);

		}

	}
};
