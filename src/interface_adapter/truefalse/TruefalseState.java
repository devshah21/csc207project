package interface_adapter.truefalse;

import interface_adapter.signup.SignupState;

public class TruefalseState {

    private String category = "9";
    private String type = "boolean";
    private String totalQ = "";
    private String difficulty = "easy";

    private String username = "";

    public TruefalseState(TruefalseState test) {
        username = test.username;
        totalQ = test.totalQ;
        difficulty = test.difficulty;
        type = test.type;
        category = test.category;
    }

    public TruefalseState() {
    }


    public String getTotalQ() {
        return totalQ;
    }

    public void setTotalQ(String totalQ) {
        this.totalQ = totalQ;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getCategory() {
        return category;
    }

    public String getType() { return type;}


}
