package interface_adapter.TrueFalseNew;

import java.util.ArrayList;

public class TrueFalseStateNew {

    private String totalQ = "0";

    private int backupTotQ = 0;

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

    private ArrayList questions;

    TrueFalseStateNew(TrueFalseStateNew copy){

        username = copy.username;
        totalQ = copy.totalQ;
        trueErrorFeild = copy.trueErrorFeild;
        falseErrorField = copy.falseErrorField;
        typeQuestion = copy.typeQuestion;
        questionAsked = copy.questionAsked;
        questionAnswer = copy.questionAnswer;
        score = copy.score;
        backupTotQ = copy.backupTotQ;
        questions = copy.questions;
    }

    TrueFalseStateNew() {}

    public ArrayList getQuestions() {return questions;}

    public void setQuestions(ArrayList questions) {
        this.questions = questions;
    }

    public int getBackupTotQ() {return backupTotQ;}
    public void setBackupTotQ(int backupTotQ) {
        this.backupTotQ = backupTotQ;
    }

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
