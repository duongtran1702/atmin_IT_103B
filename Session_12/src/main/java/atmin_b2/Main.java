package atmin_b2;

import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        double temp = 38;
        int id = 102;
        final String sql = "UPDATE patient_vitals SET temperature = ? WHERE patient_id = ?";
        try (Connection conn = DB.getInstance().getConnection("hospital_db");
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, temp);
            ps.setInt(2, id);

            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("update patient_vitals successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
