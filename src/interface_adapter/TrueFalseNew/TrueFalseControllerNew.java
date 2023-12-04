package interface_adapter.TrueFalseNew;


import entity.APIException;
import use_case.truefalseNew.TrueFalseInputBoundaryNew;
import use_case.truefalseNew.TrueFalseInputDataNew;

import java.io.IOException;

public class TrueFalseControllerNew {

    final TrueFalseInputBoundaryNew truefalseUseCaseInteractorNew;

    public TrueFalseControllerNew(TrueFalseInputBoundaryNew truefalseUseCaseInteractorNew){
        this.truefalseUseCaseInteractorNew = truefalseUseCaseInteractorNew;
    }

    public void execute(String answer, Boolean isFirstDone, String Qleft, String typeQuestion) throws APIException, IOException, InterruptedException {

        TrueFalseInputDataNew trueFalseInputDataNew = new TrueFalseInputDataNew(answer, isFirstDone, Qleft, typeQuestion);



        truefalseUseCaseInteractorNew.execute(trueFalseInputDataNew);
    }

}
