package interface_adapter.TrueFalseNew;

import data_access.InformationStorageDAO;
import data_access.LeaderBoardDataAccessObject;
import data_access.SaveScoreDataAccessObject;
import entity.APIException;
import interface_adapter.Collect_Questions.CollectQuestionsState;
import interface_adapter.ViewManagerModel;
import interface_adapter.end_game.EndGameState;
import interface_adapter.end_game.EndGameViewModel;
import use_case.collect_questions.CollectQuestionsOutputData;
import use_case.truefalseNew.TrueFalseInputBoundaryNew;
import use_case.truefalseNew.TrueFalseInputDataNew;
import use_case.truefalseNew.TrueFalseOutputBoundaryNew;
import use_case.truefalseNew.TrueFalseOutputDataNew;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class TrueFalsePresenterNew implements TrueFalseOutputBoundaryNew {


    private ViewManagerModel viewManagerModel;

    private final TrueFalseViewModelNew trueFalseViewModelNew;

    private final EndGameViewModel endGameViewModel;

    private final SaveScoreDataAccessObject saveScoreDataAccessObject;

    private final LeaderBoardDataAccessObject leaderBoardDataAccessObject;

    private final InformationStorageDAO informationStorageDAO;

    public TrueFalsePresenterNew(ViewManagerModel viewManagerModel, TrueFalseViewModelNew trueFalseViewModelNew, EndGameViewModel endGameViewModel,
                                 SaveScoreDataAccessObject saveScoreDataAccessObject, LeaderBoardDataAccessObject leaderBoardDataAccessObject,
                                 InformationStorageDAO informationStorageDAO){

        this.viewManagerModel = viewManagerModel;
        this.trueFalseViewModelNew = trueFalseViewModelNew;
        this.endGameViewModel = endGameViewModel;
        this.saveScoreDataAccessObject = saveScoreDataAccessObject;
        this.leaderBoardDataAccessObject = leaderBoardDataAccessObject;
        this.informationStorageDAO = informationStorageDAO;


    }

    @Override
    public void prepareSuccessView(TrueFalseOutputDataNew data) throws IOException {

        TrueFalseStateNew trueFalseStateNew = trueFalseViewModelNew.getState();

        int Qleft = Integer.parseInt(data.getQleft());
        int caseI = data.getCaseI();

        //Another question done so decrease counter by 1
        Qleft = Qleft - 1;
        int index = trueFalseStateNew.getBackupTotQ();
        trueFalseStateNew.setBackupTotQ(index+1);
        trueFalseStateNew.setTotalQ(String.valueOf(Qleft));



        if (Qleft == -1){
            // Run out of cases prepare to go to endGame (run the DAO's) ADD THEM TO FACTORY

            if(caseI == 2){
                int totScore = trueFalseStateNew.getTotScore();
                trueFalseStateNew.setTotScore(totScore+1);
                System.out.println("increase");
                JOptionPane.showMessageDialog(null, "CORRECT", "RESULT", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "INCORRECT", "RESULT", JOptionPane.INFORMATION_MESSAGE);
            }

            // NEXT WE CALL DAO'S TO BUILD OUTPUTS TO ENDGAME
            String username = trueFalseStateNew.getUsername();
            int score = trueFalseStateNew.getTotScore();

            informationStorageDAO.writeIntoFile(username, String.valueOf(score),String.valueOf(index),"trueOrFalse", ":" );

            trueFalseStateNew.firstReset();
            // ADD A BUNCH OF GETTERS AND SETTERS TO RESET THIS ENTIRE CLASS

            //String[] boards = leaderBoardDataAccessObject.generateLeaderBoards(username, score,String.valueOf(index),"trueOrFalse","I");
            String userOut = "";
            String TFboard = "";
            String Mulboard = "";

            //System.out.println(TFboard);
            //System.out.println(Mulboard);

            EndGameState endGameState = endGameViewModel.getState();
            // Display outputs
            endGameState.setOutput(userOut);
            endGameState.setLBTF(TFboard);
            endGameState.setLBMul(Mulboard);
            endGameState.setUsername(username);

            //Reset everything
            trueFalseStateNew.setTotalQ("0");
            trueFalseStateNew.setBackupTotQ(0);
            trueFalseStateNew.firstReset();
            trueFalseStateNew.setTypeQuestion("");
            trueFalseStateNew.setQuestionAsked("");
            trueFalseStateNew.setQuestionAnswer("");
            trueFalseStateNew.setTotScore(0);
            ArrayList empty = new ArrayList();
            trueFalseStateNew.setQuestions(empty);


            this.endGameViewModel.setState(endGameState);
            this.endGameViewModel.firePropertyChanged();

            //Next Case
            this.viewManagerModel.setActiveView(endGameViewModel.getViewName());
            this.viewManagerModel.firePropertyChanged();

            //System.out.println("hihihihih");


        }
        else if (caseI == 2) {
            // Player is right up the score
            int totScore = trueFalseStateNew.getTotScore();
            trueFalseStateNew.setTotScore(totScore+1);

            // Now go back to hub

            // Set all needed variables for next run
            String Qasked = data.getQuestionAsked();
            String Qtype = data.getCategory();
            String Qanswer = data.getQuestionAsnwer(); // Give the real question answer
            trueFalseStateNew.setQuestionAsked(Qasked);
            trueFalseStateNew.setTypeQuestion(Qtype);
            trueFalseStateNew.setQuestionAnswer(Qanswer);
            //trueFalseStateNew.isFirstDone(); // will prevent more runs from happenining of initilization
            // Now that everything is set we can run the game, so refire the view

            //Update the Jlabel
            JLabel questionOut = data.getQuestionA();

            questionOut.setText(Qasked);

            JOptionPane.showMessageDialog(null, "CORRECT", "RESULT", JOptionPane.INFORMATION_MESSAGE);

            viewManagerModel.setActiveView(trueFalseViewModelNew.getViewName());
            viewManagerModel.firePropertyChanged();

        }
        else {
            // Player is wrong so dont add score and just go back to start

            // Set all needed variables for next run
            String Qasked = data.getQuestionAsked();
            String Qtype = data.getCategory();
            String Qanswer = data.getQuestionAsnwer(); // Give the real question answer
            trueFalseStateNew.setQuestionAsked(Qasked);
            trueFalseStateNew.setTypeQuestion(Qtype);
            trueFalseStateNew.setQuestionAnswer(Qanswer);
            //trueFalseStateNew.isFirstDone(); // will prevent more runs from happenining of initilization
            // Now that everything is set we can run the game, so refire the view

            //Update the Jlabel
            JLabel questionOut = data.getQuestionA();

            questionOut.setText(Qasked);

            JOptionPane.showMessageDialog(null, "INCORRECT", "RESULT", JOptionPane.INFORMATION_MESSAGE);

            viewManagerModel.setActiveView(trueFalseViewModelNew.getViewName());
            viewManagerModel.firePropertyChanged();
        }
    }

    @Override
    public void prepareFailView(TrueFalseOutputDataNew data) {
        // Overhere we will the case if this was the very first start of the game

        TrueFalseStateNew trueFalseStateNew = trueFalseViewModelNew.getState();

        int Qleft = Integer.parseInt(data.getQleft());
        int caseI = data.getCaseI();

        //Another question done so decrease counter by 1
        Qleft = Qleft - 1;
        int index = trueFalseStateNew.getBackupTotQ();
        trueFalseStateNew.setBackupTotQ(index+1);
        trueFalseStateNew.setTotalQ(String.valueOf(Qleft));

        // Set all needed variables for next run
        String Qasked = data.getQuestionAsked();
        String Qtype = data.getCategory();
        String Qanswer = data.getQuestionAsnwer(); // Give the real question answer
        ArrayList questions = data.getQuestions();

        trueFalseStateNew.setQuestions(questions);
        trueFalseStateNew.setQuestionAsked(Qasked);
        trueFalseStateNew.setTypeQuestion(Qtype);
        trueFalseStateNew.setQuestionAnswer(Qanswer);
        trueFalseStateNew.firstDone(); // will prevent more runs from happenining of initilization
        // Now that everything is set we can run the game, so refire the view

        //Update the Jlabel
        JLabel questionOut = data.getQuestionA();

        questionOut.setText(Qasked);

        viewManagerModel.setActiveView(trueFalseViewModelNew.getViewName());
        viewManagerModel.firePropertyChanged();



    }
}
