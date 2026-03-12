package atmin.b2;

public class UserService {
    public boolean checkRegistrationAge(int age){
        if(age<=0 ) throw new IllegalArgumentException("Age not valid");
        return age >= 18;
    }
}
