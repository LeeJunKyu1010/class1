import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class EmpDAO {

    private DataSource dataSource;

    // Default Constructor: JNDI를 통해 DataSource 초기화
    public EmpDAO() {
        try {
            Context ctx = new InitialContext();
            this.dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 로그인 처리 메서드
    public EmpDTO login(String empId, String pw) {
        EmpDTO emp = null;

        try (Connection con = dataSource.getConnection()) {
            // [SQL 준비]
            String query = "SELECT * FROM P_EMP WHERE EMP_ID = ? AND PW = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, empId);
            ps.setString(2, pw);

            // [SQL 실행] 및 [결과 확보]
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                emp = new EmpDTO();
                emp.setEmpNo(rs.getLong("EMPNO"));
                emp.setEmpId(rs.getString("EMP_ID"));
                emp.setEmpName(rs.getString("EMP_NAME"));
                emp.setPw(rs.getString("PW"));
                emp.setEmail(rs.getString("EMAIL"));
                emp.setPhone(rs.getString("PHONE"));
                emp.setGrade(rs.getInt("GRADE"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emp; // 로그인 성공 시 EmpDTO 객체 반환, 실패 시 null 반환
    }
}
