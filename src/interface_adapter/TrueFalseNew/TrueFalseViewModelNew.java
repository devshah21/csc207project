package interface_adapter.TrueFalseNew;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TrueFalseViewModelNew extends ViewModel {

    public static final String TRUEN_BUTTON_LABEL = "True";

    public static final String FALSEN_BUTTON_LABEL = "False";

    private TrueFalseStateNew state = new TrueFalseStateNew();

    public TrueFalseViewModelNew(){super("TrueFalseNew");}

    public void setState(TrueFalseStateNew state){this.state = state;}

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public TrueFalseStateNew getState() {return state; }

}
