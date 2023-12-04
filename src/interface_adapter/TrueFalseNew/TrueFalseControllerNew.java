package interface_adapter.TrueFalseNew;


import use_case.truefalseNew.TrueFalseInputBoundaryNew;
import use_case.truefalseNew.TrueFalseInputDataNew;

public class TrueFalseControllerNew {

    final TrueFalseInputBoundaryNew truefalseUseCaseInteractorNew;

    public TrueFalseControllerNew(TrueFalseInputBoundaryNew truefalseUseCaseInteractorNew){
        this.truefalseUseCaseInteractorNew = truefalseUseCaseInteractorNew;
    }

    public void execute(String answer) {
        TrueFalseInputDataNew trueFalseInputDataNew = new TrueFalseInputDataNew(answer);



        truefalseUseCaseInteractorNew.execute(trueFalseInputDataNew);
    }

}
