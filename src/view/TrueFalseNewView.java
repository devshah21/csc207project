package view;

import entity.APIException;
import interface_adapter.Collect_Questions.CollectQuestionsState;
import interface_adapter.TrueFalseNew.TrueFalseControllerNew;
import interface_adapter.TrueFalseNew.TrueFalseStateNew;
import interface_adapter.TrueFalseNew.TrueFalseViewModelNew;
import interface_adapter.truefalse.TruefalseState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;

public class TrueFalseNewView extends JPanel implements ActionListener, PropertyChangeListener {


    public final String trueBut = "True";

    public final String falseBut = "False";
    public static final String viewName = "TrueFalseNew";

    private Color background = new Color(57,54,70);
    private Color textColor = new Color(244, 238, 224);

    private final TrueFalseControllerNew trueFalseControllerNew;

    private final TrueFalseViewModelNew trueFalseViewModelNew;

    private final JButton trueB;

    private final JButton falseB;

    private final JLabel trueErrorField = new JLabel();

    private final JLabel falseErrorField = new JLabel();



    public TrueFalseNewView(TrueFalseViewModelNew trueFalseViewModelNew, TrueFalseControllerNew controller) {
        this.setLayout(null);
        this.setBackground(background);
        this.trueFalseViewModelNew = trueFalseViewModelNew;
        this.trueFalseControllerNew = controller;
        this.trueFalseViewModelNew.addPropertyChangeListener(this);



        // THIS LABEL WILL DISPLAY THE QUESTION
        TrueFalseStateNew trueFalseStateNew = trueFalseViewModelNew.getState();
        String qAsked = trueFalseStateNew.getQuestionAsked();

        JLabel questionA = new JLabel(qAsked);
        questionA.setAlignmentX(Component.LEFT_ALIGNMENT);
        questionA.setForeground(textColor);
        questionA.setFont(new Font("Arial",Font.BOLD,15));
        trueB = new JButton(trueFalseViewModelNew.TRUEN_BUTTON_LABEL);


        falseB = new JButton(trueFalseViewModelNew.FALSEN_BUTTON_LABEL);


        JLabel temp = new JLabel("Please hit any button to start!");
        temp.setForeground(textColor);
        temp.setFont(new Font("Arial",Font.BOLD,20));

        // AS SEEN IN LECTURE THIS WILL INVOKE OUR CONTROLLER
        // To invoke our controller
        trueB.addActionListener(                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(trueB)) {
                            temp.setVisible(false);
                            String tAns = "true";

                            TrueFalseStateNew trueFalseStateNew = trueFalseViewModelNew.getState();

                            Boolean isFirstDone = trueFalseStateNew.isFirstDone(); // Tell us if to initialize or not
                            String Qleft = trueFalseStateNew.getTotalQ(); // So we will grab one question at a time this is 0

                            String typeQuestion = trueFalseStateNew.getTypeQuestion();
                            String realAnswer = trueFalseStateNew.getQuestionAnswer();
                            ArrayList questions = trueFalseStateNew.getQuestions();
                            int currIndex = trueFalseStateNew.getBackupTotQ();
                            // This will invoke the controller
                            try {
                                trueFalseControllerNew.execute("True", isFirstDone, Qleft, typeQuestion, questionA, realAnswer, questions, currIndex);
                            } catch (APIException e) {
                                throw new RuntimeException(e);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
        );


        falseB.addActionListener(                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(falseB)) {
                            temp.setVisible(false);
                            String fAns = "false";

                            TrueFalseStateNew trueFalseStateNew = trueFalseViewModelNew.getState();

                            Boolean isFirstDone = trueFalseStateNew.isFirstDone(); // Tell us if to initialize or not
                            String Qleft = trueFalseStateNew.getTotalQ(); // So we will grab one question at a time this is 0

                            String typeQuestion = trueFalseStateNew.getTypeQuestion();
                            String realAnswer = trueFalseStateNew.getQuestionAnswer();
                            ArrayList questions = trueFalseStateNew.getQuestions();
                            int currIndex = trueFalseStateNew.getBackupTotQ();
                            // This will invoke the controller
                            try {
                                trueFalseControllerNew.execute("False", isFirstDone, Qleft, typeQuestion, questionA, realAnswer, questions, currIndex);
                            } catch (APIException e) {
                                throw new RuntimeException(e);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
        );


        trueB.setBounds(300,300,200,50);
        falseB.setBounds(525,300,200,50);
        questionA.setBounds(364,100,800,100);
        temp.setBounds(364,100,500,100);

        // Set up GUI
        this.add(questionA);
        this.add(trueErrorField);
        this.add(falseErrorField);
        this.add(trueB);
        this.add(falseB);
        this.add(temp);



    }


    @Override
    public void actionPerformed(ActionEvent evt) {



    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        TrueFalseStateNew state = (TrueFalseStateNew) evt.getNewValue();
        trueErrorField.setText(state.getTrueErrorFeild());

    }
}
