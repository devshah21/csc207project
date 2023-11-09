package interface_adapter.clear_users;

import interface_adapter.ViewManagerModel;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
import use_case.clear_users.ClearOutputBoundary;
import use_case.clear_users.ClearOutputData;

import java.util.Arrays;

public class ClearPresenter implements ClearOutputBoundary {

    private final SignupViewModel signupVM;
    private ViewManagerModel viewMM;

    public ClearPresenter(SignupViewModel signupViewModel, ViewManagerModel viewManagerModel) {
        this.signupVM = signupViewModel;
        this.viewMM = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(ClearOutputData usersDeleted) {

        SignupState signupState = signupVM.getState();
        signupState.userSet(usersDeleted.fatchAllUsers());
        signupVM.setState(signupState);
        signupVM.firePropertyChanged();

        viewMM.setActiveView(signupVM.getViewName());
        viewMM.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errormessage) {
    }
}
