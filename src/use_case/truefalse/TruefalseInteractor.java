package use_case.truefalse;

import entity.QuizAPI;
import entity.Question;
import java.util.ArrayList;
import java.io.IOException;
import entity.QuizAPI;
import entity.Question;
import java.util.ArrayList;
import java.io.IOException;
import entity.APIException;

import use_case.truefalse.TruefalseInputBoundary;

public class TruefalseInteractor implements TruefalseInputBoundary {
    private TruefalseUserDataAccessInterface dataAccess;
    private TruefalseOutputBoundary presenter;

    public TruefalseInteractor(TruefalseUserDataAccessInterface dataAccess, TruefalseOutputBoundary presenter) {
        this.dataAccess = dataAccess;
        this.presenter = presenter;
    }

    @Override
    public void apply(TruefalseInputData inputData) {
        try {
            // Hardset the values for the API call
            QuizAPI quizAPI = new QuizAPI(10, "easy", "boolean", "9");
            ArrayList<Question> questions = quizAPI.getQuestions();

            // Process the questions here and create an instance of TruefalseOutputData
            // Then, pass it to the presenter
            // presenter.present(outputData);
        } catch (IOException | InterruptedException | APIException e) {
            e.printStackTrace();
            // Handle the exception here
        }
    }
}


