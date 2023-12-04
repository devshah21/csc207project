package app;

import data_access.InformationStorageDAO;
import data_access.LeaderBoardDataAccessObject;
import data_access.SaveScoreDataAccessObject;
import interface_adapter.Collect_Questions.CollectQuestionsController;
import interface_adapter.TrueFalseNew.TrueFalseControllerNew;
import interface_adapter.TrueFalseNew.TrueFalsePresenterNew;
import interface_adapter.TrueFalseNew.TrueFalseViewModelNew;
import interface_adapter.ViewManagerModel;
import interface_adapter.end_game.EndGameViewModel;
import use_case.truefalseNew.TrueFalseInputBoundaryNew;
import use_case.truefalseNew.TrueFalseInteractorNew;
import use_case.truefalseNew.TrueFalseOutputBoundaryNew;
import view.CollectQuestionsView;
import view.TrueFalseNewView;

import javax.swing.*;
import java.io.IOException;

public class TrueFalseNewCaseFactory {


    private TrueFalseNewCaseFactory(){}

    public static TrueFalseNewView create(ViewManagerModel viewManagerModel, TrueFalseViewModelNew trueFalseViewModelNew, EndGameViewModel endGameViewModel,
                                          SaveScoreDataAccessObject saveScoreDataAccessObject, LeaderBoardDataAccessObject leaderBoardDataAccessObject,
                                          InformationStorageDAO informationStorageDAO){

        TrueFalseControllerNew trueFalseControllerNew = createTrueFalseNewUseCase(viewManagerModel, trueFalseViewModelNew, endGameViewModel, saveScoreDataAccessObject, leaderBoardDataAccessObject,
                informationStorageDAO);
        return new TrueFalseNewView(trueFalseViewModelNew, trueFalseControllerNew);

    }

    private static TrueFalseControllerNew createTrueFalseNewUseCase(ViewManagerModel viewManagerModel, TrueFalseViewModelNew trueFalseViewModelNew,
    EndGameViewModel endGameViewModel, SaveScoreDataAccessObject saveScoreDataAccessObject, LeaderBoardDataAccessObject leaderBoardDataAccessObject,
                                                                    InformationStorageDAO informationStorageDAO){

        TrueFalseOutputBoundaryNew trueFalseOutputBoundaryNew = new TrueFalsePresenterNew(viewManagerModel, trueFalseViewModelNew, endGameViewModel,saveScoreDataAccessObject,leaderBoardDataAccessObject,
                informationStorageDAO);

        TrueFalseInputBoundaryNew  trueFalseInteractorNew = new TrueFalseInteractorNew(trueFalseOutputBoundaryNew, saveScoreDataAccessObject,leaderBoardDataAccessObject );

        return new TrueFalseControllerNew(trueFalseInteractorNew);
    }
}
