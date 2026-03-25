package atmin_v4;

import db.DB;
import java.sql.*;
import java.util.*;

public class PatientRepository {
    @SuppressWarnings("CallToPrintStackTrace")
    public List<PatientDTO> getAllPatientsWithServices() {
        List<PatientDTO> result = new ArrayList<>();
        Map<Integer, PatientDTO> map = new HashMap<>();

        String sql = "SELECT p.patient_id, p.name, s.service_id, s.service_name " +
                "FROM Patient p LEFT JOIN Service_Usage s " +
                "ON p.patient_id = s.patient_id";

        try (Connection conn = DB.getInstance().getConnection("db_hospital_ss13");
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("patient_id");

                PatientDTO patient = map.get(id);
                if (patient == null) {
                    patient = new PatientDTO();
                    patient.patientId = id;
                    patient.name = rs.getString("name");
                    map.put(id, patient);
                }

                int serviceId = rs.getInt("service_id");

                if (!rs.wasNull()) { // handle missing services
                    Service s = new Service();
                    s.serviceId = serviceId;
                    s.serviceName = rs.getString("service_name");
                    patient.services.add(s);
                }
            }

            result.addAll(map.values());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
