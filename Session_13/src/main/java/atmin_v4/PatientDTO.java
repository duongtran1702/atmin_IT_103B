package atmin_v4;

import java.util.ArrayList;
import java.util.List;

public class PatientDTO {
    public int patientId;
    public String name;
    public List<Service> services = new ArrayList<>();
}
