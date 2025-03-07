import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private String url = "jdbc:mysql://localhost:3306/your_database";
    private String user = "your_username";
    private String password = "your_password";

    public UserDTO getUser(String id, String pw) {
        UserDTO userDTO = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM users WHERE id = ? AND pw = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pw);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                userDTO = new UserDTO();
                userDTO.setId(rs.getString("id"));
                userDTO.setPw(rs.getString("pw"));
                userDTO.setGrade(rs.getInt("grade"));
            }

            rs.close();
            pstmt.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return userDTO;
    }
}
