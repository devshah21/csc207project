package interface_adapter.login_move;


import use_case.login_move.LoginMoveInputBoundary;
import use_case.login_move.LoginMoveInputData;

public class LoginMoveController {

    final LoginMoveInputBoundary loginMoveUseCaseInteractor;

    public LoginMoveController(LoginMoveInputBoundary loginMoveUseCaseInteractor) {
        this.loginMoveUseCaseInteractor = loginMoveUseCaseInteractor;
    }

    // Dont need anything should just auto run
    public void execute() {
        LoginMoveInputData loginMoveInputData = new LoginMoveInputData();
        // Convert to integer in interactor
        // This will call the interactor
        // Dont need any input data but leave it there just in case

        loginMoveUseCaseInteractor.execute();
    }

}
