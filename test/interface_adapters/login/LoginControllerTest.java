package interface_adapters.login;

import interface_adapter.login.LoginController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInputData;

public class LoginControllerTest {

    private LoginController loginController;
    private TestLoginInputBoundary loginUseCaseInteractor;

    @BeforeEach
    public void setUp() {
        loginUseCaseInteractor = new TestLoginInputBoundary();
        loginController = new LoginController(loginUseCaseInteractor);
    }

    @Test
    public void testExecute() {
        String username = "testUser";
        String password = "testPassword";

        loginController.execute(username, password);

        assert(loginUseCaseInteractor.isExecuted());
        assert(username.equals(loginUseCaseInteractor.getLoginInputData().getUsername()));
        assert(password.equals(loginUseCaseInteractor.getLoginInputData().getPassword()));
    }

    private class TestLoginInputBoundary implements LoginInputBoundary {

        private boolean executed = false;
        private LoginInputData loginInputData;

        @Override
        public void execute(LoginInputData loginInputData) {
            this.executed = true;
            this.loginInputData = loginInputData;
        }

        public boolean isExecuted() {
            return executed;
        }

        public LoginInputData getLoginInputData() {
            return loginInputData;
        }
    }
}
