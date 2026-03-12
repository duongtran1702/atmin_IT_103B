package atmin;

import atmin.b4.PasswordService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordServiceTest {

    PasswordService ps = new PasswordService();

    @Test
    void evaluatePasswordStrength() {
        assertAll(

                () -> assertEquals("Mạnh",
                        ps.evaluatePasswordStrength("Abc123!@")),

                () -> assertEquals("Trung bình",
                        ps.evaluatePasswordStrength("abc123!@")),

                () -> assertEquals("Trung bình",
                        ps.evaluatePasswordStrength("ABC123!@")),

                () -> assertEquals("Trung bình",
                        ps.evaluatePasswordStrength("Abcdef!@")),

                () -> assertEquals("Trung bình",
                        ps.evaluatePasswordStrength("Abc12345")),

                () -> assertEquals("Yếu",
                        ps.evaluatePasswordStrength("Ab1!")),

                () -> assertEquals("Yếu",
                        ps.evaluatePasswordStrength("password")),

                () -> assertEquals("Yếu",
                        ps.evaluatePasswordStrength("ABC12345"))
        );
    }
}