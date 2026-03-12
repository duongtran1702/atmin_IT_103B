package atmin;

import atmin.b1.UserValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {
    UserValidator userValidator = new UserValidator();

    @Test
    void isValidUsername() {
        assertTrue(userValidator.isValidUsername("user123") == 0, () -> "Hop le");
        assertFalse(userValidator.isValidUsername("abc") !=1, () -> "Qua ngan");
        assertFalse(userValidator.isValidUsername("user 123") !=3, () -> "Chua khoang trang");
    }
}