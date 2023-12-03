package interface_adapter.truefalse;

import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.ViewManagerModel;


import use_case.truefalse.TruefalseOutputBoundary;
import use_case.truefalse.TruefalseOutputData;

import interface_adapter.truefalse.TruefalseState;
import interface_adapter.truefalse.TruefalseViewModel;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TruefalsePresenter implements TruefalseOutputBoundary {

    private final TruefalseViewModel truefalseViewModel;

    private ViewManagerModel viewManagerModel;

    public TruefalsePresenter(ViewManagerModel viewManagerModel,
                           TruefalseViewModel truefalseViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.truefalseViewModel = truefalseViewModel;
    }
    @Override
    public void successView(TruefalseOutputData response) {

        TruefalseState truefalseState = truefalseViewModel.getState();
        this.truefalseViewModel.setState(truefalseState);
        truefalseViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(truefalseViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void failView(String error) {
        TruefalseState truefalseState = truefalseViewModel.getState();
    }
}
