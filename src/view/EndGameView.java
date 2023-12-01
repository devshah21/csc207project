package view;

import interface_adapter.Collect_Questions.CollectQuestionsState;
import interface_adapter.Collect_Questions.CollectQuestionsViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.end_game.EndGameState;
import interface_adapter.end_game.EndGameViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupViewModel;
import use_case.collect_questions.CollectQuestionInteractor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class EndGameView extends JPanel implements ActionListener, PropertyChangeListener {

   public final String viewName = "End game";

   private final EndGameViewModel endGameViewModel;

   //private final EndGameController endGameController;

   private final JButton replay;

   private final JButton exit;

   // Only button with use case linked to this

   //private final JButton leaderboards;

   private final JLabel totalQErrorField = new JLabel();

   JLabel userOutput;

   JLabel userOutputLB;

   public EndGameView(EndGameViewModel endGameViewModel, SignupViewModel signupViewModel,
                      CollectQuestionsViewModel collectQuestionsViewModel, ViewManagerModel viewManagerModel){


      //this.endGameController = controller;
      this.endGameViewModel = endGameViewModel;
      this.endGameViewModel.addPropertyChangeListener(this);

      JLabel title = new JLabel("Results");
      title.setAlignmentX(Component.CENTER_ALIGNMENT);

      // This is all to display the result grabbed from Devs useCase
      EndGameState endGameState = new EndGameState();
      String output = endGameState.getOutput();

      //Replace output with placeholder while updating GUI
      JLabel userOutput = new JLabel(output);
      userOutput.setAlignmentX(Component.LEFT_ALIGNMENT);

      //Extra, This is to display the string output generated by Dev's run of the leaderboard
      String outputLBoard = endGameState.getOutputLBoard();

      //Replace outputLBoard with placeholder while updating GUI
      JLabel userOutputLB = new JLabel(outputLBoard);
      userOutputLB.setAlignmentX(Component.LEFT_ALIGNMENT);

      JPanel buttons = new JPanel();
      replay = new JButton(EndGameViewModel.REPLAY_BUTTON_LABEL);
      buttons.add(replay);

      exit = new JButton(EndGameViewModel.EXIT_BUTTON_LABEL);
      buttons.add(exit);

      replay.addActionListener(                // Starts the game again
              new ActionListener() {
                 public void actionPerformed(ActionEvent evt) {
                    if (evt.getSource().equals(replay)) {

                           viewManagerModel.setActiveView(collectQuestionsViewModel.getViewName());
                           viewManagerModel.firePropertyChanged();

                    }
                 }
              }
      );

      exit.addActionListener(                // Returns to signup
              new ActionListener() {
                 public void actionPerformed(ActionEvent evt) {
                    if (evt.getSource().equals(exit)) {

                       viewManagerModel.setActiveView(signupViewModel.getViewName());
                       viewManagerModel.firePropertyChanged();

                    }
                 }
              }
      );

      this.add(title);
      this.add(userOutput);
      this.add(userOutputLB);
      this.add(buttons);

   }


   @Override
   public void actionPerformed(ActionEvent evt) {
      System.out.println("Click " + evt.getActionCommand());
   }

   @Override
   public void propertyChange(PropertyChangeEvent evt) {
      System.out.println("Issue found, please fix this right away");
   }

}