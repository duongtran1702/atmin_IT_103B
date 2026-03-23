package atmin_b5.model;

public class Patient {
    private int id;
    private String name;
    private int  age;
    private String department;
    private String disease;

    public Patient(int id, String name, int age, String department,String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.disease = disease;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getDisease() {
        return disease;
    }
}

