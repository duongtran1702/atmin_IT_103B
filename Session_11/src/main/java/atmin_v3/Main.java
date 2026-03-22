package atmin_v3;

import db_atmin.DBUtility;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        int inputId = 101;

        try (
                Connection conn = DBUtility.getInstance().getConnection("db_hospital");
                Statement stmt = conn.createStatement()
        ) {
            String sql = "UPDATE Beds SET bed_status = 'Occupied' WHERE bed_id = " + inputId;

            int rowsAffected = stmt.executeUpdate(sql);

            if (rowsAffected > 0) {
                System.out.println("Cap nhat thanh cong");
            } else {
                System.out.println("Ma giuong " + inputId + " khong ton tai");
            }

        } catch (SQLException e) {
            System.out.println("Loi ket noi: " + e.getMessage());
        }
    }
}