package db_atmin;

import java.sql.*;

public class DBUtility {
    // Static inner class dùng để tạo INSTANCE (Bill Pugh Singleton)
    // Chỉ được load khi gọi getInstance() → lazy loading + thread-safe
    private static class Helper {
        private static final DBUtility INSTANCE = new DBUtility();
    }

    // Constructor private
    // Không cho phép tạo object từ bên ngoài (new DBUtility())
    private DBUtility() {
    }

    // Method trả về instance duy nhất
    public static DBUtility getInstance() {
        return Helper.INSTANCE;
    }

    // Nên để private final (tránh bị sửa ngoài ý muốn)
    private static final String url = "jdbc:mysql://localhost:3306/";
    private static final String user = "root";
    private static final String password = "Duong170226@";

    //Method KHÔNG static → đúng chuẩn Singleton
    //Phải gọi qua instance: getInstance().getConnection()
    public Connection getConnection(String nameData) throws SQLException {
        try {
            //Tạo connection mới mỗi lần gọi
            return DriverManager.getConnection(url + nameData, user, password);
        } catch (Exception e) {
            // Log gọn, không lộ password
            System.err.println("Cannot connect to database: " + url + nameData);

            // Ném exception lên trên để xử lý đúng cách
            throw e;
        }
    }
}