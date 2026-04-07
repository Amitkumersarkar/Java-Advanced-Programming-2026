import java.sql.*;

public class Database {

    static final String URL = "jdbc:mysql://localhost:3306/tictactoe";
    static final String USER = "root";
    static final String PASS = "";

    public static void saveResult(String winner) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println(" Connected to Database!");

            String query = "INSERT INTO results (winner) VALUES (?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, winner);

            ps.executeUpdate();
            System.out.println(" Data Inserted!");

            conn.close();
        } catch (Exception e) {
            System.out.println(" Error Occurred:");
            e.printStackTrace();
        }
    }

    // Test main method
    public static void main(String[] args) {
        saveResult("TEST");
    }
}