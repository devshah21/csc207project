package interface_adapter.TrueFalseNew;


import entity.APIException;
import use_case.truefalseNew.TrueFalseInputBoundaryNew;
import use_case.truefalseNew.TrueFalseInputDataNew;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class TrueFalseControllerNew {

    final TrueFalseInputBoundaryNew truefalseUseCaseInteractorNew;

    public TrueFalseControllerNew(TrueFalseInputBoundaryNew truefalseUseCaseInteractorNew){
        this.truefalseUseCaseInteractorNew = truefalseUseCaseInteractorNew;
    }

    public void execute(String answer, Boolean isFirstDone, String Qleft, String typeQuestion, JLabel questionA, String realAnswer, ArrayList questions,
                        int currIndex) throws APIException, IOException, InterruptedException {

        TrueFalseInputDataNew trueFalseInputDataNew = new TrueFalseInputDataNew(answer, isFirstDone, Qleft, typeQuestion, questionA, realAnswer, questions, currIndex);



        truefalseUseCaseInteractorNew.execute(trueFalseInputDataNew);
    }

}
