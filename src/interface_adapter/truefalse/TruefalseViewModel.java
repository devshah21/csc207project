package interface_adapter.truefalse;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TruefalseViewModel extends ViewModel {

    public static final String MULCHOICE_BUTTON_LABEL = "TRUE";

    public static final String TRUEFALSE_BUTTON_LABEL = "FALSE";

    private TruefalseState state = new TruefalseState();

    public TruefalseViewModel(){super("What type");}

    public void setState(TruefalseState state) { this.state = state; }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public TruefalseState getState() {return state;}
}
