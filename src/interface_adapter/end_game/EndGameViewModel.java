package interface_adapter.end_game;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class EndGameViewModel extends ViewModel {

    public static final String RESULTS_LABEL = "Results";
    public static final String REPLAY_BUTTON_LABEL = "New Game";
    public static final String EXIT_BUTTON_LABEL = "Exit";
    public static final String USER_RESULT_LABEL = "Your Score";
    public static final String TITLE = "Results";
    public static String MCQ_LEADERBOARD_LABEL = "Top Multiple Choice Scores";

    public static String TF_LEADERBOARD_LAVEL = "Top True/False Scores";

    private EndGameState state = new EndGameState();

    public EndGameViewModel(){super("End game");}


    public void setState(EndGameState state){this.state = state;}

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public EndGameState getState() {return state;}
}
