package atmin_b3;

import db.DB;

import java.sql.*;

public class Main {
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        int id = 2;

        try (Connection conn = DB.getInstance().getConnection("hospital_db");
             CallableStatement cs = conn.prepareCall("{CALL GET_SURGERY_FEE(?,?)}")) {
            cs.setInt(1, id);
            cs.registerOutParameter(2, Types.DECIMAL);

            cs.execute();
            double temp = cs.getDouble(2);
            System.out.println(temp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
