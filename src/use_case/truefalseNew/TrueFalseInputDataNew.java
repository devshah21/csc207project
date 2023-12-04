package use_case.truefalseNew;

import javax.swing.*;
import java.util.ArrayList;

public class TrueFalseInputDataNew {

    final private String answer;

    final private String Qleft;

    final private String typeQuestion;
    final private Boolean isFirstDone;

    final private String realAnswer;

    final private JLabel questionA;

    final private ArrayList questions;

    final private int currIndex;

    public TrueFalseInputDataNew(String answer, Boolean isFirstDone, String Qleft, String typeQuestion, JLabel questionA, String realAnswer, ArrayList questions,
                                 int currIndex) {
        this.answer = answer;
        this.Qleft = Qleft;
        this.isFirstDone = isFirstDone;
        this.typeQuestion = typeQuestion;
        this.questionA = questionA;
        this.realAnswer = realAnswer;
        this.questions = questions;
        this.currIndex = currIndex;

    }

    int getCurrIndex(){return currIndex;}
    ArrayList getQuestions(){return questions;}
    String getRealAnswer(){return realAnswer;}
    JLabel getQuestionAsked(){return questionA;}
    String getAnswer() {
        return answer;
    }

    String getQleft(){ return Qleft;}

    Boolean getIsFirstDone(){ return isFirstDone;}

    String getTypeQuestion(){ return typeQuestion;}

}
