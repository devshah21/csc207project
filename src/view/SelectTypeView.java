package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.select_type.SelectTypeViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SelectTypeView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "Select Type";

    private final SelectTypeViewModel selectTypeViewModel;

    private final JButton mcqButton;
    private final JButton tfButton;

    private Color background = new Color(57, 54, 70);
    private Color textColor = new Color(244, 238, 224);

    public SelectTypeView(SelectTypeViewModel selectTypeViewModel, ViewManagerModel viewManagerModel) {
        this.selectTypeViewModel = selectTypeViewModel;
        this.selectTypeViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("What type of game do you want to play?");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(textColor);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        mcqButton = new JButton("Multiple Choice");
        mcqButton.setFont(new Font("Arial", Font.BOLD, 18));
        mcqButton.addActionListener(this);
        mcqButton.setPreferredSize(new Dimension(180, 60));

        tfButton = new JButton("True/False");
        tfButton.setFont(new Font("Arial", Font.BOLD, 18));
        tfButton.addActionListener(this);
        tfButton.setPreferredSize(new Dimension(180, 60));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(background);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(mcqButton);
        buttonPanel.add(Box.createHorizontalStrut(20));
        buttonPanel.add(tfButton);
        buttonPanel.add(Box.createHorizontalGlue());

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(background);
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(Box.createVerticalStrut(20));
        this.add(buttonPanel);
        this.add(Box.createVerticalGlue());
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == mcqButton) {
            // Handle multiple choice button click
            System.out.println("Multiple Choice selected");
        } else if (evt.getSource() == tfButton) {
            // Handle true/false button click
            System.out.println("True/False selected");
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // Handle property changes if needed
    }
}
