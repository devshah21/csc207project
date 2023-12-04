package interface_adapters.signup;

import interface_adapter.signup.SignupController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInputData;

import static org.junit.jupiter.api.Assertions.*;

class SignUpControllerTest {

    private SignupController signupController;
    private SignupInputBoundary userSignupUseCaseInteractor;

    @BeforeEach
    void setUp() {
        userSignupUseCaseInteractor = new SignupInputBoundary() {
            @Override
            public void execute(SignupInputData inputData) {
                // Implement your use case interactor here
            }
        };
        signupController = new SignupController(userSignupUseCaseInteractor);
    }

    @Test
    void execute() {
        String username = "testUser";
        String password1 = "testPassword1";
        String password2 = "testPassword2";

        assertDoesNotThrow(() -> signupController.execute(username, password1, password2));
    }
}
