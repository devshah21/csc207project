package use_case.truefalse;

import entity.APIException;
import entity.Question;
import use_case.truefalse.TruefalseInputData;

import java.io.IOException;
import java.util.ArrayList;

public interface TruefalseUserDataAccessInterface {
    ArrayList<Question> getQuestions(TruefalseInputData inputData) throws IOException, InterruptedException, APIException;
}
