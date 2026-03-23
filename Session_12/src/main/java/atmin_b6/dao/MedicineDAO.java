package atmin_b6.dao;
import atmin_b6.model.Medicine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicineDAO {
    private final Connection conn;

    public MedicineDAO(Connection conn) {
        this.conn = conn;
    }
    // Bước 1: Cập nhật kho thuốc
    public void updateMedicineStock(int id, int addedQuantity) throws SQLException {
        String sql = "UPDATE medicines SET stock = stock + ? WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, addedQuantity);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            System.out.println("Updated " + rows + " row(s).");
        }
    }

    // Bước 2: Tìm kiếm thuốc theo khoảng giá
    public List<Medicine> findMedicinesByPriceRange(double minPrice, double maxPrice) throws SQLException {
        String sql = "SELECT * FROM medicines WHERE price BETWEEN ? AND ?";
        List<Medicine> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, minPrice);
            ps.setDouble(2, maxPrice);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Medicine(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("stock")
                ));
            }
        }
        return list;
    }
}