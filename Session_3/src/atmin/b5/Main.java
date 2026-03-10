package atmin.b5;

import atmin.b1.User;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("alexander", "a@gmail.com", "ACTIVE"),
                new User("bob", "b@gmail.com", "ACTIVE"),
                new User("charlotte", "c@gmail.com", "ACTIVE"),
                new User("Benjamin", "d@gmail.com", "ACTIVE"),
                new User("tom", "t@gmail.com", "ACTIVE")
        );

        users.stream().sorted(Comparator
                        .comparingInt((User u) -> u.username()
                                .length()).reversed()).limit(3)
                .map(User::username)
                .forEach(System.out::println);
    }


}
