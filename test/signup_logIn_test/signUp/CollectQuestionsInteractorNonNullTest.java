package signup_logIn_test.signUp;

import interface_adapter.Collect_Questions.CollectQuestionsViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.select_type.SelectTypeState;
import interface_adapter.select_type.SelectTypeViewModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.collect_questions.CollectQuestionInteractor;
import use_case.collect_questions.CollectQuestionsInputData;
import use_case.collect_questions.CollectQuestionsOutputBoundary;
import use_case.collect_questions.CollectQuestionsOutputData;

import interface_adapter.Collect_Questions.*;
public class CollectQuestionsInteractorNonNullTest {
    private CollectQuestionsOutputBoundary collectQuestionsPresenter;
    private CollectQuestionInteractor collectQuestionInteractor;
    private CollectQuestionsViewModel collectQuestionsViewModel;
    private ViewManagerModel viewManagerModel;
    private SelectTypeViewModel selectTypeViewModel;

    @BeforeEach
    void setUp() {
        collectQuestionsViewModel = new CollectQuestionsViewModel();
        viewManagerModel = new ViewManagerModel();
        selectTypeViewModel = new SelectTypeViewModel();
        collectQuestionsPresenter = new CollectQuestionsPresenter(viewManagerModel, collectQuestionsViewModel, selectTypeViewModel);
        collectQuestionInteractor = new CollectQuestionInteractor(collectQuestionsPresenter);
    }

    @Test
    void testSuccessfulCollectionWithNonNullSelectTypeViewModel() {
        // Arrange
        // Set up a non-null SelectTypeViewModel
        SelectTypeState selectTypeState = new SelectTypeState();
        selectTypeState.setTotalQ("5");
        selectTypeState.setUsername("testUser");
        selectTypeViewModel.setState(selectTypeState);

        // Act
        collectQuestionInteractor.execute(new CollectQuestionsInputData("5", "testUser"));

        // Assert
        // Implement your assertions based on the actual behavior of the interactor
        Assertions.assertNull(collectQuestionsViewModel.getState().getTotalQError());
        CollectQuestionsState collectQuestionsState = collectQuestionsViewModel.getState();
        Assertions.assertEquals("", collectQuestionsState.getUsername());

        // Check if SelectTypeViewModel is not null

        // Add more assertions as needed
    }

    @Test
    void testUnsuccessfulCollectionWithNonNullSelectTypeViewModel() {
        // Arrange
        // Set up a non-null SelectTypeViewModel
        SelectTypeState selectTypeState = new SelectTypeState();
        selectTypeState.setTotalQ("invalidInput");
        selectTypeState.setUsername("userWithInvalidInput");
        selectTypeViewModel.setState(selectTypeState);

        // Act
        collectQuestionInteractor.execute(new CollectQuestionsInputData("invalidInput", "userWithInvalidInput"));

        // Assert
        // Implement your assertions based on the actual behavior of the interactor
        Assertions.assertEquals("Input correct value", collectQuestionsViewModel.getState().getTotalQError());

        // Check if SelectTypeViewModel is not null

        // Add more assertions as needed
    }
    // Add more test methods as needed to cover various scenarios
}