package atmin.b6;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProfileServiceTest {

    ProfileService service = new ProfileService();

    @Test
    void shouldUpdateProfileSuccessfully() {

        // User hiện tại
        User user = new User("old@gmail.com", LocalDate.of(2000,1,1));

        // Danh sách user hiện có (không có email trùng)
        List<User> users = List.of(user);

        // Thông tin profile mới hợp lệ
        UserProfile profile =
                new UserProfile("new@gmail.com", LocalDate.of(1999,5,5));

        // Mong đợi: cập nhật thành công
        assertNotNull(service.updateProfile(user, profile, users));
    }

    @Test
    void shouldRejectFutureBirthDate() {

        // User hiện tại
        User user = new User("user@gmail.com", LocalDate.of(2000,1,1));
        List<User> users = List.of(user);

        // Ngày sinh nằm trong tương lai -> vi phạm rule
        UserProfile profile =
                new UserProfile("new@gmail.com", LocalDate.now().plusDays(1));

        // Mong đợi: hệ thống từ chối cập nhật
        assertNull(service.updateProfile(user, profile, users));
    }

    @Test
    void shouldRejectDuplicateEmail() {

        // 2 user đã tồn tại
        User user1 = new User("user1@gmail.com", LocalDate.of(2000,1,1));
        User user2 = new User("user2@gmail.com", LocalDate.of(2000,1,1));

        List<User> users = List.of(user1, user2);

        // user1 cố update email trùng với user2
        UserProfile profile =
                new UserProfile("user2@gmail.com", LocalDate.of(1999,5,5));

        // Mong đợi: hệ thống từ chối
        assertNull(service.updateProfile(user1, profile, users));
    }

    @Test
    void shouldAllowSameEmailAsExisting() {

        // Email mới giống email cũ của user
        User user = new User("user@gmail.com", LocalDate.of(2000,1,1));
        List<User> users = List.of(user);

        UserProfile profile =
                new UserProfile("user@gmail.com", LocalDate.of(1999,5,5));

        // Mong đợi: vẫn cho update (chỉ thay đổi thông tin khác)
        assertNotNull(service.updateProfile(user, profile, users));
    }

    @Test
    void shouldUpdateWhenUserListEmpty() {

        // Không có user nào khác trong hệ thống
        User user = new User("user@gmail.com", LocalDate.of(2000,1,1));
        List<User> users = new ArrayList<>();

        UserProfile profile =
                new UserProfile("new@gmail.com", LocalDate.of(1999,5,5));

        // Mong đợi: update thành công
        assertNotNull(service.updateProfile(user, profile, users));
    }

    @Test
    void shouldRejectWhenMultipleViolations() {

        // 2 user tồn tại
        User user1 = new User("user1@gmail.com", LocalDate.of(2000,1,1));
        User user2 = new User("user2@gmail.com", LocalDate.of(2000,1,1));

        List<User> users = List.of(user1, user2);

        // Email trùng + ngày sinh trong tương lai
        UserProfile profile =
                new UserProfile("user2@gmail.com", LocalDate.now().plusDays(1));

        // Mong đợi: hệ thống từ chối cập nhật
        assertNull(service.updateProfile(user1, profile, users));
    }
}