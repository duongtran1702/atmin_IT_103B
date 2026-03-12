package atmin;

import atmin.b5.Action;
import atmin.b5.PermissionService;
import atmin.b5.Role;
import atmin.b5.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermissionServiceTest {

    PermissionService ps = new PermissionService();
    User admin;
    User moderator;
    User user;

    @Test
    void canPerformAction() {
        admin = new User(Role.ADMIN);

        assertAll(
                () -> assertTrue(ps.canPerformAction(admin, Action.DELETE_USER)),
                () -> assertTrue(ps.canPerformAction(admin, Action.LOCK_USER)),
                () -> assertTrue(ps.canPerformAction(admin, Action.VIEW_PROFILE))
        );
    }

    @Test
    void testModeratorPermissions() {

        moderator = new User(Role.MODERATOR);

        assertAll(
                () -> assertFalse(ps.canPerformAction(moderator, Action.DELETE_USER)),
                () -> assertTrue(ps.canPerformAction(moderator, Action.LOCK_USER)),
                () -> assertTrue(ps.canPerformAction(moderator, Action.VIEW_PROFILE))
        );
    }

    @Test
    void testUserPermissions() {

        user = new User(Role.USER);

        assertAll(
                () -> assertFalse(ps.canPerformAction(user, Action.DELETE_USER)),
                () -> assertFalse(ps.canPerformAction(user, Action.LOCK_USER)),
                () -> assertTrue(ps.canPerformAction(user, Action.VIEW_PROFILE))
        );
    }

    @AfterEach
    void cleanup() {
        admin = null;
        moderator = null;
        user = null;
    }
}