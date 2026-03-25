package atmin_v3;

import db.DB;
import java.sql.*;

public class Main {
    @SuppressWarnings("CallToPrintStackTrace")
    public void processPatientDischargeAndPayment(int maBenhNhan, double tienVienPhi) {
        try (Connection conn = DB.getInstance().getConnection("db_hospital_ss13")) {

            conn.setAutoCommit(false);

            try {
                PreparedStatement psSelect = conn.prepareStatement(
                        "SELECT balance FROM Patient_Wallet WHERE patient_id = ?"
                );
                psSelect.setInt(1, maBenhNhan);
                ResultSet rs = psSelect.executeQuery();

                if (!rs.next()) {
                    throw new Exception("Bệnh nhân không tồn tại");
                }

                double balance = rs.getDouble("balance");

                if (balance < tienVienPhi) {
                    throw new Exception("Không đủ tiền");
                }

                PreparedStatement ps1 = conn.prepareStatement(
                        "UPDATE Patient_Wallet SET balance = balance - ? WHERE patient_id = ?"
                );

                ps1.setDouble(1, tienVienPhi);
                ps1.setInt(2, maBenhNhan);
                int row1 = ps1.executeUpdate();

                if (row1 == 0) {
                    throw new Exception("Update ví thất bại");
                }

                PreparedStatement ps2 = conn.prepareStatement(
                        "UPDATE Bed SET status = 'AVAILABLE' WHERE patient_id = ?"
                );

                ps2.setInt(1, maBenhNhan);
                int row2 = ps2.executeUpdate();

                if (row2 == 0) {
                    throw new Exception("Update giường thất bại");
                }

                PreparedStatement ps3 = conn.prepareStatement(
                        "UPDATE Patient SET status = 'DISCHARGED' WHERE patient_id = ?"
                );
                ps3.setInt(1, maBenhNhan);
                int row3 = ps3.executeUpdate();

                if (row3 == 0) {
                    throw new Exception("Update bệnh nhân thất bại");
                }

                conn.commit();
                System.out.println("Xuất viện & thanh toán thành công");

            } catch (Exception e) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                System.out.println("Lỗi: " + e.getMessage());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().processPatientDischargeAndPayment(1, 500000);
    }
}