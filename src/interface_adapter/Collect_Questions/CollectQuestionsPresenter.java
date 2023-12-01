package interface_adapter.Collect_Questions;


import interface_adapter.login.LoginViewModel;
import use_case.collect_questions.CollectQuestionsOutputBoundary;
import use_case.collect_questions.CollectQuestionsOutputData;
import interface_adapter.ViewManagerModel;

import javax.swing.*;

public class CollectQuestionsPresenter implements CollectQuestionsOutputBoundary {

    // Set up news models to call up here

    private final CollectQuestionsViewModel collectQuestionsViewModel;

    private ViewManagerModel viewManagerModel;

    public CollectQuestionsPresenter(ViewManagerModel viewManagerModel, CollectQuestionsViewModel collectQuestionsViewModel) {
    // initalize new models to change to over here
        this.collectQuestionsViewModel = collectQuestionsViewModel;

    }

    // Both cases will tell a view model to fire pass will call a new view model to run, fail will call the old one to run again

    @Override
    public void prepareSuccessView(CollectQuestionsOutputData totalQ) {
        // Upon passing run something to switch to the main game View, work with Dev on this part
        String tot = totalQ.getTotalQ();
        String output = "You selected " + tot + " questions";
        //System.out.println(output);
        JOptionPane.showMessageDialog(null, output, "Error", JOptionPane.INFORMATION_MESSAGE);
        // ADD POP UP WITH THIS INFO
    }

    @Override
    public void prepareFailView(String error) {
        // You failed, so try again

        //System.out.println(error);
        JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
        // ADD POP UP WITH THIS INFO

        CollectQuestionsState collectQuestionsState = collectQuestionsViewModel.getState();
        collectQuestionsState.setTotalQError(error);
        collectQuestionsViewModel.firePropertyChanged();

    }
}
