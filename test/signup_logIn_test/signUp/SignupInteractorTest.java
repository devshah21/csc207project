package signup_logIn_test.signUp;


import entity.CommonUserFactory;
import interface_adapter.signup.SignupState;
import org.junit.jupiter.api.*;
import use_case.signup.SignupInputData;
import use_case.signup.SignupInteractor;
import use_case.signup.SignupOutputBoundary;
import use_case.signup.SignupUserDataAccessInterface;
import interface_adapter.signup.SignupPresenter;
import data_access.InMemoryUserDataAccessObject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import interface_adapter.signup.SignupViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.ViewManagerModel;


class SignupInteractorTest {
    private SignupUserDataAccessInterface userDataAccessObject;
    private SignupOutputBoundary userPresenter;
    private CommonUserFactory userFactory;
    private SignupInteractor signupInteractor;
    private LoginViewModel loginViewModel;
    private SignupViewModel signupViewModel;
    private ViewManagerModel viewManagerModel;
    private SignupInputData signupInputData;

    @BeforeEach
    void setUp() {
        userDataAccessObject = new InMemoryUserDataAccessObject();
        loginViewModel = new LoginViewModel();  // Initialize loginViewModel before creating SignupPresenter
        signupViewModel = new SignupViewModel();
        viewManagerModel = new ViewManagerModel();
        userPresenter = new SignupPresenter(viewManagerModel, signupViewModel, loginViewModel);
        userFactory = new CommonUserFactory();

        signupInteractor = new SignupInteractor(userDataAccessObject, userPresenter, userFactory);
    }


    @Test
    void testSuccessfulSignup() {
        // Arrange
        SignupInputData input = new SignupInputData("newUser", "password", "password");

        // Act
        signupInteractor.execute(input);

        // Assert
        // Implement your assertions based on the actual behavior of your in-memory implementations
    }

    @Test
    void testUserAlreadyExists() {
        // Arrange
        SignupInputData input = new SignupInputData("existingUser", "password", "password");
        userDataAccessObject.save(userFactory.create("existingUser", "password", 0));

        // Act
        signupInteractor.execute(input);

        // Assert
        // Implement your assertions based on the actual behavior of your in-memory implementations
        SignupState signupState = signupViewModel.getState();
        Assertions.assertEquals("User already exists.", signupState.getUsernameError());
    }

    @Test
    void testPasswordsDoNotMatch() {
        // Arrange
        SignupInputData input = new SignupInputData("newUser", "password1", "password2");

        // Act
        signupInteractor.execute(input);

        // Assert
        // Implement your assertions based on the actual behavior of your in-memory implementations
        SignupState signupState = signupViewModel.getState();
        Assertions.assertEquals("Passwords don't match.", signupState.getUsernameError());


    }
}
