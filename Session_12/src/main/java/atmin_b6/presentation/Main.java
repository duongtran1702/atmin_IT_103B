package atmin_b6.presentation;


import atmin_b6.dao.MedicineDAO;
import atmin_b6.dao.PrescriptionDAO;
import atmin_b6.model.Medicine;
import db.DB;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        try (Connection conn = DB.getInstance().getConnection("atmin_db_hospital")) {
            MedicineDAO medicineDAO = new MedicineDAO(conn);
            PrescriptionDAO prescriptionDAO = new PrescriptionDAO(conn);
            Scanner sc = new Scanner(System.in);

            // Demo update stock
            System.out.print("Medicine ID to update: ");
            int id = sc.nextInt();
            System.out.print("Added quantity: ");
            int qty = sc.nextInt();
            medicineDAO.updateMedicineStock(id, qty);

            // Demo tìm kiếm thuốc
            System.out.print("Min price: ");
            double min = sc.nextDouble();
            System.out.print("Max price: ");
            double max = sc.nextDouble();
            List<Medicine> meds = medicineDAO.findMedicinesByPriceRange(min, max);
            meds.forEach(System.out::println);

            // Demo tính tổng tiền đơn thuốc
            System.out.print("Prescription ID to calculate total: ");
            int pid = sc.nextInt();
            prescriptionDAO.calculatePrescriptionTotal(pid);

            // Demo doanh thu theo ngày
            System.out.print("Date (yyyy-MM-dd) to get revenue: ");
            String dateStr = sc.next();
            Date date = Date.valueOf(dateStr);
            prescriptionDAO.getDailyRevenue(date);
        }
    }
}