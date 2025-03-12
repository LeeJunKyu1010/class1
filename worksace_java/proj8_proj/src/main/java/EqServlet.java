
import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EqServlet")
public class EqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		String command = request.getParameter("command");
		if ("insert".equals(command)) {
			// 데이터베이스에 삽입하는 코드
			EqDTO eqDTO = new EqDTO();
			eqDTO.setFacility_code(Integer.parseInt(request.getParameter("facility_code")));
			eqDTO.setFacility_manager(request.getParameter("facility_manager"));
			eqDTO.setInstallation_date(Date.valueOf(request.getParameter("installation_date")));
			eqDTO.setFacility_name(request.getParameter("facility_name"));
			eqDTO.setFacility_location(request.getParameter("facility_location"));
			eqDTO.setInspection_cycle(request.getParameter("inspection_cycle"));
			eqDTO.setRemarks(request.getParameter("remarks"));

			EqDAO eqDAO = new EqDAO();
			int result = eqDAO.insertEq(eqDTO);

			if (result > 0) {
				System.out.println("데이터베이스에 성공적으로 등록되었습니다.");
			} else {
				System.out.println("등록 실패");
			}
		}
	}

}
