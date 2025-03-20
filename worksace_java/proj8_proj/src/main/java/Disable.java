import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/disable")
public class Disable extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String load = request.getParameter("load");

		DisableDTO dto = new DisableDTO();
		DisableDAO dao = new DisableDAO();

		if ("load".equals(load)) {

			List result = dao.all_selectDefect();

			System.out.println("전부 조회 완료");

			request.setAttribute("result", result);

			Gson gson = new Gson();

			String json = gson.toJson(result);

			response.getWriter().write(json);
		}

		if ("add".equals(load)) {

			String value_1 = request.getParameter("value_1");
			String value_2 = request.getParameter("value_2");
			String value_3 = request.getParameter("value_3");

			Integer value_1_int;
			try {
				if (value_1 != null && !value_1.isEmpty()) {
					value_1_int = Integer.parseInt(request.getParameter("value_1"));
				} else {
					value_1_int = 0;
				}
			} catch (Exception e) {
				value_1_int = 0;
				e.printStackTrace();
			}
			dto.setCount_2(value_1_int);

			Integer value_2_int;
			try {
				if (value_2 != null && !value_2.isEmpty()) {
					value_2_int = Integer.parseInt(request.getParameter("value_2"));
				} else {
					value_2_int = 0;
				}
			} catch (Exception e) {
				value_2_int = 0;
				e.printStackTrace();
			}
			dto.setCount(value_2_int);

			Integer value_3_int;
			try {
				if (value_3 != null && !value_3.isEmpty()) {
					value_3_int = Integer.parseInt(request.getParameter("value_3"));
				} else {
					value_3_int = 0;
				}
			} catch (Exception e) {
				value_3_int = 0;
				e.printStackTrace();
			}
			dto.setId(value_3_int);

			System.out.println("아이디는: " + dto.getId());

			List result = dao.insertDisable(dto);

			System.out.println("전부 조회 완료");

			request.setAttribute("result", result);

			Gson gson = new Gson();

			String json = gson.toJson(result);

			response.getWriter().write(json);
		}
	}
}