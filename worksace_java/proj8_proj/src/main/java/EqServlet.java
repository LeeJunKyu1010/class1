import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
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
		// 조회할떄 쓰이는 입력하는곳 이름
		String searchKeyword = request.getParameter("searchKeyword");

		EqDAO eqDAO = new EqDAO();
		List<EqDTO> resultList;
		try {
			if (searchKeyword != null && !searchKeyword.isEmpty()) {
				// 검색어가 있을 경우 검색 메서드 호출
				resultList = eqDAO.searchEqList(searchKeyword);
			} else {
				// 검색어가 없을 경우 전체 목록 조회
				resultList = eqDAO.selectEqList();
			}
			// 조회 결과 저장
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
		String action1 = request.getParameter("action1");

		// 삭제
		if ("삭제".equals(action)) {
			// check 파라미터 값을 checkParam바꿨음
			String checkParam = request.getParameter("check");
			// 삭제할꺼 체크된경우
			if (checkParam != null && !checkParam.isEmpty()) {
				// 체크한거 쉼표를 기준으로 분리하여 배열 생성
				String[] eqIds = checkParam.split(",");
				EqDAO eqDAO = new EqDAO();
				try {
					// 배열을 사용해서 체크된거 삭제 메서드를 부름
					eqDAO.deleteEq(eqIds);
				} catch (SQLException e) {
					e.printStackTrace();
					response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "삭제 중 오류 발생");
					return;
				}
			}
			// 수정
		} else if ("수정".equals(action1)) {
			try {
				// 각 파라미터 값을 가져옴
				String facility_code = request.getParameter("facilityCode");
				String facility_manager = request.getParameter("facilityManager");
				String installation_date = request.getParameter("installationDate");
				String facility_name = request.getParameter("facilityName");
				String facility_location = request.getParameter("facilityLocation");
				String inspection_cycle = request.getParameter("inspectionCycle");
				String remarks = request.getParameter("remarks");

				EqDTO eqDTO = new EqDTO();
				// 각 파라미터 값을 eqDTO에 설정
				eqDTO.setFacility_code(facility_code);
				eqDTO.setFacility_manager(facility_manager);
				eqDTO.setInstallation_date(Date.valueOf(installation_date));
				eqDTO.setFacility_name(facility_name);
				eqDTO.setFacility_location(facility_location);
				eqDTO.setInspection_cycle(inspection_cycle);
				eqDTO.setRemarks(remarks);

				EqDAO eqDAO = new EqDAO();
				// eqDTO를 사용하여 DB 수정 메서드를 부름
				eqDAO.updateEq(eqDTO);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "잘못된 날짜 형식");
				return;
			} catch (SQLException e) {
				e.printStackTrace();
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "수정 중 오류 발생");
				return;
			}
			// 삭제 또는 수정이 아니면 등록되게 하기
		} else {
			// 각 파라미터값 가져오기
			String facility_code = request.getParameter("facilityCode");
			if (facility_code == null || facility_code.isEmpty()) {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "FACILITY_CODE는 필수 입력 항목입니다");
				return;
			}

			String facility_manager = request.getParameter("facilityManager");
			String facility_name = request.getParameter("facilityName");
			String facility_location = request.getParameter("facilityLocation");
			String installation_date = request.getParameter("installationDate");
			String inspection_cycle = request.getParameter("inspectionCycle");
			String remarks = request.getParameter("remarks");

			try {
				// 위에서 각자 파라미터값 가져온것을 DTO에 설정
				EqDTO eqDTO = new EqDTO();
				eqDTO.setFacility_code(facility_code);
				eqDTO.setFacility_manager(facility_manager);
				eqDTO.setFacility_name(facility_name);
				eqDTO.setFacility_location(facility_location);
				eqDTO.setInstallation_date(Date.valueOf(installation_date));
				eqDTO.setInspection_cycle(inspection_cycle);
				eqDTO.setRemarks(remarks);

				EqDAO eqDAO = new EqDAO();
				// 등록 메소드 호출
				eqDAO.insertEq(eqDTO);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "잘못된 날짜 형식");
				return;
			} catch (SQLException e) {
				e.printStackTrace();
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "등록 중 오류 발생");
				return;
			}
		}

		response.sendRedirect("p_eq");
		// 끝난뒤 맨위로 올리기
	}

}