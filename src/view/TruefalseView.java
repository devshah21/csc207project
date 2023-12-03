package view;
import entity.APIException;
import entity.Question;
import interface_adapter.ViewManagerModel;
import interface_adapter.truefalse.TruefalseState;
import interface_adapter.truefalse.TruefalseViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;

import entity.QuizAPI;




public class TruefalseView extends JPanel implements ActionListener, PropertyChangeListener {

    // FORMAT THE BUTTONS AND LABELS HERE INTO SOMETHING THAT DOESNT LOOK LIKE TRASH PLEASE

    public TruefalseState tfstate;

    QuizAPI quizAPI = new QuizAPI(10, "easy", "boolean", "9");
    ArrayList<Question> questions = quizAPI.getQuestions();

    public final String trueFalse = "True";

    public final String mulChoice = "False";

    public final String viewName = "TRUEFALSE";

    // Some J stuff down here:

    private final JButton trueFalseB;

    private final JButton mulChoiceB;

    private final TruefalseViewModel truefalseViewModel;

    private final ViewManagerModel viewManagerModel;

    private final JLabel selectTypeErrorField = new JLabel();

    public TruefalseView(TruefalseViewModel truefalseViewModel, ViewManagerModel viewManagerModel ) throws APIException, IOException, InterruptedException {

        //this.selectTypeController = selectTypeController;
        this.truefalseViewModel = truefalseViewModel;
        this.truefalseViewModel.addPropertyChangeListener(this);
        this.viewManagerModel = viewManagerModel;
        // Top label
        JLabel title;
        title = new JLabel(questions.get(0).getQuestion());
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Button setups
        JPanel buttons = new JPanel();
        mulChoiceB = new JButton(truefalseViewModel.MULCHOICE_BUTTON_LABEL);
        buttons.add(mulChoiceB);

        trueFalseB = new JButton(truefalseViewModel.TRUEFALSE_BUTTON_LABEL);
        buttons.add(trueFalseB);

        // Controller calls

        mulChoiceB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(mulChoiceB)) {

                    // This should keep our latest one from collectQuestionsPresenter

                    TruefalseState truefalseState = truefalseViewModel.getState();
                }
            }
        });

        trueFalseB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(trueFalseB)) {

                    TruefalseState truefalseState = truefalseViewModel.getState();
                }
            }
        });

        // THIS WILL FORM THE BASIC DUMMY GUI
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(selectTypeErrorField);
        this.add(buttons);

    }

    public TruefalseView(JButton trueFalseB, JButton mulChoiceB, TruefalseViewModel truefalseViewModel, ViewManagerModel viewManagerModel) throws APIException, IOException, InterruptedException {
        this.trueFalseB = trueFalseB;
        this.mulChoiceB = mulChoiceB;
        this.truefalseViewModel = truefalseViewModel;
        this.viewManagerModel = viewManagerModel;
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
