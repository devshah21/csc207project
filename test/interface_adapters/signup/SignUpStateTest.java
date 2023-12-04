package interface_adapters.signup;

import interface_adapter.signup.SignupState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignUpStateTest {

    private SignupState signupState;

    @BeforeEach
    void setUp() {
        signupState = new SignupState();
    }

    @Test
    void testUsername() {
        String username = "testUser";
        signupState.setUsername(username);
        assertEquals(username, signupState.getUsername());
    }

    @Test
    void testPassword() {
        String password = "testPassword";
        signupState.setPassword(password);
        assertEquals(password, signupState.getPassword());
    }

    @Test
    void testRepeatPassword() {
        String repeatPassword = "testRepeatPassword";
        signupState.setRepeatPassword(repeatPassword);
        assertEquals(repeatPassword, signupState.getRepeatPassword());
    }

    @Test
    void testUsernameError() {
        String usernameError = "Username already taken";
        signupState.setUsernameError(usernameError);
        assertEquals(usernameError, signupState.getUsernameError());
    }

    @Test
    void testPasswordError() {
        String passwordError = "Password too weak";
        signupState.setPasswordError(passwordError);
        assertEquals(passwordError, signupState.getPasswordError());
    }

    @Test
    void testRepeatPasswordError() {
        String repeatPasswordError = "Passwords do not match";
        signupState.setRepeatPasswordError(repeatPasswordError);
        assertEquals(repeatPasswordError, signupState.getRepeatPasswordError());
    }

    @Test
    void testUsers() {
        String[] users = {"user1", "user2", "user3"};
        signupState.userSet(users);
        assertArrayEquals(users, signupState.fetchAllUsers());
    }
}

