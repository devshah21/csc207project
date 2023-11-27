package use_case.truefalse;

public class TruefalseOutputData {
    private ArrayList<Question> questions;

    public TruefalseOutputData(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }
}
