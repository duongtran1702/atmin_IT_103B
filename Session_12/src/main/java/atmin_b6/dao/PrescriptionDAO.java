package atmin_b6.dao;

import java.sql.*;

public class PrescriptionDAO {
    private final Connection conn;

    public PrescriptionDAO(Connection conn) {
        this.conn = conn;
    }

    // Bước 3: Tính tổng tiền đơn thuốc
    public void calculatePrescriptionTotal(int prescriptionId) throws SQLException {
        String sql = "{CALL CalculatePrescriptionTotal(?, ?)}";
        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, prescriptionId);
            cs.registerOutParameter(2, Types.DECIMAL);
            cs.execute();
            double total = cs.getDouble(2);
            System.out.println("Total for prescription " + prescriptionId + " = " + total);
        }
    }

    // Bước 4: Thống kê doanh thu theo ngày
    public void getDailyRevenue(Date date) throws SQLException {
        String sql = "{CALL GetDailyRevenue(?, ?)}";
        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setDate(1, date);
            cs.registerOutParameter(2, Types.DECIMAL);
            cs.execute();
            double revenue = cs.getDouble(2);
            System.out.println("Revenue on " + date + " = " + revenue);
        }
    }
}