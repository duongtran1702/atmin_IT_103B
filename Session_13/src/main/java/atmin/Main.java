package atmin;

import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

    @SuppressWarnings("CallToPrintStackTrace")
    public void dispenseMedicine(int medicineId, int patientId) {

        try (Connection conn = DB.getInstance().getConnection("db_hospital_ss13")) {
            conn.setAutoCommit(false);
            try (
                    PreparedStatement ps1 = conn.prepareStatement(
                            "UPDATE Medicine_Inventory SET quantity = quantity - 1 WHERE medicine_id = ?"
                    );
                    PreparedStatement ps2 = conn.prepareStatement(
                            "INSERT INTO Prescription_History (patient_id, medicine_id, date) VALUES (?, ?, GETDATE())"
                    )
            ) {

                ps1.setInt(1, medicineId);
                ps1.executeUpdate();

                ps2.setInt(1, patientId);
                ps2.setInt(2, medicineId);
                ps2.executeUpdate();

                conn.commit();
                System.out.println("Cấp phát thuốc thành công!");

            } catch (SQLException e) {
                System.out.println("Có lỗi xảy ra: " + e.getMessage());

                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int medicineId = 1;
        int patientId = 101;

        Main m = new Main();
        m.dispenseMedicine(medicineId, patientId);
    }
}