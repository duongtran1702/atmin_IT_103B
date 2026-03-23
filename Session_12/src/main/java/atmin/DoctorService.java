package atmin;

import db.DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorService {

    @SuppressWarnings("CallToPrintStackTrace")
    public List<Doctor> findDoctorBySpecialty(String specialty) {
        List<Doctor> doctors = new ArrayList<Doctor>();
        final String sql = "SELECT * FROM Doctors WHERE specialty = ?";
        try (Connection conn = DB.getInstance().getConnection("db_hospital_btth");
             PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, specialty);
            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    Doctor d = new Doctor();
                    d.setId(rs.getInt("doctor_id"));
                    d.setFullName(rs.getString("full_name"));
                    d.setSpecialty(rs.getString("specialty"));
                    d.setExpYears(rs.getInt("experience_years"));
                    d.setBaseSalary(rs.getDouble("base_salary"));
                    d.setPassword(rs.getString("password"));
                    doctors.add(d);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public boolean updatePassword(int id, String newPass) {
        final String sql = "UPDATE Doctors SET password = ? WHERE doctor_id = ?";
        boolean result = false;
        try (Connection conn = DB.getInstance().getConnection("db_hospital_btth");
             PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setInt(2, id);
            ps.setString(1, newPass);

            int row = ps.executeUpdate();
            if (row > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public double calculateDutyFee(int doctorId) {
        double dutyFee = 0;
        final String sql = "{call calculate_duty_fee(?, ?)}";

        try (Connection conn = DB.getInstance().getConnection("db_hospital_btth");
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, doctorId);

            cs.registerOutParameter(2, java.sql.Types.DOUBLE);
            cs.execute();

            dutyFee = cs.getDouble(2);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dutyFee;
    }

    public static void main(String[] args) {
        List<Doctor> doctors;
        DoctorService ds = new DoctorService();
        doctors = ds.findDoctorBySpecialty("Noi");
        for (Doctor d : doctors) {
            System.out.println(d);
        }
        System.out.println(ds.calculateDutyFee(2));
    }
}
