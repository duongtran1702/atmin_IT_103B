package db_atmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestCRUD {
    private static final String sql = "INSERT INTO student (id, fullname, email, birthday) VALUES (?, ?, ?, ?)";

    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        try (
                Connection conn = DBUtility.getInstance().getConnection("student_management");
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, 17);
            ps.setString(2, "John Doe");
            ps.setString(3, "joe@gmail.com");
            ps.setDate(4, new java.sql.Date(new java.util.Date().getTime()));

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

}
