package atmin.b3;

import atmin.b1.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    List<User> users = List.of(
            new User("alice", "alice@gmail.com", "ACTIVE"),
            new User("bob", "bob@yahoo.com", "INACTIVE"),
            new User("charlie", "charlie@gmail.com", "ACTIVE")
    );

    Optional<User> findUserByUsername(String username) {
        return users.stream().filter(u -> u.username().equals(username)).findFirst();
    }
}
