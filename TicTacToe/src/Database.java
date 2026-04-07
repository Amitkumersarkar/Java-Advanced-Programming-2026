import java.sql.*;

public class Database {

    static final String URL = "jdbc:mysql://localhost:3306/tictactoe";
    static final String USER = "root";
    static final String PASS = "";

    public static void saveResult(String winner) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASS);

            String query = "INSERT INTO results (winner) VALUES (?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, winner);

            ps.executeUpdate();

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}