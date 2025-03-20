package dashboard;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import defect.DefectDAO;
import defect.DefectDTO;

@WebServlet("/dashboard")
public class DashboardController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DashboardDAO dashboardDAO = new DashboardDAO();

        int totalProduction = dashboardDAO.getTotalProduction();
        int totalSales = dashboardDAO.getTotalSales();
        double avgDefectRate = dashboardDAO.getAvgDefectRate();

        request.setAttribute("totalProduction", totalProduction);
        request.setAttribute("totalSales", totalSales);
        request.setAttribute("avgDefectRate", avgDefectRate);

        request.getRequestDispatcher("/WEB-INF/views/main_dashboard.jsp").forward(request, response);
    }
}