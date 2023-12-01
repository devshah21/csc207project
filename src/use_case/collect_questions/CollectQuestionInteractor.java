package use_case.collect_questions;


public class CollectQuestionInteractor implements CollectQuestionsInputBoundary {


    final CollectQuestionsOutputBoundary collectQuestionsPresenter;

    private int totalQI = 0;

    public CollectQuestionInteractor(CollectQuestionsOutputBoundary collectQuestionsOutputBoundary) {

        this.collectQuestionsPresenter = collectQuestionsOutputBoundary;
    }

    @Override
    public void execute(CollectQuestionsInputData collectQuestionsInputData) {

        String totalQW = collectQuestionsInputData.getTotalQ();

        // over here check if we have a string or not
        try {
            // If nothing fails then move to success case
            int totalQI = Integer.parseInt( totalQW );

            if (totalQI < 1)
                collectQuestionsPresenter.prepareFailView("Input correct value");

            this.totalQI = totalQI;
            CollectQuestionsOutputData collectQuestionsOutputData = new CollectQuestionsOutputData(totalQW, false);
            collectQuestionsPresenter.prepareSuccessView(collectQuestionsOutputData);

        }
        catch( Exception e ) {

            collectQuestionsPresenter.prepareFailView("Input correct value");

        }
    }

    // To grab the total questions if needed later, or send to other places
    public int getTotalQ(){ return totalQI; }


}
