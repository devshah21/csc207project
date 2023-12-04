package view;

import interface_adapter.TrueFalseNew.TrueFalseStateNew;
import interface_adapter.TrueFalseNew.TrueFalseViewModelNew;
import interface_adapter.ViewManagerModel;
import interface_adapter.select_type.SelectTypeViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import interface_adapter.select_type.SelectTypeState;
public class SelectTypeView extends JPanel implements ActionListener, PropertyChangeListener {

// FORMAT THE BUTTONS AND LABELS HERE INTO SOMETHING THAT DOESNT LOOK LIKE TRASH PLEASE

    public final String trueFalse = "True or False";

    public final String mulChoice = "True or False";

    public static final String viewName = "What type";

    // Some J stuff down here:
    private final JButton trueFalseB;

    private final JButton mulChoiceB;

    private final SelectTypeViewModel selectTypeViewModel;

//private final SelectTypeController selectTypeController;

    private final ViewManagerModel viewManagerModel;

    private final TrueFalseViewModelNew trueFalseViewModelNew;

    private final JLabel selectTypeErrorField = new JLabel();

    private Color background = new Color(57, 54, 70);
    private Color textColor = new Color(244, 238, 224);

    public SelectTypeView(SelectTypeViewModel selectTypeViewModel,TrueFalseViewModelNew trueFalseViewModelNew, ViewManagerModel viewManagerModel ){

        //this.selectTypeController = selectTypeController;
        this.selectTypeViewModel = selectTypeViewModel;
        this.selectTypeViewModel.addPropertyChangeListener(this);
        this.viewManagerModel = viewManagerModel;
        this.trueFalseViewModelNew = trueFalseViewModelNew;
// Top label
        JLabel title = new JLabel("What type of game do you want to play?");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(textColor);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

// Button setups
        mulChoiceB = new JButton("Multiple Choice");
        mulChoiceB.setFont(new Font("Arial", Font.BOLD, 18));
        mulChoiceB.addActionListener(this);
        mulChoiceB.setPreferredSize(new Dimension(180, 60));

        trueFalseB = new JButton("True/False");
        trueFalseB.setFont(new Font("Arial", Font.BOLD, 18));
        trueFalseB.addActionListener(this);
        trueFalseB.setPreferredSize(new Dimension(180, 60));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(background);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(mulChoiceB);
        buttonPanel.add(Box.createHorizontalStrut(20));
        buttonPanel.add(trueFalseB);
        buttonPanel.add(Box.createHorizontalGlue());

// Controller calls

        mulChoiceB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(mulChoiceB)) {

                    // This should keep our latest one from collectQuestionsPresenter

                    SelectTypeState selectTypeState = selectTypeViewModel.getState();
                    String totQ1 = selectTypeState.getTotalQ();
                    String user1 = selectTypeState.getUsername();

                    //System.out.println(totQ1 +" " +user1 + " Place Holder2");
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

                    SelectTypeState selectTypeState = selectTypeViewModel.getState();
                    String totQ2 = selectTypeState.getTotalQ();
                    String user2 = selectTypeState.getUsername();

                    //System.out.println(totQ2 +" "+ user2+ " Place Holder1");

                    TrueFalseStateNew trueFalseStateNew = trueFalseViewModelNew.getState();
                    trueFalseStateNew.setTotalQ(totQ2);
                    trueFalseStateNew.setUsername(user2);

                    trueFalseViewModelNew.setState(trueFalseStateNew);
                    trueFalseViewModelNew.firePropertyChanged();

                    //Next Case
                    viewManagerModel.setActiveView(trueFalseViewModelNew.getViewName());
                    viewManagerModel.firePropertyChanged();



//ALSO ADD PART TO SET VALUE IN NEXT USECASE'S STATE

                    // ADD THE NEXT VIEW MODEL HERE
                    //viewManagerModel.setActiveView(######.getViewName());
                    //viewManagerModel.firePropertyChanged();
                }
            }
        });

// THIS WILL FORM THE BASIC DUMMY GUI
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
        System.out.println("Click " + evt.getActionCommand());
    }



    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        //SHOULDN'T DO ANYTHING SINCE WE WILL NEVER HAVE TO GO INTO THIS USE CASE  (At least I think so)
    }
}
