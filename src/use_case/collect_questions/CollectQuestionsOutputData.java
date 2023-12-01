package use_case.collect_questions;

public class CollectQuestionsOutputData {

    private final String totalQ;
    private boolean didUseCaseFailed;

    public CollectQuestionsOutputData(String totalQ, boolean didUseCaseFailed) {
        this.totalQ = totalQ;
        this.didUseCaseFailed = didUseCaseFailed;
    }

    public String getTotalQ() {
        return totalQ;
    }

}
