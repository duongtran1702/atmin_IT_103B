package atmin;

import atmin.b2.UserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    UserService userService = new UserService();

    @Test
    void checkRegistrationAge() {
        assertEquals(true, userService.checkRegistrationAge(18));
        assertEquals(false, userService.checkRegistrationAge(8));
        assertThrows(IllegalArgumentException.class, () -> userService.checkRegistrationAge(-1));
    }
}