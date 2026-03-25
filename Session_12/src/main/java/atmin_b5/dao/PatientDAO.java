package atmin_b5.dao;

import atmin_b5.model.Patient;
import db.DB;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    public List<Patient> getAllPatients() throws SQLException {
        List<Patient> list = new ArrayList<>();
        String sql = "SELECT patient_id, name, age, department,disease FROM patients";
        try (Connection conn = DB.getInstance().getConnection("atmin_db_hospital");
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Patient p = new Patient(
                        rs.getInt("patient_id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("department"),
                        rs.getString("disease")
                );
                list.add(p);
            }
        }
        return list;
    }

    public void addPatient(String name, int age, String department, String disease) throws SQLException {
        String sql = "INSERT INTO patients(name, age, department, disease,admission_date) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DB.getInstance().getConnection("atmin_db_hospital");
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, department);
            ps.setString(4, disease);
            ps.setDate(5, Date.valueOf(LocalDate.now()));
            ps.executeUpdate();
        }
    }

    public boolean updateDisease(int patientId, String disease) throws SQLException {
        String sql = "UPDATE patients SET disease = ? WHERE patient_id = ?";
        boolean result = false;
        try (Connection conn = DB.getInstance().getConnection("atmin_db_hospital");
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, disease);
            ps.setInt(2, patientId);
            int row = ps.executeUpdate();
            if (row > 0) {
                result = true;
            }
        }
        return result;
    }

}
