package atmin.b1;

public class UserValidator {
    public int isValidUsername(String username) {
        if (username.length() < 6) {
            return 1;
        } else if (username.length() > 20) {
            return 2;
        } else if (username.contains(" ")) {
            return 3;
        }
        return 0;
    }


}
