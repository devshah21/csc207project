package Interface_adapter_test.CollectQuestions;


import app.CollectQuestionsCaseFactory;
import entity.Question;
import interface_adapter.Collect_Questions.CollectQuestionsController;
import interface_adapter.Collect_Questions.CollectQuestionsPresenter;
import interface_adapter.Collect_Questions.CollectQuestionsState;
import interface_adapter.Collect_Questions.CollectQuestionsViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.select_type.SelectTypeState;
import interface_adapter.select_type.SelectTypeViewModel;
import org.junit.Before;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import use_case.collect_questions.*;


import static org.junit.Assert.assertNotNull;


public class CollectQuestionsControllerTest {



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
    public void testInputTotalQ() {

        // Not here to test state so lets just throw in some assumed variables

        // Act
        collectQuestionsController.execute("17", "Bob Ross");


        // Assert
        // Implement your assertions based on the actual behavior of your in-memory implementations
        // So test if the CollectQuestionsInputData object was set up correctly
        SelectTypeState selectTypeState = selectTypeViewModel.getState();
        Assertions.assertEquals("17", selectTypeState.getTotalQ());

        //assertNotNull(question.getType());
    }

    @Test
    public void testInputUsername() {

        // Not here to test state so lets just throw in some assumed variables

        // Act
        //CollectQuestionsCaseFactory.create(viewManagerModel, collectQuestionsViewModel, selectTypeViewModel);

        collectQuestionsController.execute("17", "Bob Ross");


        // Assert
        // Implement your assertions based on the actual behavior of your in-memory implementations
        // So test if the CollectQuestionsInputData object was set up correctly
        SelectTypeState selectTypeState = selectTypeViewModel.getState();
        Assertions.assertEquals("Bob Ross", selectTypeState.getUsername());

        //assertNotNull(question.getType());
    }


}


