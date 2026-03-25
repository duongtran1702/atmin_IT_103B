package atmin_v5;

import db.DB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReceptionController {

    @SuppressWarnings("CallToPrintStackTrace")
    public List<Integer> getAvailableBeds() {
        List<Integer> beds = new ArrayList<>();

        try (Connection conn = DB.getInstance().getConnection("db_hospital_ss13");
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT bed_id FROM Bed WHERE status = 'AVAILABLE'"
             );
             ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                beds.add(rs.getInt("bed_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return beds;
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public void admitPatient(String name, int age, int bedId, double deposit) {

        try (Connection conn = DB.getInstance().getConnection("db_hospital_ss13")) {

            conn.setAutoCommit(false);

            try (
                    PreparedStatement checkBed = conn.prepareStatement(
                            "SELECT status FROM Bed WHERE bed_id = ?"
                    );
                    PreparedStatement insertPatient = conn.prepareStatement(
                            "INSERT INTO Patient(name, age, bed_id) VALUES (?, ?, ?)",
                            Statement.RETURN_GENERATED_KEYS
                    );
                    PreparedStatement updateBed = conn.prepareStatement(
                            "UPDATE Bed SET status = 'OCCUPIED' WHERE bed_id = ?"
                    );
                    PreparedStatement insertFinance = conn.prepareStatement(
                            "INSERT INTO Finance(patient_id, balance) VALUES (?, ?)"
                    )
            ) {

                // check giường
                checkBed.setInt(1, bedId);
                ResultSet rs = checkBed.executeQuery();

                if (!rs.next() || !"AVAILABLE".equals(rs.getString("status"))) {
                    throw new Exception("Giường không hợp lệ hoặc đã có người");
                }

                // insert bệnh nhân
                insertPatient.setString(1, name);
                insertPatient.setInt(2, age);
                insertPatient.setInt(3, bedId);
                insertPatient.executeUpdate();

                ResultSet key = insertPatient.getGeneratedKeys();
                key.next();
                int patientId = key.getInt(1);

                // update giường
                updateBed.setInt(1, bedId);
                if (updateBed.executeUpdate() == 0) {
                    throw new Exception("Update giường thất bại");
                }

                // insert tài chính
                insertFinance.setInt(1, patientId);
                insertFinance.setDouble(2, deposit);
                insertFinance.executeUpdate();

                conn.commit();
                System.out.println("Tiếp nhận thành công!");

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
}