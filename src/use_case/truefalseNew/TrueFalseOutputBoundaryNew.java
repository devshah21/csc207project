package use_case.truefalseNew;

import use_case.collect_questions.CollectQuestionsOutputData;

import java.io.IOException;

public interface TrueFalseOutputBoundaryNew {

    void prepareSuccessView(TrueFalseOutputDataNew data) throws IOException;

    void prepareFailView(TrueFalseOutputDataNew data); // If we return just a string we know an error happened

}
