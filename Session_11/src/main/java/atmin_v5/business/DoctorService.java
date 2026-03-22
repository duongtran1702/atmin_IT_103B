package atmin_v5.business;



import atmin_v5.dao.DoctorDAO;
import atmin_v5.model.Doctor;

import java.util.List;

public class DoctorService {

    private final DoctorDAO dao = new DoctorDAO();

    public void showAll() {
        List<Doctor> list = dao.findAll();

        if (list.isEmpty()) {
            System.out.println("Không có bác sĩ");
            return;
        }

        for (Doctor d : list) {
            System.out.println(
                    d.getId() + " | " +
                            d.getFullname() + " | " +
                            d.getSpecialty()
            );
        }
    }

    public void addDoctor(Doctor doctor) {
        dao.insert(doctor);
    }

    public void statistic() {
        dao.statisticBySpecialty();
    }
}