package app;

import data_access.FileUserDataAccessObject;
import entity.CommonUserFactory;
import interface_adapter.Collect_Questions.CollectQuestionsViewModel;
import interface_adapter.end_game.EndGameViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.select_type.SelectTypeViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.ViewManagerModel;
import use_case.login.LoginUserDataAccessInterface;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // The main application window.
        JFrame application = new JFrame("Quizit!");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // The data for the views, such as username and password, are in the ViewModels.
        // This information will be changed by a presenter object that is reporting the
        // results from the use case. The ViewModels are observable, and will
        // be observed by the Views.
        LoginViewModel loginViewModel = new LoginViewModel();
        LoggedInViewModel loggedInViewModel = new LoggedInViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();

        // New View_Model here:
        CollectQuestionsViewModel collectQuestionsViewModel = new CollectQuestionsViewModel();
        SelectTypeViewModel selectTypeViewModel = new SelectTypeViewModel();

        EndGameViewModel endGameViewModel = new EndGameViewModel();

        FileUserDataAccessObject userDataAccessObject;
        try {
            userDataAccessObject = new FileUserDataAccessObject("./users.csv", new CommonUserFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // New Stuff

        CollectQuestionsView collectQuestionsView = CollectQuestionsCaseFactory.create(viewManagerModel, collectQuestionsViewModel, selectTypeViewModel );
        views.add(collectQuestionsView, collectQuestionsView.viewName);

        // WILL NEED TO BE CHANGED INTO A FACTORY WHEN THE 1/2 OUTPUT VIEWS FROM THE BUTTONS ARE READY
        SelectTypeView selectTypeView = new SelectTypeView(selectTypeViewModel, viewManagerModel);
        views.add(selectTypeView, selectTypeView.viewName);

        // This can either kick you out to signup or loop you back to start, or move you to leaderboard(may be added later)
        //EndGameView endGameView = EndGameCaseFactory.create(viewManagerModel, endGameViewModel, collectQuestionsViewModel, signupViewModel);
        EndGameView endGameView = new EndGameView(endGameViewModel,signupViewModel, collectQuestionsViewModel, viewManagerModel);
        views.add(endGameView, endGameView.viewName);
        /////////////////////////////////////////////////////

        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, userDataAccessObject, userDataAccessObject);
        views.add(signupView, signupView.viewName);

        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, loggedInViewModel, userDataAccessObject);
        views.add(loginView, loginView.viewName);

        LoggedInView loggedInView = new LoggedInView(loggedInViewModel);
        views.add(loggedInView, loggedInView.viewName);

        viewManagerModel.setActiveView(signupView.viewName);
        viewManagerModel.firePropertyChanged();

        application.setPreferredSize(new Dimension(1024,800));
        application.pack();
        application.setVisible(true);
    }
}
