package financial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class FinancialDAO {

	public List<FinancialDTO> selectFinancialList() {
		System.out.println("selectFinancialList 실행");
		List<FinancialDTO> financialList = new ArrayList<>();

		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			String query = "SELECT * FROM p_financial ORDER BY report_date DESC";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				FinancialDTO financialDTO = new FinancialDTO();
				financialDTO.setFinancialId(rs.getInt("financial_id"));
				financialDTO.setReportDate(rs.getDate("report_date"));
				financialDTO.setTotalSales(rs.getInt("total_sales"));
				financialDTO.setOperatingProfit(rs.getInt("operating_profit"));
				financialDTO.setNetProfit(rs.getInt("net_profit"));
				financialDTO.setIbId(rs.getInt("ib_id"));

				financialList.add(financialDTO);
			}

			rs.close();
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return financialList;
	}
	
	// 특정 기간별 데이터 조회
    public List<FinancialDTO> selectFinancialByPeriod(String startDate, String endDate) {
        List<FinancialDTO> financialList = new ArrayList<>();

        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
            Connection con = ds.getConnection();

            String query = "SELECT * FROM p_financial WHERE report_date BETWEEN TO_DATE(?, 'YYYY-MM-DD') AND TO_DATE(?, 'YYYY-MM-DD') ORDER BY report_date";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, startDate);
            ps.setString(2, endDate);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                FinancialDTO dto = new FinancialDTO();
                dto.setFinancialId(rs.getInt("financial_id"));
                dto.setReportDate(rs.getDate("report_date"));
                dto.setTotalSales(rs.getInt("total_sales"));
                dto.setOperatingProfit(rs.getInt("operating_profit"));
                dto.setNetProfit(rs.getInt("net_profit"));
                dto.setIbId(rs.getInt("ib_id"));

                financialList.add(dto);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return financialList;
    }
	
	
}
