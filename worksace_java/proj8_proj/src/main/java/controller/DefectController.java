package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import defect.DefectDAO;
import defect.DefectDTO;

@WebServlet("/defectdash")
public class DefectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
	
		 String unit = request.getParameter("unit");
	        if (unit == null) unit = "month"; 

	        DefectDAO defectDAO = new DefectDAO();
	        List<DefectDTO> defectList = defectDAO.getDefectData(unit);

	        request.setAttribute("defectList", defectList);
	        request.setAttribute("unit", unit);

	        request.getRequestDispatcher("/WEB-INF/views/defect_dashboard.jsp").forward(request, response);
	
	}

}
