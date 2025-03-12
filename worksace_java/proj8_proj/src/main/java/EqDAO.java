import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class EqDAO {

	public int insertEq(EqDTO eqDTO) {
	    int result = -1;
	    try {
	        Context ctx = new InitialContext();
	        DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
	        Connection con = ds.getConnection();
	        
	        String query = "insert into p_facility values (?,?,?,?,?,?,?)";
	        PreparedStatement ps = con.prepareStatement(query);
	        
	        ps.setInt(1, eqDTO.getFacility_code());
	        ps.setString(2, eqDTO.getFacility_manager());
	        ps.setDate(3, eqDTO.getInstallation_date());
	        ps.setString(4, eqDTO.getFacility_name());
	        ps.setString(5, eqDTO.getFacility_location());
	        ps.setString(6, eqDTO.getInspection_cycle());
	        ps.setString(7, eqDTO.getRemarks());
	        
	        result = ps.executeUpdate();
	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return result;
	}

}