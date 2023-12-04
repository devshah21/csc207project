package view;
import entity.APIException;
import entity.Question;
import interface_adapter.ViewManagerModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;

import entity.QuizAPI;
import interface_adapter.truefalse.TruefalseState;
import interface_adapter.truefalse.TruefalseViewModel;


public class TruefalseView extends JPanel implements ActionListener, PropertyChangeListener {

    // FORMAT THE BUTTONS AND LABELS HERE INTO SOMETHING THAT DOESNT LOOK LIKE TRASH PLEASE



    public final String trueFalse = "True";

    public final String mulChoice = "False";

    public final String viewName = "TRUEFALSE";

    // Some J stuff down here:

    private final JButton trueFalseB;

    private int counter = 0;

    private final JButton mulChoiceB;

    private final TruefalseViewModel truefalseViewModel;

    private ViewManagerModel viewManagerModel;

    private final JLabel selectTypeErrorField = new JLabel();

    public TruefalseView(TruefalseViewModel truefalseViewModel, ViewManagerModel viewManagerModel ) throws APIException, IOException, InterruptedException {
        this.truefalseViewModel = truefalseViewModel;
        this.truefalseViewModel.addPropertyChangeListener(this);
        this.viewManagerModel = viewManagerModel;

        TruefalseState tfstate = truefalseViewModel.getState();

        int balls = tfstate.getQuestions();



        QuizAPI quizAPI = new QuizAPI(balls, "easy", "boolean", "9");

        ArrayList<Question> questions = quizAPI.getQuestions();



        // Top label
        JLabel title;
        title = new JLabel(questions.get(counter).getQuestion());
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Button setups
        JPanel buttons = new JPanel();
        mulChoiceB = new JButton(truefalseViewModel.MULCHOICE_BUTTON_LABEL);
        buttons.add(mulChoiceB);

        trueFalseB = new JButton(truefalseViewModel.TRUEFALSE_BUTTON_LABEL);
        buttons.add(trueFalseB);

        // Controller calls

        // Define a JLabel for the result message
        JLabel resultLabel = new JLabel();
        this.add(resultLabel);

        mulChoiceB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(mulChoiceB)) {
                    // Check if there are more questions
                    if (counter < questions.size() - 1) {
                        // Check if the user's answer is correct
                        if (questions.get(counter).getRightAnswer().equals("True")) {
                            resultLabel.setText("CORRECT");
                        } else {
                            resultLabel.setText("INCORRECT");
                        }
                        counter += 1;
                        // Update the text of the existing label
                        title.setText(questions.get(counter).getQuestion());
                    } else {
                        // Handle the end of the questions list
                        title.setText("No more questions.");
                        // Remove the buttons
                        buttons.remove(mulChoiceB);
                        buttons.remove(trueFalseB);
                        // Redraw the panel
                        buttons.revalidate();
                        buttons.repaint();
                    }
                }
            }
        });

        trueFalseB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(trueFalseB)) {
                    // Check if there are more questions
                    if (counter < questions.size() - 1) {
                        // Check if the user's answer is correct
                        if (questions.get(counter).getRightAnswer().equals("False")) {
                            resultLabel.setText("CORRECT");
                        } else {
                            resultLabel.setText("INCORRECT");
                        }
                        counter += 1;
                        // Update the text of the existing label
                        title.setText(questions.get(counter).getQuestion());
                    } else {
                        // Handle the end of the questions list
                        title.setText("No more questions.");
                        // Remove the buttons
                        buttons.remove(mulChoiceB);
                        buttons.remove(trueFalseB);
                        // Redraw the panel
                        buttons.revalidate();
                        buttons.repaint();
                    }
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
