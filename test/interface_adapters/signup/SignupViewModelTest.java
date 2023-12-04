package interface_adapters.signup;

import interface_adapter.signup.SignupState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.*;

import interface_adapter.signup.SignupViewModel;

class SignupViewModelTest {

    private SignupViewModel signupViewModel;
    private SignupState signupState;

    @BeforeEach
    void setUp() {
        signupViewModel = new SignupViewModel();
        signupState = new SignupState();
    }

    @Test
    void testState() {
        signupViewModel.setState(signupState);
        assertEquals(signupState, signupViewModel.getState());
    }

    @Test
    void testFirePropertyChanged() {
        PropertyChangeListener listener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                assertEquals("state", evt.getPropertyName());
                assertEquals(signupState, evt.getNewValue());
            }
        };
        signupViewModel.addPropertyChangeListener(listener);
        signupViewModel.setState(signupState);
        signupViewModel.firePropertyChanged();
    }
}

