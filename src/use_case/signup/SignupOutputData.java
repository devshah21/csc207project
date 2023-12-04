package use_case.signup;

public class SignupOutputData {

    private final String username;
    private int score;

    private boolean useCaseFailed;

    public SignupOutputData(String username, int score, boolean useCaseFailed) {
        this.username = username;
        this.score = score;
        this.useCaseFailed = useCaseFailed;
    }

    public String getUsername() {
        return username;
    }

    public int getScore() {
        return score;
    }

    public void setScore() {
        this.score = 0;
    }

}
