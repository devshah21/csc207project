package interface_adapter.Collect_Questions;

import interface_adapter.login.LoginState;

public class CollectQuestionsState {


    private String totalQ = "";

    private String username = "";
    private String totalQError = null;

    public CollectQuestionsState(CollectQuestionsState copy) {
        totalQ = copy.totalQ;
        totalQError = copy.totalQError;
        username = copy.username;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public CollectQuestionsState() {}

    public String getTotalQ() {
        return totalQ;
    }

    public void setTotalQ(String totalQ) {
        this.totalQ = totalQ;
    }

    public String getUsername(){ return username;}

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTotalQError(String totalQError) {
        this.totalQError = totalQError;
    }


    public String getTotalQError() {
        return totalQError;
    }

    public void resetTotalQError() {this.totalQError = null;}

}
