package atmin_b4;

import db.DB;

import java.sql.*;

public class Main {
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        final String sql = "Insert into results(data) values (?)";

        try (Connection conn = DB.getInstance().getConnection("hospital_db");
             PreparedStatement ps = conn.prepareStatement(sql)) {
            for (int i = 1; i <= 1000; i++) {
                if (i % 2 == 0) {
                    ps.setString(1, "Normal");
                } else {
                    ps.setString(1, "Not normal");
                }

                // Thêm vào batch
                ps.addBatch();

                // Gửi batch mỗi 100 lần để tránh quá lớn
                if (i % 100 == 0) {
                    ps.executeBatch();
                }
            }

            // Thực thi phần còn lại
            ps.executeBatch();
            System.out.println("Inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
