package interface_adapter.Collect_Questions;

import interface_adapter.login.LoginState;
import interface_adapter.signup.SignupState;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInputData;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CollectQuestionsViewModel extends ViewModel {

    public static final String ENTER_BUTTON_LABEL = "Enter";

    private CollectQuestionsState state = new CollectQuestionsState();

    public CollectQuestionsViewModel() {
        super("Collect Questions");
    }

    public void setState(CollectQuestionsState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Signup Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state); //Create CollectQestionsState to fix this
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public CollectQuestionsState getState() {
        return state;
    }
}
