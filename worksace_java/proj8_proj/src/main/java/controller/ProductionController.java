package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import production.ProductionDAO;
import production.ProductionDTO;


@WebServlet("/productiondash")
public class ProductionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 주별, 월별, 분기별 선택
		String unit = request.getParameter("unit"); 
		if (unit == null) unit = "month";  // 기본값: 월별 조회

        ProductionDAO productionDAO = new ProductionDAO();
        List<ProductionDTO> productionList = productionDAO.getProductionData(unit);

        request.setAttribute("productionList", productionList);
        request.setAttribute("unit", unit);
        request.getRequestDispatcher("/WEB-INF/views/production_dashboard.jsp").forward(request, response);
		
		}
		

	}

