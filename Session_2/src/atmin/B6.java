package atmin;

public class B6 {
    public static void main(String[] args) {
        UserProcessor up = UserUtils::convertToUpperCase;
        System.out.println(up.process(new User("admin")));
    }
}
