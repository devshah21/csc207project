package interface_adapter.truefalse;

import interface_adapter.signup.SignupState;

public class TruefalseState {

    private String category = "9";
    private String type = "boolean";
    private int questions = 10;
    private String difficulty = "easy";

    private String username = "";

    public TruefalseState(TruefalseState test) {
        username = test.username;
        questions = test.questions;
        difficulty = test.difficulty;
        type = test.type;
        category = test.category;
    }

    public TruefalseState() {
    }


    public String getUsername1() {
        return username;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getCategory() {
        return category;
    }

    public int getQuestions() {
        return questions;
    }

    public String getType() { return type;}


}
