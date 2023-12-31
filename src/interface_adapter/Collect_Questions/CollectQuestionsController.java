package interface_adapter.Collect_Questions;

import use_case.collect_questions.CollectQuestionsInputBoundary;
import use_case.collect_questions.CollectQuestionsInputData;

public class CollectQuestionsController {

    final CollectQuestionsInputBoundary collectQuestionsUseCaseInteractor;
    public CollectQuestionsController(CollectQuestionsInputBoundary collectQuestionsUseCaseInteractor) {
        this.collectQuestionsUseCaseInteractor = collectQuestionsUseCaseInteractor;
    }


    public void execute(String totalQ, String username) {
        CollectQuestionsInputData collectQuestionsInputData = new CollectQuestionsInputData(totalQ, username);
        // Convert to integer in interactor
        // This will call the interactor
        collectQuestionsUseCaseInteractor.execute(collectQuestionsInputData);
    }

}
