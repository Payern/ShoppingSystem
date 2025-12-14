import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    // Change these values to match your MySQL setup
    private static final String URL = "jdbc:mysql://localhost:3306/shoppingdb";
    private static final String USER = "root"; // your MySQL username
    private static final String PASSWORD = "Stjosephs9344"; // your MySQL password

    // Method to get a connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}