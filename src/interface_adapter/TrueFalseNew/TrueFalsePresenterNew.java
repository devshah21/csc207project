package interface_adapter.TrueFalseNew;

import entity.APIException;
import interface_adapter.Collect_Questions.CollectQuestionsState;
import interface_adapter.ViewManagerModel;
import interface_adapter.end_game.EndGameViewModel;
import use_case.collect_questions.CollectQuestionsOutputData;
import use_case.truefalseNew.TrueFalseInputBoundaryNew;
import use_case.truefalseNew.TrueFalseInputDataNew;
import use_case.truefalseNew.TrueFalseOutputBoundaryNew;
import use_case.truefalseNew.TrueFalseOutputDataNew;

import java.io.IOException;

public class TrueFalsePresenterNew implements TrueFalseOutputBoundaryNew {


    private ViewManagerModel viewManagerModel;

    private final TrueFalseViewModelNew trueFalseViewModelNew;

    private final EndGameViewModel endGameViewModel;


    public TrueFalsePresenterNew(ViewManagerModel viewManagerModel, TrueFalseViewModelNew trueFalseViewModelNew, EndGameViewModel endGameViewModel){

        this.viewManagerModel = viewManagerModel;
        this.trueFalseViewModelNew = trueFalseViewModelNew;
        this.endGameViewModel = endGameViewModel;


    }

    @Override
    public void prepareSuccessView(TrueFalseOutputDataNew data) {
        //Overhere



    }

    @Override
    public void prepareFailView(TrueFalseOutputDataNew data) {
        // Overhere we will the case if this was the very first start of the game

        TrueFalseStateNew trueFalseStateNew = trueFalseViewModelNew.getState();

        // Set all needed variables for next run
        String Qasked = data.getQuestionAsked();
        String Qtype = data.getCategory();
        String Qanswer = data.getQuestionAsnwer();
        trueFalseStateNew.setQuestionAsked(Qasked);
        trueFalseStateNew.setTypeQuestion(Qtype);
        trueFalseStateNew.setQuestionAnswer(Qanswer);

        // Now that everything is set we can run the game, so refire the view
        viewManagerModel.setActiveView(trueFalseViewModelNew.getViewName());
        viewManagerModel.firePropertyChanged();


    }
}
