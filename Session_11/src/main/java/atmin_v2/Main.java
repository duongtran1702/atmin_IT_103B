package atmin_v2;

import db_atmin.DBUtility;
import java.sql.*;

public class Main {
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        try (
                Connection conn = DBUtility.getInstance().getConnection("db_hospital");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT medicine_name, stock FROM Pharmacy")
        ) {

            System.out.println("--- DANH MỤC THUỐC ---");

            while (rs.next()) {
                System.out.println(
                        rs.getString("medicine_name") + " - " +
                                rs.getInt("stock")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}