package interface_adapter.TrueFalseNew;

public class TrueFalseStateNew {

    private String totalQ = "";

    private String username = "";
    private String trueErrorFeild = null;
    private String falseErrorField = null;

    // Only upon first press is this true, after that the game runs
    private boolean isFirst = false;

    // This will store type of question, to start it is none
    private String typeQuestion = ""; //Type of question asked by the API

    private String questionAsked = ""; //This is the question asked by the API

    private String questionAnswer = ""; // Questions asnwer

    private int score = 0; // totalscore for the game

    TrueFalseStateNew(TrueFalseStateNew copy){

        username = copy.username;
        totalQ = copy.totalQ;
        trueErrorFeild = copy.trueErrorFeild;
        falseErrorField = copy.falseErrorField;
        typeQuestion = copy.typeQuestion;
        questionAsked = copy.questionAsked;
        questionAnswer = copy.questionAnswer;
        score = copy.score;
    }

    TrueFalseStateNew() {}


    public int getTotScore() {return score;}
    public void setTotScore(int score) {
        this.score = score;
    }

    public String getQuestionAnswer() {return questionAnswer;}
    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public String getQuestionAsked() {return questionAsked;}
    public void setQuestionAsked(String questionAsked) {
        this.questionAsked = questionAsked;
    }

    public boolean isFirstDone() {
        return isFirst;
    }
    public void firstDone(){this.isFirst = true; } //After first run do this
    public void firstReset(){this.isFirst = false; } //Reset in case rerun

    public String getTotalQ() {
        return totalQ;
    }
    public void setTotalQ(String totalQ) {
        this.totalQ = totalQ;
    }

    public String getTypeQuestion(){return typeQuestion;}
    public void setTypeQuestion(String typeQuestion){this.typeQuestion = typeQuestion;}

    public String getUsername(){ return username;}
    public void setUsername(String username) {
        this.username = username;
    }

    public String getTrueErrorFeild(){ return trueErrorFeild;}
    public void setTrueErrorFeild(String trueErrorFeild) {
        this.trueErrorFeild = trueErrorFeild;
    }

    public String getFalseErrorFeild(){ return falseErrorField;}
    public void setFalseErrorFeild(String falseErrorFeild) {
        this.falseErrorField = falseErrorFeild;
    }


}
