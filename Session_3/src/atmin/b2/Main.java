package atmin.b2;

import atmin.b1.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("alice", "alice@gmail.com", "ACTIVE"),
                new User("bob", "bob@yahoo.com", "INACTIVE"),
                new User("charlie", "charlie@gmail.com", "ACTIVE")
        );

        users.stream().filter(t -> t.email().endsWith("@gmail.com")).forEach(t -> System.out.println(t.username()));
    }
}
