package atmin_v5.dao;
import atmin_v5.db.DBUtility;
import atmin_v5.model.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    private static final String DB = "student_management";

    public List<Doctor> findAll() {
        List<Doctor> list = new ArrayList<>();
        String sql = "SELECT * FROM doctors";

        try (
                Connection conn = DBUtility.getInstance().getConnection(DB);
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                Doctor d = new Doctor(
                        rs.getInt("id"),
                        rs.getString("fullname"),
                        rs.getString("specialty")
                );
                list.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insert(Doctor doctor) {
        String sql = "INSERT INTO doctors(id, fullname, specialty) VALUES (?, ?, ?)";

        try (
                Connection conn = DBUtility.getInstance().getConnection(DB);
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, doctor.getId());
            ps.setString(2, doctor.getFullname());
            ps.setString(3, doctor.getSpecialty());

            ps.executeUpdate();
            System.out.println("Thêm bác sĩ thành công");

        } catch (SQLException e) {
            System.out.println("Lỗi thêm bác sĩ: " + e.getMessage());
        }
    }
    @SuppressWarnings("CallToPrintStackTrace")
    public void statisticBySpecialty() {
        String sql = "SELECT specialty, COUNT(*) total FROM doctors GROUP BY specialty";

        try (
                Connection conn = DBUtility.getInstance().getConnection(DB);
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {
            System.out.println("=== Thống kê chuyên khoa ===");
            while (rs.next()) {
                System.out.println(
                        rs.getString("specialty") +
                                " : " +
                                rs.getInt("total")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}