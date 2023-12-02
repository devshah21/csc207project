package interface_adapter.end_game;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class EndGameViewModel extends ViewModel {

    public static final String REPLAY_BUTTON_LABEL = "New Game";
    public static final String EXIT_BUTTON_LABEL = "Exit";

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
