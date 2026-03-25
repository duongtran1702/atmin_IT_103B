package db;

import java.sql.*;

public class DB {
    private static class Helper {
        private static final DB INSTANCE = new DB();
    }

    private DB() {
    }

    public static DB getInstance() {
        return Helper.INSTANCE;
    }

    private static final String url = "jdbc:mysql://localhost:3306/";
    private static final String user = "root";
    private static final String password = "Duong170226@";

    public Connection getConnection(String nameData) throws SQLException {
        try {
            return DriverManager.getConnection(url + nameData, user, password);
        } catch (Exception e) {
            System.err.println("Cannot connect to database: " + url + nameData);
            throw e;
        }
    }
}