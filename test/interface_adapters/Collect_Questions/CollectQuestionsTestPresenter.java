package interface_adapters.Collect_Questions;

import interface_adapter.Collect_Questions.CollectQuestionsController;
import interface_adapter.Collect_Questions.CollectQuestionsPresenter;
import interface_adapter.Collect_Questions.CollectQuestionsViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.select_type.SelectTypeState;
import interface_adapter.select_type.SelectTypeViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import use_case.collect_questions.CollectQuestionInteractor;
import use_case.collect_questions.CollectQuestionsInputBoundary;
import use_case.collect_questions.CollectQuestionsInputData;
import use_case.collect_questions.CollectQuestionsOutputBoundary;


public class CollectQuestionsTestPresenter {

    private CollectQuestionsController collectQuestionsController;
    private CollectQuestionsViewModel collectQuestionsViewModel;
    private CollectQuestionsOutputBoundary collectQuestionsOutputBoundary;
    private CollectQuestionsInputBoundary collectQuestionsInteractor;

    private ViewManagerModel viewManagerModel;
    private SelectTypeViewModel selectTypeViewModel;

    @Before
    public void init() {

        viewManagerModel = new ViewManagerModel();
        collectQuestionsViewModel = new CollectQuestionsViewModel();
        selectTypeViewModel = new SelectTypeViewModel();

        collectQuestionsOutputBoundary = new CollectQuestionsPresenter(viewManagerModel, collectQuestionsViewModel, selectTypeViewModel);
        collectQuestionsInteractor = new CollectQuestionInteractor(collectQuestionsOutputBoundary);
        collectQuestionsController = new CollectQuestionsController(collectQuestionsInteractor);

    }

    @Test
    public void testPrepareSuccessView() {

        CollectQuestionsInputData collectQuestionsInputData = new CollectQuestionsInputData("17", "Bob Ross");

        collectQuestionsInteractor.execute(collectQuestionsInputData);

        Assertions.assertNull(collectQuestionsViewModel.getState().getTotalQError());

    }

    @Test
    public void testPrepareFailView() {

        CollectQuestionsInputData collectQuestionsInputData = new CollectQuestionsInputData("B", "Bob Ross");

        collectQuestionsInteractor.execute(collectQuestionsInputData);

        Assertions.assertNotNull(collectQuestionsViewModel.getState().getTotalQError());

    }


}
