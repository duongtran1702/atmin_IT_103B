package atmin_b1;

import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        final String sql = "Select * from doctors where doctor_code = ? and password = ?";

        try (Connection conn = DB.getInstance().getConnection("hospital_db");
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "DOC001");
            ps.setString(2, "123456");
            try (ResultSet rs = ps.executeQuery()) {
                if (rs == null || !rs.next()) {
                    System.out.println("Not existed");
                    return;
                }
                System.out.printf("| %-8s | %-15s | %-20s | %-10s |\n",
                        "Code","Password","Full Name","Role");
                do {
                    System.out.printf("| %-8s | %-15s | %-20s | %-10s |\n",
                            rs.getString("doctor_code"),
                            rs.getString("password"),
                            rs.getString("full_name"),
                            rs.getString("role"));

                } while (rs.next());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
