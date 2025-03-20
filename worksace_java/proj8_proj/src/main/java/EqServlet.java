import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/p_eq")
public class EqServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String searchKeyword = request.getParameter("searchKeyword");
		String action = request.getParameter("action");
		EqDAO eqDAO = new EqDAO();
		List<EqDTO> resultList;

		try {
			if ("전체조회".equals(action)) {
				resultList = eqDAO.selectEqList();
			} else if (searchKeyword != null && !searchKeyword.isEmpty()) {
				resultList = eqDAO.searchEqList(searchKeyword);
			} else {
				resultList = new ArrayList<>();
			}
			request.setAttribute("resultList", resultList);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "데이터베이스 오류");
			return;
		}

		String url = "eqcreate.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String action = request.getParameter("action");

		if ("삭제".equals(action)) {
			String checkParam = request.getParameter("check");
			if (checkParam != null && !checkParam.isEmpty()) {
				String[] facilityCodes = checkParam.split(",");
				EqDAO eqDAO = new EqDAO();
				try {
					for (String code : facilityCodes) {
						eqDAO.deleteEq(code);
					}
					List<EqDTO> resultList = eqDAO.selectEqList();
					request.setAttribute("resultList", resultList);
				} catch (SQLException e) {
					e.printStackTrace();
					response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "삭제 중 오류 발생");
					return;
				}
				request.getRequestDispatcher("/eqcreate.jsp").forward(request, response);
				return;
			}
		} else if ("수정".equals(action)) {
			String facility_code = request.getParameter("facilityCode");
			String facility_manager = request.getParameter("facilityManager");
			String installation_date = request.getParameter("installationDate");
			String facility_name = request.getParameter("facilityName");
			String facility_location = request.getParameter("facilityLocation");
			String inspection_cycle = request.getParameter("inspectionCycle");
			String remarks = request.getParameter("remarks");

			EqDTO eqDTO = new EqDTO();
			eqDTO.setFacility_code(facility_code);
			eqDTO.setFacility_manager(facility_manager);
			eqDTO.setInstallation_date(Date.valueOf(installation_date));
			eqDTO.setFacility_name(facility_name);
			eqDTO.setFacility_location(facility_location);
			eqDTO.setInspection_cycle(inspection_cycle);
			eqDTO.setRemarks(remarks);

			EqDAO eqDAO = new EqDAO();
			try {
				eqDAO.updateEq(eqDTO);
				response.sendRedirect("p_eq?action=all_search");
			} catch (SQLException e) {
				e.printStackTrace();
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "수정 중 오류 발생: " + e.getMessage());
			}
			return;
		} else {
			// 등록 처리
			try {
				String facility_code = request.getParameter("facilityCode");
				if (facility_code == null || facility_code.isEmpty()) {
					response.sendError(HttpServletResponse.SC_BAD_REQUEST, "FACILITY_CODE는 필수 입력 항목입니다.");
					return;
				}

				String facility_manager = request.getParameter("facilityManager");
				String installation_date = request.getParameter("installationDate");
				String facility_name = request.getParameter("facilityName");
				String facility_location = request.getParameter("facilityLocation");
				String inspection_cycle = request.getParameter("inspectionCycle");
				String remarks = request.getParameter("remarks");

				EqDTO eqDTO = new EqDTO();
				eqDTO.setFacility_code(facility_code);
				eqDTO.setFacility_manager(facility_manager);
				eqDTO.setInstallation_date(Date.valueOf(installation_date));
				eqDTO.setFacility_name(facility_name);
				eqDTO.setFacility_location(facility_location);
				eqDTO.setInspection_cycle(inspection_cycle);
				eqDTO.setRemarks(remarks);

				EqDAO eqDAO = new EqDAO();
				int result = eqDAO.insertEq(eqDTO);
				if (result == -2) {
					response.setContentType("text/html;charset=UTF-8");
					response.getWriter().write("duplicate");
				} else if (result > 0) {
					response.getWriter().write("success");
				} else {
					response.getWriter().write("error");
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "잘못된 날짜 형식");
			} catch (SQLException e) {
				e.printStackTrace();
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "등록 중 오류 발생");
			}

			// 작업 완료 후 목록으로 리디렉션
			response.sendRedirect("/proj8_proj/p_eq");
		}
	}
}
