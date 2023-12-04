package use_case.truefalseNew;


import entity.APIException;
import entity.Question;
import entity.QuizAPI;

import java.util.ArrayList;
import java.util.Random;
import interface_adapter.TrueFalseNew.TrueFalseStateNew;
import interface_adapter.TrueFalseNew.TrueFalseViewModelNew;

import java.io.IOException;

public class TrueFalseInteractorNew implements TrueFalseInputBoundaryNew {

    final TrueFalseOutputBoundaryNew truefalsePresenterNew;

    public TrueFalseInteractorNew (TrueFalseOutputBoundaryNew trueFalseOutputBoundaryNew){

        this.truefalsePresenterNew = trueFalseOutputBoundaryNew;

    }



    @Override
    public void execute(TrueFalseInputDataNew trueFalseInputDataNew) throws APIException, IOException, InterruptedException {


        // THIS CODE WILL SEND A NUMBER TO PRESENTER FROM 1 TO 3 INDICATING WHAT CASE IT IS 1: START, 2: REG QUESTION 3: END

        // If this is the first run then the state number will be unchanged from the start

        // So take inputs from start at the view level not now

        // Data will give us questions left, isfirstuse done, and the output of the user from button use there


        // First make case for if this is the very first run
        Boolean isFirst = trueFalseInputDataNew.getIsFirstDone();
        String Qleft = trueFalseInputDataNew.getQleft();
        int score = 0; // Make this functional
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

            //Run the first call of the API function

            QuizAPI quizAPI = new QuizAPI(1, "easy", "boolean", category);

            // Grab the first question
            ArrayList<Question> questions = quizAPI.getQuestions();
            String questionAsked = questions.get(0).getQuestion();

            //Grab the first question answer
            String questionAnswer = questions.get(0).getRightAnswer();

            //Set isFirst to True in presenter

            //Move to presenter with this brand new information (questionType, Qleft, Qanswer, Qasked, Score, Case)
            TrueFalseOutputDataNew trueFalseOutputDataNew = new TrueFalseOutputDataNew(category, Qleft, questionAnswer, questionAsked,
                    score, 1);

            truefalsePresenterNew.prepareFailView(trueFalseOutputDataNew); //Fail view will set up display for first question

        }



    }
}
