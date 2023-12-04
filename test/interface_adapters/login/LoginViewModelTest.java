package interface_adapters.login;

import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginViewModelTest {

    private LoginViewModel loginViewModel;
    private LoginState testState;

    @BeforeEach
    public void setUp() {
        loginViewModel = new LoginViewModel();
        testState = new LoginState();
    }

    @Test
    public void testSetState() {
        loginViewModel.setState(testState);
        assertEquals(testState, loginViewModel.getState());
    }

    @Test
    public void testFirePropertyChanged() {
        PropertyChangeListener listener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                assertEquals("state", evt.getPropertyName());
                assertEquals(testState, evt.getNewValue());
            }
        };
        loginViewModel.addPropertyChangeListener(listener);
        loginViewModel.setState(testState);
        loginViewModel.firePropertyChanged();
    }
}
