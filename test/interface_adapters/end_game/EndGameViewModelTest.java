package interface_adapters.end_game;


import interface_adapter.ViewModel;
import interface_adapter.end_game.EndGameState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


import interface_adapter.end_game.EndGameViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EndGameViewModelTest {

    private EndGameViewModel endGameViewModel;
    private EndGameState endGameState;

    @BeforeEach
    public void setUp() {
        endGameViewModel = new EndGameViewModel();
        endGameState = new EndGameState();
    }

    @Test
    public void testState() {
        endGameViewModel.setState(endGameState);
        assertEquals(endGameState, endGameViewModel.getState());
    }

    @Test
    public void testPropertyChange() {
        PropertyChangeListener listener = new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                assertEquals("state", evt.getPropertyName());
                assertEquals(endGameState, evt.getNewValue());
            }
        };
        endGameViewModel.addPropertyChangeListener(listener);
        endGameViewModel.setState(endGameState);
        endGameViewModel.firePropertyChanged();
    }
}


