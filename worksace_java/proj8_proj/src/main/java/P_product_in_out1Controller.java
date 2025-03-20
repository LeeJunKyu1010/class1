
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/P_product_in_out1Controller")
public class P_product_in_out1Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String searchKeyword = request.getParameter("searchKeyword");

		if (searchKeyword != null) {
			searchKeyword = searchKeyword.trim();
		}
		P_product_in_out1DAO p_skuDAO = new P_product_in_out1DAO();
		List<P_product_in_out1DTO> resultList;
		try {
			if (searchKeyword != null && !searchKeyword.isEmpty()) {
				resultList = p_skuDAO.searchP_skuList(searchKeyword);
				if (resultList.isEmpty()) {
					request.setAttribute("message", "검색 결과가 없습니다.");
				}
			} else {
				resultList = p_skuDAO.selectP_skuList();
			}
			request.setAttribute("resultList", resultList);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "데이터베이스 오류");
			return;
		}
		String url = "p_product_in_out1.jsp";
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
				P_product_in_out1DAO p_skuDAO = new P_product_in_out1DAO();
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
				int Ib_id = Integer.parseInt(request.getParameter("Ib_id"));
				int productcount = Integer.parseInt(request.getParameter("p_sku"));
				int productprice = Integer.parseInt(request.getParameter("p_sku1"));
				String skutype = request.getParameter("p_sku2");
				String remarks = request.getParameter("p_sku3");

				P_product_in_out1DTO p_skuDTO = new P_product_in_out1DTO();
				// 각 파라미터 값을 p_skuDTO에 설정
				p_skuDTO.setIb_id(Ib_id);
				p_skuDTO.setProduct_count(productcount);
				p_skuDTO.setProduct_price(productprice);
				p_skuDTO.setSku_type(skutype);
				p_skuDTO.setRemarks(remarks);

				P_product_in_out1DAO p_skuDAO = new P_product_in_out1DAO();
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
				// 각 파라미터값 가져오기
				int productcount = Integer.parseInt(request.getParameter("p_sku"));
				int productprice = Integer.parseInt(request.getParameter("p_sku1"));
				String skutype = request.getParameter("p_sku2");
				String remarks = request.getParameter("p_sku3");
				int skuid = Integer.parseInt(request.getParameter("p_sku4"));
				int empno = Integer.parseInt(request.getParameter("p_sku5"));

				// DTO에 값 설정
				P_product_in_out1DTO p_skuDTO = new P_product_in_out1DTO();
				p_skuDTO.setProduct_count(productcount);
				p_skuDTO.setProduct_price(productprice);
				p_skuDTO.setSku_type(skutype);
				p_skuDTO.setRemarks(remarks);
				p_skuDTO.setSku_id(skuid);
				p_skuDTO.setEmpno(empno);

				// DAO를 통해 등록 메서드 호출
				P_product_in_out1DAO p_skuDAO = new P_product_in_out1DAO();
				p_skuDAO.insertsku(p_skuDTO);
				System.out.println("데이터 등록 성공: " + p_skuDTO.getIb_id());

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
		response.sendRedirect("P_product_in_out1Controller");
	}

}
