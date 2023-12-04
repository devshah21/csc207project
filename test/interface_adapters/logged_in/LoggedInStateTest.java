package interface_adapters.logged_in;


import interface_adapter.logged_in.LoggedInState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggedInStateTest {

    private LoggedInState loggedInState;

    @BeforeEach
    public void setUp() {
        loggedInState = new LoggedInState();
    }

    @Test
    public void testUsername() {
        String username = "Test Username";
        loggedInState.setUsername(username);
        assertEquals(username, loggedInState.getUsername());
    }
}
