package production;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class ProductionDAO {

    public List<ProductionDTO> getProductionData(String unit) {
		System.out.println("getProductionData 실행");
		List<ProductionDTO> productionList = new ArrayList<>();

		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			// [SQL 준비]
			
            String query = "SELECT ";
            if ("week".equals(unit)) {
                query += "TO_CHAR(production_date, 'IYYY-IW') AS period, ";
            } else if ("month".equals(unit)) {
                query += "TO_CHAR(production_date, 'YYYY-MM') AS period, ";
            } else if ("quarter".equals(unit)) {
                query += "TO_CHAR(production_date, 'YYYY-Q') AS period, ";
            }
            query += "SUM(quantity) AS total_production ";
            query += "FROM P_PRODUCTION ";
            query += "GROUP BY ";
            if ("week".equals(unit)) {
                query += "TO_CHAR(production_date, 'IYYY-IW')";
            } else if ("month".equals(unit)) {
                query += "TO_CHAR(production_date, 'YYYY-MM')";
            } else if ("quarter".equals(unit)) {
                query += "TO_CHAR(production_date, 'YYYY-Q')";
            }
            query += " ORDER BY period";
			
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			// [SQL 실행] 및 [결과 확보]
			while (rs.next()) {
                ProductionDTO dto = new ProductionDTO();
                dto.setPeriod(rs.getString("period"));
                dto.setTotalProduction(rs.getInt("total_production"));
                productionList.add(dto);
			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return productionList;
	}
	
	
}
	
