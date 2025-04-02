import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/work")
public class Work extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String type = request.getParameter("load");
		String year = request.getParameter("c_y");
		String week = request.getParameter("c_w");
		String name = request.getParameter("c_n");
		String bom = request.getParameter("c_b");
		String qnt = request.getParameter("c_d");
		String id = request.getParameter("c_pn");

		String hidden = request.getParameter("hidden");

		System.out.println(year);
		System.out.println(week);

		WorkDAO dao = new WorkDAO();
		WorkDTO dto = new WorkDTO();

		// 년도 저장
		Integer year_int;
		try {
			if (year != null && !year.isEmpty()) {
				year_int = Integer.parseInt(request.getParameter("c_y"));
			} else {
				year_int = 0;
			}
		} catch (Exception e) {
			year_int = 0;
			e.printStackTrace();
		}
		dto.setYear(year_int);

		// 주차 저장
		Integer week_int;
		try {
			if (week != null && !week.isEmpty()) {
				week_int = Integer.parseInt(request.getParameter("c_w"));
			} else {
				week_int = 0;
			}
		} catch (Exception e) {
			week_int = 0;
			e.printStackTrace();
		}
		dto.setWeek(week_int);

		// 상품명 저장
		dto.setSku_name(name);

		// 생산계획번호 저장
		Integer id_int;
		try {
			if (id != null && !id.isEmpty()) {
				id_int = Integer.parseInt(request.getParameter("c_pn"));
			} else {
				id_int = 0;
			}
		} catch (Exception e) {
			id_int = 0;
			e.printStackTrace();
		}
		dto.setPlan_id(id_int);

		Integer bom_int;
		try {
			if (bom != null && !bom.isEmpty()) {
				bom_int = Integer.parseInt(request.getParameter("c_b"));
			} else {
				bom_int = 0;
			}
		} catch (Exception e) {
			bom_int = 0;
			e.printStackTrace();
		}
		dto.setBom(bom_int);

		Integer qnt_int;
		try {
			if (qnt != null && !qnt.isEmpty()) {
				qnt_int = Integer.parseInt(request.getParameter("c_d"));
			} else {
				qnt_int = 0;
			}
		} catch (Exception e) {
			qnt_int = 0;
			e.printStackTrace();
		}
		dto.setQnt(qnt_int);

		System.out.println(hidden);

		if ("search".equals(hidden)) {

			System.out.println("search 진입");

			if (0 >= dto.getYear() && 0 >= dto.getWeek() && (dto.getSku_name() == "" || dto.getSku_name() == null)
					&& 0 >= dto.getPlan_id()) {
				System.out.println("search 실행");

				// 전체 조회후 항목에 추가하는 코드
				List resultset = dao.all_selectWork();

				request.setAttribute("resultset", resultset);

				System.out.println("전체 조회후 반환");

				request.getRequestDispatcher("/work.jsp").forward(request, response);
			} else {

				System.out.println("조건 검색");

				List resultset = dao.selectWork(dto);

				request.setAttribute("resultset", resultset);

				// response.sendRedirect("/vendor.jsp");

				request.getRequestDispatcher("/work.jsp").forward(request, response);
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String type = request.getParameter("load");
		String year = request.getParameter("c_y");
		String week = request.getParameter("c_w");
		String name = request.getParameter("c_n");
		String bom = request.getParameter("c_b");
		String plan_s = request.getParameter("c_cc");
		String qnt = request.getParameter("c_d");
		String id = request.getParameter("c_pn");

		String hidden = request.getParameter("hidden");

		System.out.println(year);
		System.out.println(week);

		WorkDAO dao = new WorkDAO();
		WorkDTO dto = new WorkDTO();

		// 년도 저장
		Integer year_int;
		try {
			if (year != null && !year.isEmpty()) {
				year_int = Integer.parseInt(request.getParameter("c_y"));
			} else {
				year_int = 0;
			}
		} catch (Exception e) {
			year_int = 0;
			e.printStackTrace();
		}
		dto.setYear(year_int);

		// 주차 저장
		Integer week_int;
		try {
			if (week != null && !week.isEmpty()) {
				week_int = Integer.parseInt(request.getParameter("c_w"));
			} else {
				week_int = 0;
			}
		} catch (Exception e) {
			week_int = 0;
			e.printStackTrace();
		}
		dto.setWeek(week_int);

		// 상품명 저장
		dto.setSku_name(name);

		// 생산계획번호 저장
		Integer id_int;
		try {
			if (id != null && !id.isEmpty()) {
				id_int = Integer.parseInt(request.getParameter("c_pn"));
			} else {
				id_int = 0;
			}
		} catch (Exception e) {
			id_int = 0;
			e.printStackTrace();
		}
		dto.setPlan_id(id_int);

		Integer bom_int;
		try {
			if (bom != null && !bom.isEmpty()) {
				bom_int = Integer.parseInt(request.getParameter("c_b"));
			} else {
				bom_int = 0;
			}
		} catch (Exception e) {
			bom_int = 0;
			e.printStackTrace();
		}
		dto.setBom(bom_int);

		Integer qnt_int;
		try {
			if (qnt != null && !qnt.isEmpty()) {
				qnt_int = Integer.parseInt(request.getParameter("c_d"));
			} else {
				qnt_int = 0;
			}
		} catch (Exception e) {
			qnt_int = 0;
			e.printStackTrace();
		}
		dto.setQnt(qnt_int);

		Integer plan_s_int;
		try {
			if (plan_s != null && !plan_s.isEmpty()) {
				plan_s_int = Integer.parseInt(request.getParameter("c_cc"));
			} else {
				plan_s_int = 0;
			}
		} catch (Exception e) {
			plan_s_int = 0;
			e.printStackTrace();
		}
		dto.setPlan_s(plan_s_int);

		System.out.println("생산계획 id: " + dto.getPlan_id());

		if ("load".equals(type)) {
			Set result = dao.code_select();

			request.setAttribute("result", result);

			Gson gson = new Gson();

			String json = gson.toJson(result);

			response.getWriter().print(json);
		}

		if (year != null && week != null && name == "") {
			System.out.println("선택 활성화");

			Set result = dao.code_option(dto);

			request.setAttribute("result", result);

			Gson gson = new Gson();

			String json = gson.toJson(result);

			response.getWriter().print(json);

		}

		if (name != null && !name.isEmpty() && id == "") {
			System.out.println("상품명으로 id 검색");

			Set result = dao.name_option(dto);

			request.setAttribute("result", result);

			Gson gson = new Gson();

			String json = gson.toJson(result);

			response.getWriter().print(json);
		}

		if (id != null && !id.isEmpty()) {
			System.out.println("생산계획 선택");

			Set result = dao.id_option(dto);

			System.out.println(result);

			request.setAttribute("result", result);

			Gson gson = new Gson();

			String json = gson.toJson(result);

			response.getWriter().print(json);
		}

		System.out.println(hidden);
		if ("insert".equals(hidden)) {

			System.out.println("DB Insert를 시작합니다.");

			String sum = request.getParameter("c_s");
			Integer sum_int;
			try {
				if (sum != null && !sum.isEmpty()) {
					sum_int = Integer.parseInt(request.getParameter("c_s"));
				} else {
					sum_int = 0;
				}
			} catch (Exception e) {
				sum_int = 0;
				e.printStackTrace();
			}

			System.out.println(dto.getPlan_s());

			if ((dto.getPlan_s() > (dto.getQnt() + sum_int))) {

				System.out.println("주차 플랜 수량보다 생산완료 및 추가의 수량이 적습니다.");

				int value = dao.insertWork(dto);
				System.out.println(value);

				List resultset = dao.all_selectWork();

				request.setAttribute("resultset", resultset);

				System.out.println("브라우저로 응답");

				request.getRequestDispatcher("/work.jsp").forward(request, response);
			}
		}

		System.out.println("hidden값은: " + hidden);

		if ("defect".equals(hidden)) {

			String value = request.getParameter("value");
			String id_2 = request.getParameter("id");
			
			System.out.println("value" + value);
			System.out.println("id" + id_2);

			Integer id_int_2;
			try {
				if (id_2 != null && !id_2.isEmpty()) {
					id_int_2 = Integer.parseInt(request.getParameter("id"));
				} else {
					id_int_2 = 0;
				}
			} catch (Exception e) {
				id_int_2 = 0;
				e.printStackTrace();
			}
			dto.setWork_id(id_int_2);

			Integer value_int;
			try {
				if (value != null && !value.isEmpty()) {
					value_int = Integer.parseInt(request.getParameter("value"));
				} else {
					value_int = 0;
				}
			} catch (Exception e) {
				value_int = 0;
				e.printStackTrace();
			}
			dto.setQnt(value_int);
			
			System.out.println(dto.getWork_id());
			System.out.println(dto.getQnt());

			dao.defectWork(dto);

			List resultset = dao.all_selectWork();

			request.setAttribute("resultset", resultset);

			System.out.println("브라우저로 응답");

			request.getRequestDispatcher("/work.jsp").forward(request, response);

			System.out.println(value);

		}

	}

}
