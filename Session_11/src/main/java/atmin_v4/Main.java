package atmin_v4;


import java.sql.*;
        import db_atmin.DBUtility;

public class Main {
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {

        String patientName = "' OR '1'='1"; // Chuỗi nguy hiểm

        // 1. Lọc dữ liệu đầu vào
        patientName = patientName.replace("'", "")
                .replace("--", "")
                .replace(";", "");

        try (
                Connection conn = DBUtility.getInstance().getConnection("db_hospital");
                Statement stmt = conn.createStatement()
        ) {

            // 2. Tạo câu SQL
            String sql = "SELECT * FROM Patients WHERE full_name = '" + patientName + "'";

            // In ra để kiểm tra
            System.out.println("SQL sau khi lọc: " + sql);

            // 3. Thực thi
            ResultSet rs = stmt.executeQuery(sql);

            // 4. Kết quả
            if (!rs.next()) {
                System.out.println("Khong tim thay benh nhan");
            } else {
                do {
                    System.out.println("Tim thay: " + rs.getString("name"));
                } while (rs.next());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}