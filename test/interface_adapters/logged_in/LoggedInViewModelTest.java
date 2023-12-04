package interface_adapters.logged_in;


import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggedInViewModelTest {

    private LoggedInViewModel loggedInViewModel;
    private LoggedInState loggedInState;

    @BeforeEach
    public void setUp() {
        loggedInViewModel = new LoggedInViewModel();
        loggedInState = new LoggedInState();
    }

    @Test
    public void testState() {
        loggedInViewModel.setState(loggedInState);
        assertEquals(loggedInState, loggedInViewModel.getState());
    }

    @Test
    public void testLoggedInUser() {
        String loggedInUser = "Test User";
        loggedInViewModel.setLoggedInUser(loggedInUser);
        assertEquals(loggedInUser, loggedInViewModel.getLoggedInUser());
    }

    @Test
    public void testPropertyChange() {
        PropertyChangeListener listener = new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                assertEquals("state", evt.getPropertyName());
                assertEquals(loggedInState, evt.getNewValue());
            }
        };
        loggedInViewModel.addPropertyChangeListener(listener);
        loggedInViewModel.setState(loggedInState);
        loggedInViewModel.firePropertyChanged();
    }
}
