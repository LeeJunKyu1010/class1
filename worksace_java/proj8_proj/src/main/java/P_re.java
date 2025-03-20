import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/p_re")
public class P_re extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String searchKeyword = request.getParameter("searchKeyword");
		String action = request.getParameter("action");
		P_reDAO reDAO = new P_reDAO();

		try {
			// 설비코드와 설비명 목록 조회
			List<P_reDTO> facilityCodes = reDAO.getFacilityCodeAndName();
			request.setAttribute("facilityCodes", facilityCodes);

			if ("all_select".equals(action)) {
				List<P_reDTO> repairs = reDAO.getAllRepairs();
				request.setAttribute("repairs", repairs);
			} else if (searchKeyword != null && !searchKeyword.isEmpty()) {
				// 검색 기능 구현 필요
			}
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "데이터베이스 오류");
			return;
		}

		request.getRequestDispatcher("p_repair.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		P_reDAO reDAO = new P_reDAO();

		try {
			if ("delete".equals(action)) {
				System.out.println("서블릿 삭제 실행");
				String[] repairIds = request.getParameterValues("check");
				if (repairIds != null && repairIds.length > 0) {
					for (String id : repairIds) {
						reDAO.deleteRe(Integer.parseInt(id));
					}
				} else {
					response.sendError(HttpServletResponse.SC_BAD_REQUEST, "삭제할 항목이 선택되지 않았습니다.");
					return;
				}
			} else if ("update".equals(action)) {
				String repairIdStr = request.getParameter("repair_id");
				if (repairIdStr == null || repairIdStr.isEmpty()) {
					response.sendError(HttpServletResponse.SC_BAD_REQUEST, "수리 ID가 제공되지 않았습니다.");
					return;
				}

				try {
					int repairId = Integer.parseInt(repairIdStr);
					P_reDTO dto = new P_reDTO();
					dto.setRepair_id(repairId);
					dto.setFacility_code(request.getParameter("facilityCode"));
					dto.setRepair_request_date(Date.valueOf(request.getParameter("requestDate")));
					dto.setRepair_details(request.getParameter("repairDetails"));
					dto.setRepair_requester(request.getParameter("requester"));
					dto.setRepair_item(request.getParameter("repairItem"));
					dto.setRemarks(request.getParameter("remarks"));
					reDAO.updateRe(dto);
				} catch (NumberFormatException e) {
					response.sendError(HttpServletResponse.SC_BAD_REQUEST, "유효하지 않은 수리 ID");
					return;
				} catch (IllegalArgumentException e) {
					response.sendError(HttpServletResponse.SC_BAD_REQUEST, "잘못된 날짜 형식 (예: YYYY-MM-DD)");
					return;
				}
			} else if ("insert".equals(action)) {
				P_reDTO dto = new P_reDTO();
				dto.setFacility_code(request.getParameter("facilityCode"));
				dto.setRepair_request_date(Date.valueOf(request.getParameter("requestDate")));
				dto.setRepair_details(request.getParameter("repairDetails"));
				dto.setRepair_requester(request.getParameter("requester"));
				dto.setRepair_item(request.getParameter("repairItem"));
				dto.setRemarks(request.getParameter("remarks"));
				reDAO.insertRe(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "데이터베이스 오류");
			return;
		}

		response.sendRedirect("p_re?action=all_select");
	}

}
