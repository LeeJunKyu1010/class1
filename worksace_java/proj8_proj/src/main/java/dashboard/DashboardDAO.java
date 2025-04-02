package dashboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DashboardDAO {

    public int getTotalProduction() {
        int totalProduction = 0;
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
            Connection con = ds.getConnection();

            String query = "SELECT SUM(quantity) AS total FROM p_production";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                totalProduction = rs.getInt("total");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalProduction;
    }

    public int getTotalSales() {
        int totalSales = 0;
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
            Connection con = ds.getConnection();

            String query = "SELECT SUM(total_sales) AS total FROM p_financial";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                totalSales = rs.getInt("total");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalSales;
    }

    public double getAvgDefectRate() {
        double avgDefectRate = 0.0;
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
            Connection con = ds.getConnection();

            String query = "SELECT AVG(defect_count) AS avg_defect FROM p_defect";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                avgDefectRate = rs.getDouble("avg_defect");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return avgDefectRate;
    }
}