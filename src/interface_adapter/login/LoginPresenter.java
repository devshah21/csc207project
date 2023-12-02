package interface_adapter.login;

import interface_adapter.Collect_Questions.CollectQuestionsState;
import interface_adapter.Collect_Questions.CollectQuestionsViewModel;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.signup.SignupState;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;
import use_case.signup.SignupOutputBoundary;
import use_case.signup.SignupOutputData;

public class LoginPresenter implements LoginOutputBoundary {

    private final LoginViewModel loginViewModel;
    private final CollectQuestionsViewModel collectQuestionsViewModel;
    private ViewManagerModel viewManagerModel;

    public LoginPresenter(ViewManagerModel viewManagerModel,
                          CollectQuestionsViewModel collectQuestionsViewModel,
                          LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.collectQuestionsViewModel = collectQuestionsViewModel;
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData response) {
        // On success, switch to the logged in view.

        // Move username to collectQuestion
        CollectQuestionsState collectQuestionsState = collectQuestionsViewModel.getState();
        collectQuestionsState.setUsername(response.getUsername());
        this.collectQuestionsViewModel.setState(collectQuestionsState);
        this.collectQuestionsViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(collectQuestionsViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailViewUsername(String error) {
        LoginState loginState = loginViewModel.getState();
        loginState.setUsernameError(error);
        loginViewModel.firePropertyChanged();
    }
    public void prepareFailViewPassword(String error) {
        LoginState loginState = loginViewModel.getState();
        loginState.setPasswordError(error);
        loginViewModel.firePropertyChanged();
    }
}
