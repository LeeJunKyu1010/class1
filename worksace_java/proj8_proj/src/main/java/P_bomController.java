
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/P_bomController")
public class P_bomController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 조회할떄 쓰이는 입력하는곳 이름
		String searchKeyword = request.getParameter("searchKeyword");

		P_bomDAO p_skuDAO = new P_bomDAO();
		List<P_bomDTO> resultList;
		try {
			if (searchKeyword != null && !searchKeyword.isEmpty()) {
				// 검색어가 있을 경우 검색 메서드 호출
				resultList = p_skuDAO.searchP_skuList(searchKeyword);
				if (resultList.isEmpty()) {
	                request.setAttribute("message", "검색 결과가 없습니다.");
	            }
			} else {
				// 검색어가 없을 경우 전체 목록 조회
				resultList = p_skuDAO.selectP_skuList();
			}
			// 조회 결과 저장
			request.setAttribute("resultList", resultList);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "데이터베이스 오류");
			return;
		}
		String url = "p_bom.jsp";
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
                String[] skuIds = checkParam.split(",");
                P_bomDAO p_skuDAO = new P_bomDAO();
                try {
                	// 배열을 사용해서 체크된거 삭제 메서드를 부름
                    p_skuDAO.deleteSkus(skuIds);
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
				int bom_id = Integer.parseInt(request.getParameter("bom_id"));
				String sku_id_material = request.getParameter("p_sku");
				int consumption = Integer.parseInt(request.getParameter("p_sku1"));
//				

				P_bomDTO p_skuDTO = new P_bomDTO();
				// 각 파라미터 값을 p_skuDTO에 설정
				p_skuDTO.setBom_id(bom_id);
				p_skuDTO.setSku_id_material(sku_id_material);
				p_skuDTO.setConsumption(consumption);
//				

				P_bomDAO p_skuDAO = new P_bomDAO();
				// P_skuDTO를 사용하여 DB 수정 메서드를 부름
				p_skuDAO.updateSku(p_skuDTO);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "잘못된 가격 형식");
				return;
			} catch (SQLException e) {
				e.printStackTrace();
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "수정 중 오류 발생");
				return;
			}
			// 삭제 또는 수정이 아니면 등록되게 하기
		} else {
			try {
				//각 파라미터값 가져오기
				String skuidmaterial = request.getParameter("p_sku");
				int consumption = Integer.parseInt(request.getParameter("p_sku1"));
				int skuid = Integer.parseInt(request.getParameter("p_sku2"));
				String work_method = request.getParameter("p_sku3");

				// DTO에 값 설정
				P_bomDTO p_skuDTO = new P_bomDTO();
				p_skuDTO.setSku_id_material(skuidmaterial);
				p_skuDTO.setConsumption(consumption);
				p_skuDTO.setSku_id(skuid);
				p_skuDTO.setWork_method(work_method);

				 // DAO를 통해 등록 메서드 호출
				P_bomDAO p_skuDAO = new P_bomDAO();
				p_skuDAO.insertsku(p_skuDTO);
				System.out.println("데이터 등록 성공: " + p_skuDTO.getBom_id());

				// 등록 후 doGet() 메서드 호출하여 테이블 다시 로드
				doGet(request, response);

			} catch (NumberFormatException e) {
				e.printStackTrace();
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "잘못된 가격 형식");
				return;
			} catch (SQLException e) {
				e.printStackTrace();
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "등록 중 오류 발생");
				return;
			}
		}
     // 등록 완료 후 리다이렉트
		response.sendRedirect("P_bomController");
	}
}