package interface_adapters.login;

import interface_adapter.login.LoginState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LoginStateTest {

    private LoginState loginState;

    @BeforeEach
    public void setUp() {
        loginState = new LoginState();
    }

    @Test
    public void testUsername() {
        String username = "testUser";
        loginState.setUsername(username);
        assertEquals(username, loginState.getUsername());
    }

    @Test
    public void testUsernameError() {
        String usernameError = "Username error";
        loginState.setUsernameError(usernameError);
        assertEquals(usernameError, loginState.getUsernameError());

        loginState.resetUsernameError();
        assertNull(loginState.getUsernameError());
    }

    @Test
    public void testPassword() {
        String password = "testPassword";
        loginState.setPassword(password);
        assertEquals(password, loginState.getPassword());
    }

    @Test
    public void testPasswordError() {
        String passwordError = "Password error";
        loginState.setPasswordError(passwordError);
        assertEquals(passwordError, loginState.getPasswordError());

        loginState.resetPasswordError();
        assertNull(loginState.getPasswordError());
    }

    @Test
    public void testCopyConstructor() {
        String username = "testUser";
        String password = "testPassword";
        loginState.setUsername(username);
        loginState.setPassword(password);

        LoginState copy = new LoginState(loginState);
        assertEquals(username, copy.getUsername());
        assertEquals(password, copy.getPassword());
    }
}

