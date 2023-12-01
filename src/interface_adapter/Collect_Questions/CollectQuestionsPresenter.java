package interface_adapter.Collect_Questions;

import interface_adapter.select_type.SelectTypeState;
import interface_adapter.select_type.SelectTypeViewModel;
import use_case.collect_questions.CollectQuestionsOutputBoundary;
import use_case.collect_questions.CollectQuestionsOutputData;
import interface_adapter.ViewManagerModel;

import javax.swing.*;

public class CollectQuestionsPresenter implements CollectQuestionsOutputBoundary {

    // Set up news models to call up here

    private final CollectQuestionsViewModel collectQuestionsViewModel;

    private final SelectTypeViewModel selectTypeViewModel;

    private ViewManagerModel viewManagerModel;

    public CollectQuestionsPresenter(ViewManagerModel viewManagerModel, CollectQuestionsViewModel collectQuestionsViewModel, SelectTypeViewModel selectTypeViewModel) {
    // initalize new models to change to over here
        this.viewManagerModel = viewManagerModel;
        this.collectQuestionsViewModel = collectQuestionsViewModel;
        this.selectTypeViewModel = selectTypeViewModel;
    }

    // Both cases will tell a view model to fire pass will call a new view model to run, fail will call the old one to run again

    @Override
    public void prepareSuccessView(CollectQuestionsOutputData totalQ) {
        // Upon passing run something to switch to the main game View, work with Dev on this part
        String tot = totalQ.getTotalQ();
        String output = "You selected " + tot + " questions";

        JOptionPane.showMessageDialog(null, output, "Total", JOptionPane.INFORMATION_MESSAGE);

        //Something like this will let you move data onto the next use case no problem
        SelectTypeState selectTypeState = selectTypeViewModel.getState();
        selectTypeState.setTotalQ(totalQ.getTotalQ());
        this.selectTypeViewModel.setState(selectTypeState);
        this.selectTypeViewModel.firePropertyChanged();

        //Next Case
        this.viewManagerModel.setActiveView(selectTypeViewModel.getViewName());

        this.viewManagerModel.firePropertyChanged();
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
