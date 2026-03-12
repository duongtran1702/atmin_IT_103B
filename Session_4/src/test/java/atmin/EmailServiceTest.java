package atmin;

import atmin.b3.EmailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmailServiceTest {
    EmailService es;

    @BeforeEach
    void setUp() {
        es = new EmailService();
    }

    @Test
    void normalizeEmail() {
        assertEquals("user@gmail.com", es.normalizeEmail("user@gmail.com"));
    }

    @Test
    void normalizeEmail1() {
        assertThrows(IllegalArgumentException.class, () -> es.normalizeEmail("usergmail.com"));
    }

    @Test
    void normalizeEmail2() {
        assertThrows(IllegalArgumentException.class, () -> es.normalizeEmail("user@"));
    }

    @Test
    void normalizeEmail3() {
        assertEquals("example@gmail.com", es.normalizeEmail("Example@Gmail.com"));
    }
}