package atmin_v4;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PatientRepository repo = new PatientRepository();
        List<PatientDTO> patients = repo.getAllPatientsWithServices();

        for (PatientDTO p : patients) {
            System.out.println(p.name + " - services: " + p.services.size());
        }
    }
}