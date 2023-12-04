package use_case.truefalseNew;


import data_access.LeaderBoardDataAccessObject;
import data_access.SaveScoreDataAccessObject;
import entity.APIException;
import entity.Question;
import entity.QuizAPI;

import java.util.ArrayList;
import java.util.Random;
import interface_adapter.TrueFalseNew.TrueFalseStateNew;
import interface_adapter.TrueFalseNew.TrueFalseViewModelNew;

import javax.swing.*;
import java.io.IOException;

public class TrueFalseInteractorNew implements TrueFalseInputBoundaryNew {

    final TrueFalseOutputBoundaryNew truefalsePresenterNew;

    final SaveScoreDataAccessObject saveScoreDataAccessObject;

    final LeaderBoardDataAccessObject leaderBoardDataAccessObject;

    public TrueFalseInteractorNew (TrueFalseOutputBoundaryNew trueFalseOutputBoundaryNew,SaveScoreDataAccessObject saveScoreDataAccessObject, LeaderBoardDataAccessObject leaderBoardDataAccessObject){

        this.truefalsePresenterNew = trueFalseOutputBoundaryNew;
        this.saveScoreDataAccessObject = saveScoreDataAccessObject;
        this.leaderBoardDataAccessObject = leaderBoardDataAccessObject;

    }



    @Override
    public void execute(TrueFalseInputDataNew trueFalseInputDataNew ) throws APIException, IOException, InterruptedException {


        // THIS CODE WILL SEND A NUMBER TO PRESENTER FROM 1 TO 3 INDICATING WHAT CASE IT IS 1: START, 2: REG QUESTION 3: END

        // If this is the first run then the state number will be unchanged from the start

        // So take inputs from start at the view level not now

        // Data will give us questions left, isfirstuse done, and the output of the user from button use there


        // First make case for if this is the very first run
        Boolean isFirst = trueFalseInputDataNew.getIsFirstDone();
        String Qleft = trueFalseInputDataNew.getQleft();
        int score = 0; // add to this send to presetner to add up
        JLabel questionA = trueFalseInputDataNew.getQuestionAsked(); // Get label for asking question
        int currIndex = trueFalseInputDataNew.getCurrIndex();

        if(!isFirst){
            // In this case this is our start for the game, initialize the whole game
            // First pick a random category from 1-9 (Hardlocked rn)
            // CASE: 1

            // NOT IN USE UNTIL IK EVERYTHING IS WORKING AS WANTED
            Random rand = new Random();
            int randInt = rand.nextInt(8);
            randInt = randInt + 1; // Rand from 1-9 idk the range someone edit this later
            // Convert to String
            String category = Integer.toString(randInt);

            category = "9";
            // set the category to what we got up in presenter later

            //Run the first call of the API function to build our questions

            int QleftI = Integer.parseInt(Qleft); // Get Integer version ready

            //System.out.println("hi");
            QuizAPI quizAPI = new QuizAPI(QleftI, "easy", "boolean", category);

            // Grab the first question
            ArrayList<Question> questions = quizAPI.getQuestions();
            String questionAsked = questions.get(currIndex).getQuestion();
            //System.out.println("printed");
            //System.out.println(currIndex);
            //System.out.println(questions.size());
            //Grab the first question answer
            String questionAnswer = questions.get(currIndex).getRightAnswer();

            //Set isFirst to True in presenter

            // 3

            //Move to presenter with this brand new information (questionType, Qleft, Qanswer, Qasked, Score, Case)
            TrueFalseOutputDataNew trueFalseOutputDataNew = new TrueFalseOutputDataNew(category, Qleft, questionAnswer, questionAsked,
                    score, 1, questionA, questions);

            truefalsePresenterNew.prepareFailView(trueFalseOutputDataNew); //Fail view will set up display for first question

        }
        else {
            // So player has initialized the game, time to answer them (THIS CASE WILL SUB 1 QUESTION)

            ArrayList<Question> questions = trueFalseInputDataNew.getQuestions();

            //Get user answer
            String userOutput = trueFalseInputDataNew.getAnswer();

            String gameOutput = trueFalseInputDataNew.getRealAnswer(); //As "True or False"

            if (userOutput.equals(gameOutput)){
                // They get more points


                // Build next question
                String category = trueFalseInputDataNew.getTypeQuestion(); // Get the question category
                //QuizAPI quizAPI = new QuizAPI(1, "easy", "boolean", category);

                int QleftI = Integer.parseInt(Qleft);

                String questionAnswer;
                String questionAsked;

                //System.out.println(currIndex);
                if(currIndex == questions.size()){

                    // Dummy input
                    questionAsked = questions.get(currIndex-1).getQuestion();
                    //Grab the first question answer
                    questionAnswer = questions.get(currIndex-1).getRightAnswer();


                }
                else {

                    // Grab the first question
                    //ArrayList<Question> questions = quizAPI.getQuestions();
                    questionAsked = questions.get(currIndex).getQuestion();
                    //Grab the first question answer
                    questionAnswer = questions.get(currIndex).getRightAnswer();
                    //System.out.println("Printed");

                }

                TrueFalseOutputDataNew trueFalseOutputDataNew = new TrueFalseOutputDataNew(category, Qleft, questionAnswer, questionAsked,
                        1, 2, questionA, questions); //case 2 is right answer

                truefalsePresenterNew.prepareSuccessView(trueFalseOutputDataNew);

            }
            else {
                // They dont get more points

                // Build next question
                String category = trueFalseInputDataNew.getTypeQuestion(); // Get the question category
                //System.out.println(category);
                //QuizAPI quizAPI = new QuizAPI(0, "easy", "boolean", category);

                // Grab the first question
                //ArrayList<Question> questions = quizAPI.getQuestions();

                int QleftI = Integer.parseInt(Qleft);

                String questionAsked;
                String questionAnswer;

                    //DUMMY GRAB
                    //System.out.println(currIndex);
                    if(currIndex == questions.size()){

                        // Dummy input
                        questionAsked = questions.get(currIndex-1).getQuestion();
                        //Grab the first question answer
                        questionAnswer = questions.get(currIndex-1).getRightAnswer();


                    }
                    else {

                        // Grab the first question
                        //ArrayList<Question> questions = quizAPI.getQuestions();
                        questionAsked = questions.get(currIndex).getQuestion();
                        //Grab the first question answer
                        questionAnswer = questions.get(currIndex).getRightAnswer();
                        //System.out.println("Printed");

                    }

                TrueFalseOutputDataNew trueFalseOutputDataNew = new TrueFalseOutputDataNew(category, Qleft, questionAnswer, questionAsked,
                        0, 3, questionA, questions); //Case 3 is wrong answer

                truefalsePresenterNew.prepareSuccessView(trueFalseOutputDataNew);


            }

        }


    }
}
