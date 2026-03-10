package atmin.b4;

import atmin.b1.User;

import java.util.Collection;

import java.util.List;

import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("alice", "alice@gmail.com", "ACTIVE"),
                new User("alice", "alice1@gmail.com", "ACTIVE"),
                new User("bob", "bob@yahoo.com", "INACTIVE"),
                new User("bob", "bob1@yahoo.com", "INACTIVE"),
                new User("charlie", "charlie@gmail.com", "ACTIVE"),
                new User("charlie", "charlie1@gmail.com", "ACTIVE")
        );

        Collection<User> uniqueUsers = users.stream()
                .collect(Collectors
                        .toMap(User::username, u -> u, (u1, u2) -> u1))
                .values();

        uniqueUsers.forEach(System.out::println);
    }


}
