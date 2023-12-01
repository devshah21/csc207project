package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.select_type.SelectTypeState;
import interface_adapter.select_type.SelectTypeViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SelectTypeView extends JPanel implements ActionListener, PropertyChangeListener {

    // FORMAT THE BUTTONS AND LABELS HERE INTO SOMETHING THAT DOESNT LOOK LIKE TRASH PLEASE

    public final String trueFalse = "True or False";

    public final String mulChoice = "True or False";

    public final String viewName = "What type";

    // Some J stuff down here:
    private final JButton trueFalseB;

    private final JButton mulChoiceB;

    private final SelectTypeViewModel selectTypeViewModel;

    //private final SelectTypeController selectTypeController;

    private final ViewManagerModel viewManagerModel;

    private final JLabel selectTypeErrorField = new JLabel();

    public SelectTypeView(SelectTypeViewModel selectTypeViewModel, ViewManagerModel viewManagerModel ){

        //this.selectTypeController = selectTypeController;
        this.selectTypeViewModel = selectTypeViewModel;
        this.selectTypeViewModel.addPropertyChangeListener(this);
        this.viewManagerModel = viewManagerModel;
        // Top label
        JLabel title = new JLabel("What type of game do you want to play?");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Button setups
        JPanel buttons = new JPanel();
        mulChoiceB = new JButton(selectTypeViewModel.MULCHOICE_BUTTON_LABEL);
        buttons.add(mulChoiceB);

        trueFalseB = new JButton(selectTypeViewModel.TRUEFALSE_BUTTON_LABEL);
        buttons.add(trueFalseB);

        // Controller calls

        mulChoiceB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(mulChoiceB)) {

                    SelectTypeState selectTypeState = new SelectTypeState();

                    String totQ1 = selectTypeState.getTotalQ();

                    System.out.println(totQ1 +" Place Holder2");
                    //ALSO ADD PART TO SET VALUE IN NEXT USECASE'S STATE

                    // ADD THE NEXT VIEW MODEL HERE
                    //viewManagerModel.setActiveView(######.getViewName());
                    //viewManagerModel.firePropertyChanged();
                }
            }
        });

        trueFalseB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(trueFalseB)) {

                    SelectTypeState selectTypeState = new SelectTypeState();
                    String totQ2 = selectTypeState.getTotalQ();

                    System.out.println(totQ2 + "Place Holder1");
                    //ALSO ADD PART TO SET VALUE IN NEXT USECASE'S STATE

                    // ADD THE NEXT VIEW MODEL HERE
                    //viewManagerModel.setActiveView(######.getViewName());
                    //viewManagerModel.firePropertyChanged();
                }
            }
        });

        // THIS WILL FORM THE BASIC DUMMY GUI
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(selectTypeErrorField);
        this.add(buttons);

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }



    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        //SHOULDN'T DO ANYTHING SINCE WE WILL NEVER HAVE TO GO INTO THIS USE CASE  (At least I think so)
    }
}
