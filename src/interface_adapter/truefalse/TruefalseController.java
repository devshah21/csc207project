package interface_adapter.truefalse;

import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInputData;
import use_case.truefalse.TruefalseInputBoundary;
import use_case.truefalse.TruefalseInputData;

public class TruefalseController {
    final TruefalseInputBoundary userTruefalseInteractor;
    public TruefalseController(TruefalseInputBoundary userTruefalseInteractor) {
        this.userTruefalseInteractor = userTruefalseInteractor;
    }

    public void execute(int amount, String difficulty, String type, String category) {
        TruefalseInputData truefalseInputData = new TruefalseInputData(
                amount, difficulty, type, category);

        userTruefalseInteractor.execute(truefalseInputData);
    }
}
