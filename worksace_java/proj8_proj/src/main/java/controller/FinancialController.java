package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import financial.FinancialDAO;
import financial.FinancialDTO;


@WebServlet("/financialdash")
public class FinancialController extends HttpServlet {
	private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
    	
    	String action = request.getParameter("action");
        FinancialDAO financialDAO = new FinancialDAO();
        List<FinancialDTO> resultList;

        if ("search".equals(action)) {
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");
            resultList = financialDAO.selectFinancialByPeriod(startDate, endDate);
        } else {
            resultList = financialDAO.selectFinancialList();
        }

        request.setAttribute("financialList", resultList);
        request.getRequestDispatcher("/WEB-INF/views/financial_dashboard.jsp").forward(request, response);
    }
}