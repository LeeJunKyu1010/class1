import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/p_sku")
public class P_skuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 조회할떄 쓰이는 입력하는곳 이름
				 String searchKeyword = request.getParameter("searchKeyword");
				 
				    P_skuDAO p_skuDAO = new P_skuDAO();
				    List<P_skuDTO> resultList;
				    try {
				        if (searchKeyword != null && !searchKeyword.isEmpty()) {
				            // 검색어가 있을 경우 검색 메서드 호출
				            resultList = p_skuDAO.searchP_skuList(searchKeyword);
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
				    
				    String url = "p_sku.jsp";
				    request.getRequestDispatcher(url).forward(request, response);
				}


			
			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			                P_skuDAO p_skuDAO = new P_skuDAO();
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
			                int skuId = Integer.parseInt(request.getParameter("skuId"));
			                String skuCode = request.getParameter("p_sku");
			                String skuName = request.getParameter("p_sku1");
			                String skuSize = request.getParameter("p_sku2");
			                String vendorName = request.getParameter("p_sku3");
			                int price = Integer.parseInt(request.getParameter("p_sku4"));
			                String skuCategory = request.getParameter("p_sku5");

			                P_skuDTO p_skuDTO = new P_skuDTO();
			                // 각 파라미터 값을 p_skuDTO에 설정
			                p_skuDTO.setSku_id(skuId);
			                p_skuDTO.setSku_code(skuCode);
			                p_skuDTO.setSku_name(skuName);
			                p_skuDTO.setSku_size(skuSize);
			                p_skuDTO.setVendor_name(vendorName);
			                p_skuDTO.setPrice(price);
			                p_skuDTO.setSku_category(skuCategory);

			                P_skuDAO p_skuDAO = new P_skuDAO();
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
			        	//각 파라미터값 가져오기
			            String skuCode = request.getParameter("p_sku");
			            String skuName = request.getParameter("p_sku1");
			            String skuSize = request.getParameter("p_sku2");
			            String vendorName = request.getParameter("p_sku3");
			            try {
			            	// 이건 String이 아니여서 여기서함 밖에서 했는데 계속 에러나서
			                int price = Integer.parseInt(request.getParameter("p_sku4"));
			                String skuCategory = request.getParameter("p_sku5");
			                
			                //위에서 각자 파라미터값 가져온것을 DTO에 설정
			                P_skuDTO p_skuDTO = new P_skuDTO();
			                p_skuDTO.setSku_code(skuCode);
			                p_skuDTO.setSku_name(skuName);
			                p_skuDTO.setSku_size(skuSize);
			                p_skuDTO.setVendor_name(vendorName);
			                p_skuDTO.setPrice(price);
			                p_skuDTO.setSku_category(skuCategory);

			                P_skuDAO p_skuDAO = new P_skuDAO();
			                // 등록 메소드 호출
			                p_skuDAO.insertsku(p_skuDTO);
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
			        response.sendRedirect("p_sku");
			     // 끝난뒤 맨위로 올리기 
			    }
			}