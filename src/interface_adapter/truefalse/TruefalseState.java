package interface_adapter.truefalse;

public class TruefalseState {

    private String category = "9";
    private String type = "boolean";
    private int questions=2;
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


    public void setQuestions(int questions) { this.questions = questions; }

    public void setUsername(String username) {this.username = username; }


}
