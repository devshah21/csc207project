package entity;

import java.util.ArrayList;

public interface Question {
     String getType();
     String getDifficulty();
     String getCategory();
     String getQuestion();
     String getRightAnswer();
     ArrayList<String> getWrongAnswers();
}
