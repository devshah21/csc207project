package interface_adapter.select_type;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SelectTypeViewModel extends ViewModel {

    public static final String MULCHOICE_BUTTON_LABEL = "Multiple Choice";

    public static final String TRUEFALSE_BUTTON_LABEL = "True or False";

    private SelectTypeState state = new SelectTypeState();

    public SelectTypeViewModel(){super("What type");}

    public void setState(SelectTypeState state) {

        this.state = state;

    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public SelectTypeState getState() {return state;}
}
