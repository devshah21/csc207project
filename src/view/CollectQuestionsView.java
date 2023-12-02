package view;

import interface_adapter.Collect_Questions.CollectQuestionsController;
import interface_adapter.Collect_Questions.CollectQuestionsState;
import interface_adapter.Collect_Questions.CollectQuestionsViewModel;

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

    private final Color background = new Color(57, 54, 70);
    private final Color textColor = new Color(244, 238, 224);

    public CollectQuestionsView(CollectQuestionsViewModel collectQuestionsViewModel, CollectQuestionsController controller) {

        this.collectQuestionsController = controller;
        this.collectQuestionsViewModel = collectQuestionsViewModel;
        this.collectQuestionsViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Input number of questions");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(textColor);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel totalQInfo = new JPanel();
        totalQInfo.setBackground(background);
        totalQInfo.setLayout(new BoxLayout(totalQInfo, BoxLayout.Y_AXIS));

        JPanel inputPanel = new JPanel();
        JLabel questions = new JLabel("Questions");
        inputPanel.setBackground(background);
        inputPanel.add(questions);
        inputPanel.add(Box.createRigidArea(new Dimension(10, 0)));  // Add a small gap between the label and input field
        inputPanel.add(questionNumberInputField);

        totalQInfo.add(inputPanel);

        JPanel buttons = new JPanel();
        buttons.setBackground(background);
        buttons.setAlignmentX(Component.CENTER_ALIGNMENT);
        enter = new JButton(collectQuestionsViewModel.ENTER_BUTTON_LABEL);
        enter.setFont(new Font("Arial", Font.BOLD, 18));
        enter.addActionListener(evt -> {
            if (evt.getSource().equals(enter)) {
                CollectQuestionsState currentState = collectQuestionsViewModel.getState();
                collectQuestionsController.execute(
                        currentState.getTotalQ(),
                        currentState.getUsername()
                );
            }
        });
        buttons.add(enter);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(background);
        this.add(title);
        this.add(totalQInfo);
        this.add(totalQErrorField);
        this.add(buttons);

        questionNumberInputField.setForeground(textColor);
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
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
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
