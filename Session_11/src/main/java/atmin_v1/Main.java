package atmin_v1;

import db_atmin.DBUtility;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DBUtility.getInstance().getConnection("db_hospital");
            System.out.println("Kết nối thành công và đang thực hiện truy vấn...");
        } catch (SQLException e) {
            System.out.println("Lỗi khi kết nối hoặc truy vấn!");
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Kết nối đã được đóng an toàn.");
                } catch (SQLException e) {
                    System.out.println("Lỗi khi đóng kết nối!");
                    e.printStackTrace();
                }
            }
        }
    }
}