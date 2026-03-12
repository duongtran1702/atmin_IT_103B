package atmin.b6;

import java.time.LocalDate;
import java.util.List;

public class ProfileService {

    public User updateProfile(User existingUser,
                              UserProfile newProfile,
                              List<User> allUsers) {

        // check ngày sinh tương lai
        if (newProfile.getBirthDate().isAfter(LocalDate.now())) {
            return null;
        }

        String newEmail = newProfile.getEmail();

        // check email trùng user khác
        for (User u : allUsers) {
            if (u != existingUser && u.getEmail().equalsIgnoreCase(newEmail)) {
                return null;
            }
        }

        // cập nhật
        existingUser.setEmail(newEmail);
        existingUser.setBirthDate(newProfile.getBirthDate());

        return existingUser;
    }
}