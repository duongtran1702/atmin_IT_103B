package atmin.b3;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepo = new UserRepository();

        userRepo.findUserByUsername("alice")
                .ifPresentOrElse(user -> System.out.println("Welcome " + user.username()),
                        () -> System.out.println("Guest login"));
    }
}
