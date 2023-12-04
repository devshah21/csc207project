package use_case.truefalseNew;

import use_case.collect_questions.CollectQuestionsOutputData;

public interface TrueFalseOutputBoundaryNew {

    void prepareSuccessView(TrueFalseOutputDataNew data);

    void prepareFailView(TrueFalseOutputDataNew data); // If we return just a string we know an error happened

}
