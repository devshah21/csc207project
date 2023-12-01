package view;

import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupViewModel;



import interface_adapter.Collect_Questions.CollectQuestionsViewModel;
import interface_adapter.Collect_Questions.CollectQuestionsState;
import interface_adapter.Collect_Questions.CollectQuestionsController;
// Need controller next


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CollectQuestionsView extends JPanel implements ActionListener, PropertyChangeListener {


    public final String enterNum = "Enter";

    public final String viewName = "Collect Questions";
    private final JTextField questionNumberInputField = new JTextField(15);

    private final CollectQuestionsController collectQuestionsController;

    private final CollectQuestionsViewModel collectQuestionsViewModel;

    private final JButton enter;

    private final JLabel totalQErrorField = new JLabel();


    public CollectQuestionsView(CollectQuestionsViewModel collectQuestionsViewModel, CollectQuestionsController controller) {

        this.collectQuestionsController = controller;
        this.collectQuestionsViewModel = collectQuestionsViewModel;
        this.collectQuestionsViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Input number of questions");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel totalQInfo = new LabelTextPanel(
                new JLabel("Questions"), questionNumberInputField);

        JPanel buttons = new JPanel();
        enter = new JButton(collectQuestionsViewModel.ENTER_BUTTON_LABEL);
        buttons.add(enter);

        // AS SEEN IN LECTURE THIS WILL INVOKE OUR CONTROLLER
        // To invoke our controller
        enter.addActionListener(                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(enter)) {
                            CollectQuestionsState currentState = collectQuestionsViewModel.getState();

                            // This will invoke the controller
                            collectQuestionsController.execute(
                                    currentState.getTotalQ()
                            );
                        }
                    }
                }
        );


        questionNumberInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                CollectQuestionsState currentState = collectQuestionsViewModel.getState();
                currentState.setTotalQ(questionNumberInputField.getText() + e.getKeyChar());
                collectQuestionsViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        // Set up GUI
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(totalQInfo);
        this.add(totalQErrorField);
        this.add(buttons);

    }

    // DONT 100% UNDERSTAND WHAT THESES WILL DO, OR HOW THEY WILL HELP RESET IF A FAIL HAPPENS
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        //System.out.println(evt.getPropertyName());

        CollectQuestionsState state = (CollectQuestionsState) evt.getNewValue();
        setFields(state);

    }

    private void setFields(CollectQuestionsState state) {
        questionNumberInputField.setText(state.getTotalQ());
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }
}


