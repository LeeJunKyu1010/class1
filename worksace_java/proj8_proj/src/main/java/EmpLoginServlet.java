import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class EmpLoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("do post 실행");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		String command = request.getParameter("command");
		System.out.println("command : " + command);

		EqDAO eqDAO = new EqDAO();

		if ("insert".equals(command)) {
			// 등록 처리
			int facilityCode = Integer.parseInt(request.getParameter("설비코드"));
			String facilityManager = request.getParameter("관리자");
			Date installationDate = Date.valueOf(request.getParameter("설치일"));
			String facilityName = request.getParameter("설비명");
			String facilityLocation = request.getParameter("설비위치");
			String inspectionCycle = request.getParameter("점검주기");
			String remarks = request.getParameter("비고사항");

			EqDTO eqDTO = new EqDTO();
			eqDTO.setFacility_code(facilityCode);
			eqDTO.setFacility_manager(facilityManager);
			eqDTO.setInstallation_date(installationDate);
			eqDTO.setFacility_name(facilityName);
			eqDTO.setFacility_location(facilityLocation);
			eqDTO.setInspection_cycle(inspectionCycle);
			eqDTO.setRemarks(remarks);

			int result = eqDAO.insertEq(eqDTO);
			System.out.println("등록 결과: " + result);

		} else if ("select".equals(command)) {
			// 조회 처리
			List<EqDTO> resultList = eqDAO.selectEqList();
			request.setAttribute("resultList", resultList);
			String url = "/list.jsp";
			request.getRequestDispatcher(url).forward(request, response);

		} else if ("update".equals(command)) {
			// 수정 처리
			// 수정 로직 구현 필요

		} else if ("delete".equals(command)) {
			// 삭제 처리
			// 삭제 로직 구현 필요
		}
	}

}