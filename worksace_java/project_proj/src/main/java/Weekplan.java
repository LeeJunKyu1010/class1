import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/weekplan")
public class Weekplan extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String type = request.getParameter("load");
		String hidden = request.getParameter("hidden");
		System.out.println(type);

		WeekDAO dao = new WeekDAO();
		WeekDTO dto = new WeekDTO();

		LocalDate today = LocalDate.now();

		int year = today.getYear();

		int week = today.get(WeekFields.of(Locale.getDefault()).weekOfYear());

		// 생산수량
		Integer p_c;
		try {
			p_c = Integer.parseInt(request.getParameter("c_c"));
		} catch (Exception e) {
			p_c = 0;
		}
		dto.setP_c(p_c);
		// 상품명의 id를 반환
		Integer p_id;
		try {
			p_id = Integer.parseInt(request.getParameter("c_s"));
		} catch (Exception e) {
			p_id = 0;
		}
		dto.setP_id(p_id);
		// 생산계획관리번호
		Integer p_i;
		try {
			p_i = Integer.parseInt(request.getParameter("c_i"));
		} catch (Exception e) {
			p_i = 0;
		}
		dto.setP_i(p_i);
		// 년도
		Integer p_y;
		try {
			p_y = Integer.parseInt(request.getParameter("c_y"));
		} catch (Exception e) {
			p_y = 0;
		}
		dto.setP_y(p_y);
		// 주차
		Integer p_w;
		try {
			p_w = Integer.parseInt(request.getParameter("c_w"));
		} catch (Exception e) {
			p_w = 0;
		}
		dto.setP_w(p_w);

		if ("search".equals(hidden)) {

			System.out.println("search 진입");

			System.out.println(dto.getP_id());
			System.out.println(dto.getP_c());
			System.out.println(dto.getP_i());
			System.out.println(dto.getP_y());
			System.out.println(dto.getP_w());

			if (0 >= dto.getP_id() && 0 >= dto.getP_c() && 0 >= dto.getP_i() && 0 >= dto.getP_y()
					&& 0 >= dto.getP_w()) {
				System.out.println("search 실행");

				// 전체 조회후 항목에 추가하는 코드
				List resultset = dao.all_selectPlan();

				request.setAttribute("resultset", resultset);

				System.out.println("전체 조회후 반환");

				request.getRequestDispatcher("/week.jsp").forward(request, response);
			} else {

				System.out.println("조건 검색");

				List resultset = dao.selectWeek(dto);

				request.setAttribute("resultset", resultset);

				// response.sendRedirect("/vendor.jsp");

				request.getRequestDispatcher("/week.jsp").forward(request, response);
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String type = request.getParameter("load");
		String hidden = request.getParameter("hidden");
		System.out.println(type);

		WeekDAO dao = new WeekDAO();
		WeekDTO dto = new WeekDTO();

		LocalDate today = LocalDate.now();

		int year = today.getYear();

		int week = today.get(WeekFields.of(Locale.getDefault()).weekOfYear());

		// 생산수량
		Integer p_c;
		try {
			p_c = Integer.parseInt(request.getParameter("c_c"));
		} catch (Exception e) {
			p_c = 0;
		}
		dto.setP_c(p_c);
		// 생산계획 번호
		Integer p_i;
		try {
			p_i = Integer.parseInt(request.getParameter("c_i"));
		} catch (Exception e) {
			p_i = 0;
		}
		dto.setP_i(p_i);
		// 상품명의 id를 반환
		Integer p_id;
		try {
			p_id = Integer.parseInt(request.getParameter("c_s"));
		} catch (Exception e) {
			p_id = 0;
		}
		dto.setP_id(p_id);
		// 년도
		dto.setP_y(year);
		// 주차
		dto.setP_w(week);

		List result = dao.code_select();

		request.setAttribute("result", result);

		Gson gson = new Gson();

		String json = gson.toJson(result);

		response.getWriter().print(json);

		if ("insert".equals(hidden)) {

			// input창에 기입된 값이 없거나 null이거나 0이하일 경우 JSP의 DV로 오류를 날려 보내는 조건문
			if (0 >= dto.getP_id() && 0 >= dto.getP_c()) {

				System.out.println(dto.getP_id());
				System.out.println("INPUT 오류입니다.");

				response.setContentType("text/html; charset=utf-8");

				String error = "{\"error\": \"필수 기입값 오류입니다.\"}";

				response.getWriter().print(error);
				return;

			} else {
				System.out.println("DB Insert를 시작합니다.");

				// input창에 값이 전부 기입되어 있으면 input창의 값을 db에 저장
				int value = dao.insertPlan(dto);
				System.out.println(value);

				List resultset = dao.all_selectPlan();

				request.setAttribute("resultset", resultset);

				System.out.println("브라우저로 응답");

				request.getRequestDispatcher("/week.jsp").forward(request, response);
			}

		}

		if ("delet".equals(hidden)) {
			System.out.println("delet 진입");

			String[] array = request.getParameterValues("box");

			for (String arr : array) {
				System.out.println(arr);

				dto.setCheck(arr);
			}

			System.out.println("DTO에 값 추가 완료");

			dao.deletePlan(dto);
			List resultset = dao.all_selectPlan();

			request.setAttribute("resultset", resultset);

			System.out.println("브라우저로 응답");

			request.getRequestDispatcher("/week.jsp").forward(request, response);
		}

		if ("update".equals(hidden)) {
			System.out.println("update구간 진입");

			dao.updatePlan(dto);

			List resultset = dao.all_selectPlan();

			request.setAttribute("resultset", resultset);

			System.out.println("브라우저로 응답");

			request.getRequestDispatcher("/week.jsp").forward(request, response);

		}

	}

}
