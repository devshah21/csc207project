package interface_adapter.Collect_Questions;

import interface_adapter.login.LoginState;

public class CollectQuestionsState {


    private String totalQ = "";
    private String totalQError = null;

    public CollectQuestionsState(CollectQuestionsState copy) {
        totalQ = copy.totalQ;
        totalQError = copy.totalQError;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public CollectQuestionsState() {}

    public String getTotalQ() {
        return totalQ;
    }

    public void setTotalQ(String totalQ) {
        this.totalQ = totalQ;
    }

    public void setTotalQError(String totalQError) {
        this.totalQError = totalQError;
    }


}
