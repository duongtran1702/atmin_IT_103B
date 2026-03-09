package atmin;

import java.util.*;
import java.util.function.Function;

public class User {
    String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public static void main(String[] args) {

        List<User> users = new ArrayList<>();

        // Constructor reference
        Function<String, User> createUser = User::new;

        users.add(createUser.apply("duong"));
        users.add(createUser.apply("admin"));
        users.add(createUser.apply("guest"));

        users.stream()
                .map(User::getUsername)
                .forEach(System.out::println);
    }
}




