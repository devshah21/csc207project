package use_case.collect_questions;

public class CollectQuestionsInputData {

    final private String totalQ;

    public CollectQuestionsInputData(String totalQ) {
        this.totalQ = totalQ;

    }

    String getTotalQ() {
        return totalQ;
    }

}
