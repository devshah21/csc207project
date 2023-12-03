package signup_logIn_test.signUp;

import entity.CommonUserFactory;
import entity.UserFactory;
import interface_adapter.Collect_Questions.CollectQuestionsViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupViewModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import data_access.InMemoryUserDataAccessObject;
import use_case.login.LoginInputData;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginUserDataAccessInterface;

public class LoginInteractorTest {
    private LoginUserDataAccessInterface userDataAccessObject;
    private LoginOutputBoundary loginPresenter;
    private LoginInteractor loginInteractor;
    private LoginOutputBoundary userPresenter;
    private CommonUserFactory userFactory;
    private LoginViewModel loginViewModel;
    private SignupViewModel signupViewModel;
    private ViewManagerModel viewManagerModel;
    private LoginInputData loginInputData;
    private CollectQuestionsViewModel collectQuestionsViewModel;

    @BeforeEach
    void setUp() {
        userDataAccessObject = new InMemoryUserDataAccessObject();
        loginViewModel = new LoginViewModel();
        signupViewModel = new SignupViewModel();
        viewManagerModel = new ViewManagerModel();
        collectQuestionsViewModel = new CollectQuestionsViewModel();
        userPresenter = new LoginPresenter(viewManagerModel, collectQuestionsViewModel, loginViewModel);
        userFactory = new CommonUserFactory();

        loginInteractor = new LoginInteractor(userDataAccessObject, userPresenter);
    }

    @Test
    public void testSuccessfulLogin() {
        // Arrange
        String username = "existingUser";
        String password = "password";
        userDataAccessObject.save(userFactory.create(username, password, 0));

        LoginInputData input = new LoginInputData(username, password);

        // Act
        loginInteractor.execute(input);

        // Assert
        // Implement your assertions based on the actual behavior of your in-memory implementations
        Assertions.assertNull(loginViewModel.getState().getUsernameError());
        Assertions.assertNull(loginViewModel.getState().getPasswordError());
        // Add more assertions as needed
    }

    @Test
    void testNonExistingUser() {
        // Arrange
        String username = "nonExistingUser";
        String password = "password";
        LoginInputData input = new LoginInputData(username, password);

        // Act
        loginInteractor.execute(input);

        // Assert
        // Implement your assertions based on the actual behavior of your in-memory implementations
        Assertions.assertNotNull(loginViewModel.getState().getUsernameError());
        Assertions.assertEquals(username + ": Account does not exist.", loginViewModel.getState().getUsernameError());
        // Add more assertions as needed
    }

    @Test
    void testIncorrectPassword() {
        // Arrange
        String username = "existingUser";
        String correctPassword = "password";
        String incorrectPassword = "wrongPassword";
        userDataAccessObject.save(userFactory.create(username, correctPassword, 0));

        LoginInputData input = new LoginInputData(username, incorrectPassword);

        // Act
        loginInteractor.execute(input);

        // Assert
        Assertions.assertNotNull(loginViewModel.getState().getPasswordError());
        Assertions.assertEquals("Incorrect password for " + username + ".", loginViewModel.getState().getPasswordError());
        // Implement your assertions based on the actual behavior of your in-memory implementations
    }
}
