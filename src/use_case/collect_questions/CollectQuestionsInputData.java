package use_case.collect_questions;

public class CollectQuestionsInputData {

    final private String totalQ;

    final private String username;

    public CollectQuestionsInputData(String totalQ, String username) {
        this.totalQ = totalQ;
        this.username = username;

    }

    String getTotalQ() {
        return totalQ;
    }
    String getUsername(){return username;}

}
