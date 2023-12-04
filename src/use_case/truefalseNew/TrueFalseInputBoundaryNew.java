package use_case.truefalseNew;

import entity.APIException;

import java.io.IOException;

public interface TrueFalseInputBoundaryNew {

    void execute(TrueFalseInputDataNew trueFalseInputDataNew) throws APIException, IOException, InterruptedException;

}
