import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EqServlet")
public class EqServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // doGet 메서드: 설비 목록 조회
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EqDAO eqDAO = new EqDAO();
        List<EqDTO> eqList = eqDAO.getEqList();
        request.setAttribute("eqList", eqList); // eqList 변수 설정
        request.getRequestDispatcher("eqcreate.jsp").forward(request, response); // JSP 파일 이름 수정
    }

    // doPost 메서드: 등록, 수정, 삭제 요청 처리
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        String command = request.getParameter("command");

        if ("insert".equals(command)) {
            insertEq(request, response);
        } else if ("update".equals(command)) {
            updateEq(request, response);
        } else if ("delete".equals(command)) {
            deleteEq(request, response);
        }
    }

    // 등록 요청 처리 메서드
    private void insertEq(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EqDTO eqDTO = new EqDTO();
        eqDTO.setFacility_code(Integer.parseInt(request.getParameter("facilityCode")));
        eqDTO.setFacility_manager(request.getParameter("facilityManager"));
        eqDTO.setInstallation_date(Date.valueOf(request.getParameter("installationDate")));
        eqDTO.setFacility_name(request.getParameter("facilityName"));
        eqDTO.setFacility_location(request.getParameter("facilityLocation"));
        eqDTO.setInspection_cycle(request.getParameter("inspectionCycle"));
        eqDTO.setRemarks(request.getParameter("remarks"));

        EqDAO eqDAO = new EqDAO();
        int result = eqDAO.insertEq(eqDTO);

        if (result > 0) {
            System.out.println("데이터베이스에 성공적으로 등록되었습니다.");
            response.sendRedirect("EqServlet"); // 등록 후 목록 페이지로 이동
        } else {
            System.out.println("등록 실패");
            request.setAttribute("error", "Insert failed");
            request.getRequestDispatcher("eqcreate.jsp").forward(request, response);
        }
    }

    // 수정 요청 처리 메서드
    private void updateEq(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EqDTO eqDTO = new EqDTO();
        eqDTO.setFacility_code(Integer.parseInt(request.getParameter("facilityCode")));
        eqDTO.setFacility_manager(request.getParameter("facilityManager"));
        eqDTO.setInstallation_date(Date.valueOf(request.getParameter("installationDate")));
        eqDTO.setFacility_name(request.getParameter("facilityName"));
        eqDTO.setFacility_location(request.getParameter("facilityLocation"));
        eqDTO.setInspection_cycle(request.getParameter("inspectionCycle"));
        eqDTO.setRemarks(request.getParameter("remarks"));

        EqDAO eqDAO = new EqDAO();
        int result = eqDAO.updateEq(eqDTO);

        if (result > 0) {
            System.out.println("데이터베이스에 성공적으로 수정되었습니다.");
            response.sendRedirect("EqServlet"); // 수정 후 목록 페이지로 이동
        } else {
            System.out.println("수정 실패");
            request.setAttribute("error", "Update failed");
            request.getRequestDispatcher("eqcreate.jsp").forward(request, response);
        }
    }

    // 삭제 요청 처리 메서드
    private void deleteEq(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int facility_code = Integer.parseInt(request.getParameter("facilityCode"));

        EqDAO eqDAO = new EqDAO();
        int result = eqDAO.deleteEq(facility_code);

        if (result > 0) {
            System.out.println("데이터베이스에서 성공적으로 삭제되었습니다.");
            response.sendRedirect("EqServlet"); // 삭제 후 목록 페이지로 이동
        } else {
            System.out.println("삭제 실패");
            request.setAttribute("error", "Delete failed");
            request.getRequestDispatcher("eqcreate.jsp").forward(request, response);
        }
    }
}
