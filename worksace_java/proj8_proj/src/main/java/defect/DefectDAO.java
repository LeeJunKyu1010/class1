package defect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DefectDAO {

	public List<DefectDTO> getDefectData(String unit) {
		System.out.println("getDefectData 실행");
        List<DefectDTO> defectList = new ArrayList<>();
        
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
            Connection con = ds.getConnection();

            String query = " SELECT ";
            if ("week".equals(unit)) {
                query += "TO_CHAR(defect_date, 'IYYY-IW') AS defect_date, ";
            } else if ("month".equals(unit)) {
                query += "TO_CHAR(defect_date, 'YYYY-MM') AS defect_date, ";
            } else if ("quarter".equals(unit)) {
                query += "TO_CHAR(defect_date, 'YYYY-Q') AS defect_date, ";
            }
            query += " SUM(defect_count) AS defect_count FROM p_defect GROUP BY ";
            if ("week".equals(unit)) {
                query += "TO_CHAR(defect_date, 'IYYY-IW')";
            } else if ("month".equals(unit)) {
                query += "TO_CHAR(defect_date, 'YYYY-MM')";
            } else if ("quarter".equals(unit)) {
                query += "TO_CHAR(defect_date, 'YYYY-Q')";
            }
            query += " ORDER BY defect_date  ";

            PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DefectDTO defectDTO = new DefectDTO();
                defectDTO.setDefectDate(rs.getString("defect_date"));
                defectDTO.setDefectCount(rs.getInt("defect_count"));
                defectList.add(defectDTO);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defectList;
    }
}
	
