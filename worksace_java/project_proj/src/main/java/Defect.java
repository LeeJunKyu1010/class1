
import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/defect")
public class Defect extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String hidden = request.getParameter("hidden");

		DefectDTO dto = new DefectDTO();
		DefectDAO dao = new DefectDAO();

		String id = request.getParameter("c_d");
		String code = request.getParameter("c_p");
		String name = request.getParameter("c_j");
		String type = request.getParameter("c_type");
		String vendor = request.getParameter("c_m");

		// 값이 비어 있거나 null이면 true
		boolean id_b = (id == null) || id.isEmpty();
		boolean code_b = (code == null) || code.isEmpty();
		boolean name_b = (name == null) || name.isEmpty();
		boolean type_b = (type == null) || type.isEmpty();
		boolean vendor_b = (vendor == null) || vendor.isEmpty();

		System.out.println(id);

		Integer id_int;
		try {
			if (id != null && !id.isEmpty()) {
				id_int = Integer.parseInt(request.getParameter("c_d"));
			} else {
				id_int = 0;
			}
		} catch (Exception e) {
			id_int = 0;
			e.printStackTrace();
		}
		dto.setId(id_int);
		dto.setCode(code);
		dto.setName(name);
		dto.setType(type);
		dto.setVendor(vendor);

		System.out.println(dto.getId());

		if ("search".equals(hidden)) {

			System.out.println("search 진입");

			// 값이 전부 true일 경우 모든 칸이 비어있거나 null이란 뜻이기에 전제 조회
			if (0 >= id_int && id_b && code_b && name_b && type_b && vendor_b) {
				System.out.println("search 실행");

				// 전체 조회후 항목에 추가하는 코드
				List resultset = dao.all_selectDefect();

				request.setAttribute("resultset", resultset);

				System.out.println("전체 조회후 반환");

				request.getRequestDispatcher("/defect.jsp").forward(request, response);
			} else {

				System.out.println("조건 검색");

				List resultset = dao.selectDefect(dto);

				request.setAttribute("resultset", resultset);

				// response.sendRedirect("/vendor.jsp");

				request.getRequestDispatcher("/defect.jsp").forward(request, response);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String hidden = request.getParameter("hidden");
		String load = request.getParameter("load");

		DefectDTO dto = new DefectDTO();
		DefectDAO dao = new DefectDAO();

		String id = request.getParameter("c_d");
		String code = request.getParameter("c_p");
		String name = request.getParameter("c_j");
		String type = request.getParameter("c_type");
		String vendor = request.getParameter("c_m");

		// 값이 비어 있거나 null이면 true
		boolean id_b = (id == null) || id.isEmpty();
		boolean code_b = (code == null) || code.isEmpty();
		boolean name_b = (name == null) || name.isEmpty();
		boolean type_b = (type == null) || type.isEmpty();
		boolean vendor_b = (vendor == null) || vendor.isEmpty();

		System.out.println(id);

		Integer id_int;
		try {
			if (id != null && !id.isEmpty()) {
				id_int = Integer.parseInt(request.getParameter("c_d"));
			} else {
				id_int = 0;
			}
		} catch (Exception e) {
			id_int = 0;
			e.printStackTrace();
		}
		dto.setId(id_int);
		dto.setCode(code);
		dto.setName(name);
		dto.setType(type);
		dto.setVendor(vendor);

		System.out.println(dto.getId());
		
		if ("load".equals(load)) {
			
			Set result = dao.code_select();

			request.setAttribute("result", result);

			Gson gson = new Gson();

			String json = gson.toJson(result);

			response.getWriter().print(json);
		}

	}

}
