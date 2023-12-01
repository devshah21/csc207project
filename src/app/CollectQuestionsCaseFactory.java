package app;

import interface_adapter.Collect_Questions.CollectQuestionsController;
import interface_adapter.Collect_Questions.CollectQuestionsPresenter;
import interface_adapter.Collect_Questions.CollectQuestionsViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginController;
import interface_adapter.select_type.SelectTypeViewModel;
import use_case.collect_questions.CollectQuestionInteractor;
import use_case.collect_questions.CollectQuestionsInputBoundary;
import use_case.collect_questions.CollectQuestionsOutputBoundary;
import view.CollectQuestionsView;
import view.LoginView;

import javax.swing.*;
import java.io.IOException;

public class CollectQuestionsCaseFactory {

    private CollectQuestionsCaseFactory() {}


    public static CollectQuestionsView create(ViewManagerModel viewManagerModel,
                                              CollectQuestionsViewModel collectQuestionsViewModel, SelectTypeViewModel selectTypeViewModel){

        try {
            CollectQuestionsController collectQuestionsController = createCollectQuestionsUseCase(viewManagerModel, collectQuestionsViewModel, selectTypeViewModel);
            return new CollectQuestionsView(collectQuestionsViewModel, collectQuestionsController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "It broke idk why.");
        }

        return null;
    }

    private static CollectQuestionsController createCollectQuestionsUseCase(ViewManagerModel viewManagerModel,
                                                                            CollectQuestionsViewModel collectQuestionsViewModel, SelectTypeViewModel selectTypeViewModel) throws IOException {

        CollectQuestionsOutputBoundary collectQuestionsOutputBoundary = new CollectQuestionsPresenter(viewManagerModel, collectQuestionsViewModel, selectTypeViewModel);

        CollectQuestionsInputBoundary collectQuestionsInteractor = new CollectQuestionInteractor(collectQuestionsOutputBoundary);

        return new CollectQuestionsController(collectQuestionsInteractor);

    }

}
