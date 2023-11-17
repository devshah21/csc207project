package entity;

import java.util.ArrayList;

public class QuestionFactory implements Question{
    private final String category;
    private final String type;
    private final String difficulty;
    private final String question;
    private final String rightAnswer;
    private final ArrayList<String> wrongAnswers;

    public QuestionFactory(String category, String type, String difficulty, String question, String rightAnswer, ArrayList<String> wrongAnswers) {
        this.category = category;
        this.type = type;
        this.difficulty = difficulty;
        this.question = question;
        this.rightAnswer = rightAnswer;
        this.wrongAnswers = (ArrayList<String>) wrongAnswers.clone();
    }

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public ArrayList<String> getWrongAnswers() {
        return (ArrayList<String>) wrongAnswers.clone();
    }
}
