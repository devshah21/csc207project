package view;

import interface_adapter.Collect_Questions.CollectQuestionsState;
import interface_adapter.TrueFalseNew.TrueFalseControllerNew;
import interface_adapter.truefalse.TruefalseState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TrueFalseNewView extends JPanel implements ActionListener, PropertyChangeListener {


    public final String trueBut = "True";

    public final String falseBut = "False";
    public static final String viewName = "TrueFalseNew";


    private final TrueFalseControllerNew trueFalseControllerNew;

    private final TrueFalseViewModelNew trueFalseViewModelNew;

    private final JButton trueB;

    private final JButton falseB;

    private final JLabel trueErrorField = new JLabel();

    private final JLabel falseErrorField = new JLabel();

    public TrueFalseNewView(TrueFalseViewModelNew trueFalseViewModelNew, TrueFalseControllerNew controller) {


        this.trueFalseViewModelNew = trueFalseViewModelNew;
        this.trueFalseControllerNew = controller;
        this.trueFalseViewModelNew.addPropertyChangeListener(this);



        // THIS LABEL WILL DISPLAY THE QUESTION
        JLabel question = new JLabel("True or False questions");
        question.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        trueB = new JButton(trueFalseViewModelNew.TRUEN_BUTTON_LABEL);
        buttons.add(trueB);

        falseB = new JButton(trueFalseViewModelNew.FALSEN_BUTTON_LABEL);
        buttons.add(falseB);


        // AS SEEN IN LECTURE THIS WILL INVOKE OUR CONTROLLER
        // To invoke our controller
        trueB.addActionListener(                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(trueB)) {

                            String tAns = "true";

                            // This will invoke the controller
                            trueFalseControllerNew.execute(
                                    "true"
                            );
                        }
                    }
                }
        );


        falseB.addActionListener(                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(falseB)) {

                            String fAns = "false";

                            // This will invoke the controller
                            trueFalseControllerNew.execute(
                                    "false"
                            );
                        }
                    }
                }
        );

        // Set up GUI
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(question);
        this.add(trueErrorField);
        this.add(falseErrorField);
        this.add(buttons);



    }


    @Override
    public void actionPerformed(ActionEvent evt) {

        System.out.println("Click " + evt.getActionCommand());


    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        TruefalseState state = (TruefalseState) evt.getNewValue();
        trueErrorField.setText(state.getTrueErrorValue);

    }
}
