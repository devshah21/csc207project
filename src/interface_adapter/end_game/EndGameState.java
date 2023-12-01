package interface_adapter.end_game;

public class EndGameState {

    private String userOutput = "";
    private String leaderBoardOut = "";

    public EndGameState(EndGameState copy){userOutput = copy.userOutput;
    leaderBoardOut = copy.leaderBoardOut;}

    public EndGameState() {}

    public String getOutput(){return userOutput;}

    public String getOutputLBoard(){return leaderBoardOut;}

    public void setOutput(String input){this.userOutput = input;}

    public void setOutputLB(String input){this.leaderBoardOut = input;}
}
