package EX18.EX87;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String URL = "jdbc:h2:mem:ex2;DB_CLOSE_DELAY=-1";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, "sa", "");
    }
}
