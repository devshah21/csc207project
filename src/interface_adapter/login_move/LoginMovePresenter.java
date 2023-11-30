package interface_adapter.login_move;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import use_case.login_move.LoginMoveInteractor;
import use_case.login_move.LoginMoveOutputBoundary;

public class LoginMovePresenter implements LoginMoveOutputBoundary {


    private final LoginViewModel loginViewModel;

    private ViewManagerModel viewManagerModel; // This is used to change primary screens



    public LoginMovePresenter(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel){

        this.loginViewModel = loginViewModel;
        this.viewManagerModel = viewManagerModel;

    }

    @Override
    public void prepareSuccessView() {

        // Switch to login view
        viewManagerModel.setActiveView(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();



    }
}
