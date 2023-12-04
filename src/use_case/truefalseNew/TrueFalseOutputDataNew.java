package use_case.truefalseNew;

import javax.swing.*;
import java.util.ArrayList;

public class TrueFalseOutputDataNew {

    private final String category;

    private final String Qleft;

    private final String questionAsnwer;

    private final String questionAsked;

    private final int score;

    private final int caseI;

    private final JLabel questionA;

    private ArrayList questions;

    public TrueFalseOutputDataNew(String category, String Qleft, String questionAsnwer, String questionAsked, int score, int caseI, JLabel questionA, ArrayList questions){


        this.category = category;
        this.Qleft = Qleft;
        this.questionAsnwer = questionAsnwer;
        this.questionAsked = questionAsked;
        this.score = score;
        this.caseI = caseI;
        this.questionA = questionA;
        this.questions = questions;

    }

    public ArrayList getQuestions(){return questions;}
    public JLabel getQuestionA(){return  questionA;}

    public String getCategory(){ return category; }

    public String getQleft(){ return Qleft; }

    public String getQuestionAsnwer(){ return questionAsnwer;}

    public String getQuestionAsked() { return  questionAsked;}

    public int getScore() { return score;}

    public int getCaseI() { return caseI;}

}
