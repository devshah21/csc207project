package interface_adapters.signup;

import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.signup.SignupOutputData;

import static org.junit.jupiter.api.Assertions.*;

class SignUpPresenterTest {

    private SignupPresenter signupPresenter;
    private ViewManagerModel viewManagerModel;
    private SignupViewModel signupViewModel;
    private LoginViewModel loginViewModel;

    @BeforeEach
    void setUp() {
        // Initialize your real instances here
        viewManagerModel = new ViewManagerModel();
        signupViewModel = new SignupViewModel();
        loginViewModel = new LoginViewModel();

        signupPresenter = new SignupPresenter(viewManagerModel, signupViewModel, loginViewModel);
    }

    @Test
    void successView() {
        boolean x = true;
        SignupOutputData response = new SignupOutputData("testUser", 9, x);

        assertDoesNotThrow(() -> signupPresenter.successView(response));
        assertEquals("testUser", loginViewModel.getState().getUsername());
        assertEquals(loginViewModel.getViewName(), viewManagerModel.getActiveView());
    }

    @Test
    void failView() {
        String error = "Username already taken";

        assertDoesNotThrow(() -> signupPresenter.failView(error));
        assertEquals(error, signupViewModel.getState().getUsernameError());
    }
}

