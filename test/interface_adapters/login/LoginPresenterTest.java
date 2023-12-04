package interface_adapters.login;

import interface_adapter.Collect_Questions.CollectQuestionsViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.login.LoginOutputData;

public class LoginPresenterTest {

    private LoginPresenter loginPresenter;
    private ViewManagerModel viewManagerModel;
    private CollectQuestionsViewModel collectQuestionsViewModel;
    private LoginViewModel loginViewModel;

    @BeforeEach
    public void setUp() {
        viewManagerModel = new ViewManagerModel();
        collectQuestionsViewModel = new CollectQuestionsViewModel();
        loginViewModel = new LoginViewModel();
        loginPresenter = new LoginPresenter(viewManagerModel, collectQuestionsViewModel, loginViewModel);
    }

    @Test
    public void testPrepareSuccessView() {
        String username = "testUser";

        boolean True = false;
        LoginOutputData response = new LoginOutputData(username, True);
        loginPresenter.prepareSuccessView(response);

        assert(collectQuestionsViewModel.getState().getUsername().equals(username));
        assert(viewManagerModel.getActiveView().equals(collectQuestionsViewModel.getViewName()));
    }

    @Test
    public void testPrepareFailViewUsername() {
        String error = "Username error";

        loginPresenter.prepareFailViewUsername(error);

        assert(loginViewModel.getState().getUsernameError().equals(error));
    }

    @Test
    public void testPrepareFailViewPassword() {
        String error = "Password error";

        loginPresenter.prepareFailViewPassword(error);

        assert(loginViewModel.getState().getPasswordError().equals(error));
    }
}
