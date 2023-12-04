package data_access;

import java.io.*;

public final class InformationStorageDAO {

    // Before every new write, this file should clean itself out


    private final File csvFile;

    private String username;

    private String score;

    private String questions;

    private String gameType;

    private String questionType;

    public InformationStorageDAO(String csvPath){

        csvFile = new File(csvPath);

        // If the CSV file is empty, create a fresh file for work.
        if (csvFile.length() == 0) {

            BufferedWriter writer;
            try {
                writer = new BufferedWriter(new FileWriter(csvFile));
                writer.write("Storage file, Games to EndGame");
                writer.newLine();
                writer.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else {
            // Do nothing your work is done here
        }
    }

    public void writeIntoFile(String username, String score, String questions, String gameType, String questionType) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile));

        writer.newLine();
        writer.write(username +","+score+","+questions+","+gameType+","+questionType);
        writer.newLine();
        writer.write(username+","+score);
        writer.close();

        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        reader.readLine();
        reader.readLine();
        reader.readLine();
        reader.close();

    }


    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

    public void setScore(String score) {
        this.score = score;
    }
    public String getScore() {
        return score;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }
    public String getQuestions() {
        return questions;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }
    public String getGameType() {
        return gameType;
    }

    public void setQuestionsType(String questionsType) {
        this.questionType = questionsType;
    }
    public String getQuestionsType() {
        return questionType;
    }






    public String[] getLeaderValues() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(csvFile));

        reader.readLine(); //Title

        String outW = "";
        String[] output = new String[]{("")};

        outW = reader.readLine();

        if(outW != null) {
            output = outW.split(",");
        }
        return output; //5 items

    }

    public String[] getHighScoreValues() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(csvFile));

        reader.readLine(); //Title
        reader.readLine(); //Leaderboard
        String outW = reader.readLine();
        String[] output = new String[]{("")};

        if(outW != null) {
             output = outW.split(","); //2 items
        }
        return output;

    }


}
