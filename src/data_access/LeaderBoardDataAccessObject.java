package data_access;

import entity.User;

import java.io.*;


public class LeaderBoardDataAccessObject {

    // This class can be started up, but to generate a new top 10 for each it needs a new input, which it will always get

    // Thus class will return an array which contains two strings containing both leaderboards

    private final File csvFile;

    private String FirstLn = "Leaderboard File";
    public LeaderBoardDataAccessObject(String csvPath){

        csvFile = new File(csvPath);

        // If the CSV file is empty, create a fresh file for work.
        if (csvFile.length() == 0) {

            BufferedWriter writer;
            try {
                writer = new BufferedWriter(new FileWriter(csvFile));
                writer.write(FirstLn);
                writer.newLine();
                writer.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else {
            // Do nothing your work is done here
        }

    }


    // This case is to run within a interactor, it will take the username of the player, their score, the number of questions they had
    // and the type of game they played, and ethier add them to leaderboard or not, in the end two strings with both leaderboards will be
    // outputed
    public String[] generateLeaderBoards(String username, int score, String numQuestions, String gameType, String questionType ){

        String mulChoiceLeaders = "";
        String trueOrFalseLeaders = "";

        int mulQDone = 0;
        int tfQDone = 0;

        BufferedReader fr;
        try {

            fr = new BufferedReader(new java.io.FileReader(csvFile));

            boolean isAdded = false; // When this fires we know that our values has been added so we can just focus on creating the output string

            String currLine;
            String nextLine;
            String oldLeader = "";
            String newLeader = "";
            String oldLines = ""; //Holds old lines as we look
            String[] leaderParts;

            // This is just the intro line

            currLine = fr.readLine();
            oldLines = oldLines + currLine + System.lineSeparator(); //Adds it to what we might need to write back
            currLine = fr.readLine(); //Reads first line
            //System.out.println(currLine);


            while(currLine != null){

                oldLines = oldLines + currLine + System.lineSeparator(); //Adds it to what we might need to write back
                leaderParts = currLine.split(",");

                nextLine = fr.readLine();//Reads next line
                // Now we have an array leader parts

                // First check if the game type is the same as the line just read (and we havent found anything yet)
                if (leaderParts[3].equals(gameType)){
                    int tempHigh = Integer.parseInt(leaderParts[1]);
                    // Next check if our player has a better score than them
                    if (tempHigh < score){
                        // It is, so hold onto this old line and new line
                        oldLeader = currLine;


                        //Check if this was final line to add
                        if(nextLine == null){
                            //System.out.println("hi2");
                            newLeader = username +","+ String.valueOf(score) +","+ numQuestions +","+ gameType +","+ questionType;
                            oldLines = oldLines.replaceAll(oldLeader, newLeader); // Now the new line has taken its place


                        }
                        else{
                            //System.out.println("hi1");
                            newLeader = username +","+ String.valueOf(score) +","+ numQuestions +","+ gameType +","+ questionType;
                            oldLines = oldLines.replaceAll(oldLeader, newLeader); // Now the new line has taken its place
                            //System.out.println(newLeader);
                        }


                        //Next add another line to the output String
                        if (gameType.equals("trueOrFalse")){
                            tfQDone = tfQDone + 1;
                            trueOrFalseLeaders = trueOrFalseLeaders + tfQDone + ". " + username + ": "+ score + " : " + "In " + numQuestions
                                    + " questions: " + questionType + "\n";
                        }else {
                            mulQDone = mulQDone + 1;
                            mulChoiceLeaders = mulChoiceLeaders + mulQDone + ". " + username + ": "+ score + " : " + "In " + numQuestions
                                    + " questions: " + questionType + "\n";

                        }

                        //Now our current item to compare with will be our oldLeader, so
                        username = leaderParts[0];
                        score = Integer.parseInt(leaderParts[1]);
                        numQuestions = leaderParts[2];
                        gameType = leaderParts[3];
                        questionType = leaderParts[4];
                    }
                    // Its not so add the line to out final string
                    else if (leaderParts[3].equals("trueOrFalse")){
                        tfQDone = tfQDone + 1;
                        trueOrFalseLeaders = trueOrFalseLeaders + tfQDone + ". " + leaderParts[0] + ": "+ leaderParts[1] + " : " + "In " + leaderParts[2]
                                + " questions: " + leaderParts[4] + "\n";
                    }else {
                        mulQDone = mulQDone + 1;
                        mulChoiceLeaders = mulChoiceLeaders + mulQDone + ". " + leaderParts[0] + ": "+ leaderParts[1] + " : " + "In " + leaderParts[2]
                                + " questions: " + leaderParts[4] + "\n";

                    }
                }
                // If the type is different just add the curr stuff, onto our display and keep moving
                else{

                    // Its not so add the line to out final string
                    if (leaderParts[3].equals("trueOrFalse")){
                        tfQDone = tfQDone + 1;
                        trueOrFalseLeaders = trueOrFalseLeaders + tfQDone + ". " + leaderParts[0] + ": "+ leaderParts[1] + " : " + "In " + leaderParts[2]
                                + " questions: " + leaderParts[4] + "\n";
                    }else {
                        mulQDone = mulQDone + 1;
                        mulChoiceLeaders = mulChoiceLeaders + mulQDone + ". " + leaderParts[0] + ": "+ leaderParts[1] + " : " + "In " + leaderParts[2]
                                + " questions: " + leaderParts[4] + "\n";

                    }

                }
                currLine = nextLine;
            }
            fr.close();
            boolean firstOne = false;
            // If either are not 0 then fill the rest with
            if (tfQDone < 10){

                while (tfQDone != 10){

                    tfQDone = tfQDone + 1;

                    if (!firstOne && gameType.equals("trueOrFalse")){
                        //System.out.println("incorrect");
                        trueOrFalseLeaders = trueOrFalseLeaders + tfQDone + ". " + username + ": "+ score + " : " + "In " + numQuestions
                                + " questions: " + questionType + "\n";

                        newLeader = username +","+ String.valueOf(score) +","+ numQuestions + ","+ gameType +","+ questionType;
                        oldLines = oldLines + newLeader;
                        firstOne = true;

                    }
                    else {
                        trueOrFalseLeaders = trueOrFalseLeaders + tfQDone + ". " + "\n";
                    }

                }
            }
            if (mulQDone < 10){

                while (mulQDone != 10){
                    mulQDone = mulQDone + 1;
                    if (!firstOne && !gameType.equals("trueOrFalse")){
                        //System.out.println("correct");
                        mulChoiceLeaders = mulChoiceLeaders + mulQDone + ". " + username + ": "+ score + " : " + "In " + numQuestions
                                + " questions: " + questionType + "\n";

                        newLeader = username +","+ String.valueOf(score) +","+ numQuestions +","+ gameType +","+ questionType;
                        oldLines = oldLines + newLeader;
                        firstOne = true;

                    }else{
                        mulChoiceLeaders = mulChoiceLeaders + mulQDone + ". " + "\n";
                    }

                }
            }

            // Now finally write in the new file created
            FileWriter wr = new FileWriter(csvFile);

            wr.write(oldLines);

            fr.close();
            wr.close();

            //System.out.println(trueOrFalseLeaders);
            //System.out.println(mulChoiceLeaders);

            String[] output = {trueOrFalseLeaders, mulChoiceLeaders };
            return output ;

        }catch (IOException e) {
            throw new RuntimeException(e);
        }




    }


}


