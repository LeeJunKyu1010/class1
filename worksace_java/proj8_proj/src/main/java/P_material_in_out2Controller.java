

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/P_material_in_out2Controller")
public class P_material_in_out2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchKeyword = request.getParameter("searchKeyword");
		
		 if (searchKeyword != null) {
		        searchKeyword = searchKeyword.trim();
		    }
		    P_material_in_out2DAO p_skuDAO = new P_material_in_out2DAO();
		    List<P_material_in_out2DTO> resultList;
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
			String url = "p_material_in_out2.jsp";
			request.getRequestDispatcher(url).forward(request, response);
		}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
