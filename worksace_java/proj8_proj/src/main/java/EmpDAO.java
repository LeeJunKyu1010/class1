import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class EmpDAO {
	public EmpDTO getUserInfo(String id, String pw) {
	    EmpDTO user = null;
	    try {
	        Context ctx = new InitialContext();
	        DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
	        Connection conn = ds.getConnection();

	        String query = "SELECT * FROM P_EMP WHERE EMP_ID = ? AND PW = ?";
	        PreparedStatement ps = conn.prepareStatement(query);
	        ps.setString(1, id.trim());
	        ps.setString(2, pw.trim());

	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            user = new EmpDTO();
	            user.setEmpNo(rs.getInt("EMPNO"));
	            user.setEmpId(rs.getString("EMP_ID"));
	            user.setEmpName(rs.getString("EMP_NAME"));
	            user.setPassword(rs.getString("PW"));
	            user.setEmail(rs.getString("EMAIL"));
	            user.setPhone(rs.getString("PHONE"));
	            user.setGrade(rs.getInt("GRADE"));
	        }

	        rs.close();
	        ps.close();
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return user;
	}
	
	// EmpDAO.java
	public List<EmpDTO> getAllUsers() {
	    List<EmpDTO> users = new ArrayList<>();
	    
	    try {
	        Context ctx = new InitialContext();
	        DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
	        Connection conn = ds.getConnection();
	        
	        String query = "SELECT * FROM P_EMP";
	        PreparedStatement ps = conn.prepareStatement(query);
	        
	        ResultSet rs = ps.executeQuery();
	        
	        while (rs.next()) {
	            EmpDTO user = new EmpDTO();
	            user.setEmpNo(rs.getInt("EMPNO"));
	            user.setEmpId(rs.getString("EMP_ID"));
	            user.setEmpName(rs.getString("EMP_NAME"));
	            user.setPassword(rs.getString("PW"));
	            user.setEmail(rs.getString("EMAIL"));
	            user.setPhone(rs.getString("PHONE"));
	            user.setGrade(rs.getInt("GRADE"));
	            
	            users.add(user);
	        }
	        
	        rs.close();
	        ps.close();
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return users;
	}


}
