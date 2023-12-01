package use_case.collect_questions;



public interface CollectQuestionsOutputBoundary {

    void prepareSuccessView(CollectQuestionsOutputData totalQ);

    void prepareFailView(String error); // If we return just a string we know an error happened

}
