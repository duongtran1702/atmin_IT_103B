package atmin_v2;

import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

    @SuppressWarnings("CallToPrintStackTrace")
    public void processInvoicePayment(int patientId, int invoiceId, double amount) {

        try (Connection conn = DB.getInstance().getConnection("db_hospital_ss13")) {
            conn.setAutoCommit(false);
            try (
                    PreparedStatement ps1 = conn.prepareStatement(
                            "UPDATE Patient_Wallet SET balance = balance - ? WHERE patient_id = ?"
                    );
                    PreparedStatement ps2 = conn.prepareStatement(
                            "UPDATE Invoicess SET status = 'PAID' WHERE invoice_id = ?"
                    )
            ) {

                ps1.setDouble(1, amount);
                ps1.setInt(2, patientId);
                ps1.executeUpdate();

                ps2.setInt(1, invoiceId);
                ps2.executeUpdate();

                conn.commit();
                System.out.println("Thanh toán thành công!");

            } catch (SQLException e) {
                System.out.println("Lỗi: " + e.getMessage());

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
        Main m = new Main();
        m.processInvoicePayment(1, 1001, 500000);
    }
}