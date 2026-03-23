package atmin_b5.business;

import atmin_b5.dao.PatientDAO;
import atmin_b5.model.Patient;
import db.DB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class PatientService {
    private final PatientDAO dao = new PatientDAO();

    public void dischargePatient(int patientId) throws SQLException {
        try (Connection conn = DB.getInstance().getConnection("atmin_db_hospital")) {
            CallableStatement cs = conn.prepareCall("{CALL CALCULATE_DISCHARGE_FEE(?, ?)}");
            cs.setInt(1, patientId);
            cs.registerOutParameter(2, java.sql.Types.DECIMAL);
            cs.execute();
            double fee = cs.getDouble(2);
            System.out.println("Patient " + patientId + " total fee: " + fee);
        }

    }

    public void admitPatient(Patient p) throws SQLException {
        if (p.getAge() < 0) throw new IllegalArgumentException("Age cannot be negative");
        dao.addPatient(p.getName(), p.getAge(), p.getDepartment(), p.getDisease());
    }
}
