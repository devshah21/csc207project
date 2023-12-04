package use_case.collect_questions;

public class CollectQuestionsOutputData {

    private final String totalQ;
    private boolean didUseCaseFailed;

    private final String username;

    public CollectQuestionsOutputData(String totalQ, String username,  boolean didUseCaseFailed) {
        this.totalQ = totalQ;
        this.didUseCaseFailed = didUseCaseFailed;
        this.username = username;
    }

    public String getTotalQ() {
        return totalQ;
    }

    public String getUsername() {
        return username;
    }

    public boolean getDidUseCaseFail(){return didUseCaseFailed;}

}
