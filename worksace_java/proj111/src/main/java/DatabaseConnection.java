import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

   public static Connection getConnection() throws Exception {
       String url = "jdbc:oracle:thin:@localhost:1521:xe"; // Replace with your DB URL
       String username = "your_username"; // Replace with your DB username
       String password = "your_password"; // Replace with your DB password

       Class.forName("oracle.jdbc.driver.OracleDriver"); // Oracle driver class
       return DriverManager.getConnection(url, username, password);
   }
}
