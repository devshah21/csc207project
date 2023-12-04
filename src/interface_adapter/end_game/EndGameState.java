package interface_adapter.end_game;

public class EndGameState {

    private String userOutput = ""; // Will hold user output string
    private String leaderBoardTF = ""; // Will hold leaderboard for true or false

    private String leaderBoardMul = ""; // Will hold leaderboard for multiple choice

    private String username = ""; // Will hold username string

    public EndGameState(EndGameState copy){userOutput = copy.userOutput;
    leaderBoardTF = copy.leaderBoardTF;
    leaderBoardMul = copy.leaderBoardMul;
    username = copy.username;
    }

    public EndGameState() {}

    public String getOutput(){return userOutput;}

    public void setOutput(String input){this.userOutput = input;}

    public String getLBTF(){return leaderBoardTF;}

    public void setLBTF(String input){this.leaderBoardTF = input;}

    public String getLBMul(){return leaderBoardMul;}

    public void setLBMul(String input){this.leaderBoardMul = input;}

    public String getUsername(){return username;}

    public void setUsername(String input){this.username = input;}
}
