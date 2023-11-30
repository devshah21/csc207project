package use_case.login_move;

public class LoginMoveInteractor implements LoginMoveInputBoundary {


    final LoginMoveOutputBoundary loginMovePresenter;

    public LoginMoveInteractor(LoginMoveOutputBoundary loginMoveOutputBoundary){

        this.loginMovePresenter = loginMoveOutputBoundary;
    }

    @Override
    public void execute() {
        LoginMoveOutputData loginMoveOutputData = new LoginMoveOutputData();
        loginMovePresenter.prepareSuccessView();

    }
}
