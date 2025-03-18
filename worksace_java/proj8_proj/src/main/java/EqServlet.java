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
        String searchKeyword = request.getParameter("searchKeyword"); // 검색 키워드
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

            // 조회 결과를 request 객체에 저장
            request.setAttribute("resultList", resultList);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "데이터베이스 오류");
            return;
        }

        // 결과를 JSP로 전달
        String url = "eqcreate.jsp";
        request.getRequestDispatcher(url).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        String action = request.getParameter("action");

        if ("삭제".equals(action)) {
            // 삭제 처리
            String checkParam = request.getParameter("check");
            if (checkParam != null && !checkParam.isEmpty()) {
                String[] eqIds = checkParam.split(",");
                EqDAO eqDAO = new EqDAO();
                try {
                    eqDAO.deleteEq(eqIds);
                } catch (SQLException e) {
                    e.printStackTrace();
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "삭제 중 오류 발생");
                    return;
                }
            }
        } else if ("수정".equals(action)) {
            // 수정 처리
            try {
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

        // 작업 완료 후 목록으로 리디렉션
        response.sendRedirect("/p_eq"); // URL 변경에 따라 리디렉션 경로 수정
    }
}
