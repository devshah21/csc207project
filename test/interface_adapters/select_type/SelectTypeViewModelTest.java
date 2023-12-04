package interface_adapters.select_type;


import interface_adapter.select_type.SelectTypeState;
import interface_adapter.select_type.SelectTypeViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelectTypeViewModelTest {

    private SelectTypeViewModel selectTypeViewModel;
    private SelectTypeState testState;

    @BeforeEach
    public void setUp() {
        selectTypeViewModel = new SelectTypeViewModel();
        testState = new SelectTypeState();
    }

    @Test
    public void testSetState() {
        selectTypeViewModel.setState(testState);
        assertEquals(testState, selectTypeViewModel.getState());
    }

    @Test
    public void testFirePropertyChanged() {
        PropertyChangeListener listener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                assertEquals("state", evt.getPropertyName());
                assertEquals(testState, evt.getNewValue());
            }
        };
        selectTypeViewModel.addPropertyChangeListener(listener);
        selectTypeViewModel.setState(testState);
        selectTypeViewModel.firePropertyChanged();
    }
}

