package app;

import interface_adapter.clear_users.ClearController;
import interface_adapter.clear_users.ClearPresenter;
import interface_adapter.login.LoginViewModel;
import interface_adapter.login_move.LoginMoveController;
import interface_adapter.login_move.LoginMovePresenter;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupViewModel;
import use_case.clear_users.*;
import use_case.login_move.LoginMoveInputBoundary;
import use_case.login_move.LoginMoveInteractor;
import use_case.login_move.LoginMoveOutputBoundary;
import use_case.signup.SignupUserDataAccessInterface;
import entity.CommonUserFactory;
import entity.UserFactory;
import interface_adapter.*;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInteractor;
import use_case.signup.SignupOutputBoundary;
import view.SignupView;

import javax.swing.*;
import java.io.IOException;

public class SignupUseCaseFactory {

    /** Prevent instantiation. */
    private SignupUseCaseFactory() {}

    public static SignupView create(
            ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, SignupViewModel signupViewModel, SignupUserDataAccessInterface userDataAccessObject,
            ClearUserDataAccessInterface clearDataAccessObject) {

        try {
            SignupController signupController = createUserSignupUseCase(viewManagerModel, signupViewModel, loginViewModel, userDataAccessObject);
            ClearController clearController = clearUsersUseCase(viewManagerModel, signupViewModel, clearDataAccessObject);

            // This is just to move with button to login GUI
            LoginMoveController loginMoveController = createloginMoveUseCase(viewManagerModel, loginViewModel);

            return new SignupView(signupController, signupViewModel, clearController, loginMoveController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static LoginMoveController createloginMoveUseCase(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel) {

        LoginMoveOutputBoundary loginMoveOutputBoundary = new LoginMovePresenter(viewManagerModel, loginViewModel);

        LoginMoveInputBoundary loginMoveInteractor = new LoginMoveInteractor(loginMoveOutputBoundary);

        return new LoginMoveController(loginMoveInteractor);

    }

    private static SignupController createUserSignupUseCase(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel, LoginViewModel loginViewModel, SignupUserDataAccessInterface userDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        SignupOutputBoundary signupOutputBoundary = new SignupPresenter(viewManagerModel, signupViewModel, loginViewModel);

        UserFactory userFactory = new CommonUserFactory();

        SignupInputBoundary userSignupInteractor = new SignupInteractor(
                userDataAccessObject, signupOutputBoundary, userFactory);

        return new SignupController(userSignupInteractor);
    }

    private static ClearController clearUsersUseCase(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel, ClearUserDataAccessInterface dataAccessObject) throws IOException {

        ClearOutputBoundary clearOutputBoundary = new ClearPresenter(signupViewModel, viewManagerModel);
        ClearInputBoundary clearUsersInteractor = new ClearInteractor(dataAccessObject, clearOutputBoundary);

        return new ClearController(clearUsersInteractor);

    }
}
