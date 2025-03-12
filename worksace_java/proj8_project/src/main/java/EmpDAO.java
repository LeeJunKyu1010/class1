import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class EmpDAO {

    private Connection getConnection() throws Exception {
        Context ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
        return ds.getConnection();
    }

    public boolean validateLogin(String empId, String password) {
        boolean isValid = false;

        try (Connection con = getConnection()) {
            // SQL 쿼리에서 컬럼명을 'PASSWORD'로 수정
            String sql = "SELECT * FROM P_EMP WHERE EMP_ID = ? AND PASSWORD = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, empId);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                isValid = true; // 로그인 성공
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isValid;
    }
}
