package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupState;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoginView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "log in";
    private final LoginViewModel loginViewModel;

    final JTextField usernameInputField = new JTextField(15);
    private final JLabel usernameErrorField = new JLabel();

    final JPasswordField passwordInputField = new JPasswordField(15);
    private final JLabel passwordErrorField = new JLabel();

    private Color background = new Color(57,54,70);
    private Color textColor = new Color(244, 238, 224);

    final JButton logIn;
    final JButton cancel;
    private final LoginController loginController;
    private ViewManagerModel viewManagerModel;
    public LoginView(LoginViewModel loginViewModel, LoginController controller, ViewManagerModel viewManagerModel) {
        this.setBackground(background);
        this.loginController = controller;
        this.loginViewModel = loginViewModel;
        this.viewManagerModel = viewManagerModel;
        this.loginViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Welcome to Quizit!");
        title.setForeground(textColor);
        title.setBounds(400,0,200,100);
        JLabel subtitle = new JLabel("Please login to start");
        subtitle.setForeground(textColor);
        subtitle.setFont(new Font("Calibri",Font.BOLD,17));
        subtitle.setBounds(430,20,200,100);
        title.setFont(new Font("Calibri",Font.BOLD,24));


        // set size of the prefered texlabel
        usernameInputField.setPreferredSize(new Dimension(300,100));
        usernameInputField.setFont(new Font(usernameInputField.getFont().getName(),usernameInputField.getFont().getStyle(),16));
        JLabel userName = new JLabel("Username");
        userName.setBorder(new EmptyBorder(0,0,0,5)); //top,left,bottom,right
        userName.setForeground(textColor);
        LabelTextPanel usernameInfo = new LabelTextPanel(userName, usernameInputField);
        usernameInfo.setBackground(background);
        usernameInfo.setLayout(new BoxLayout(usernameInfo, BoxLayout.X_AXIS));

        passwordInputField.setPreferredSize(new Dimension(300,100));
        passwordInputField.setFont(new Font(usernameInputField.getFont().getName(),usernameInputField.getFont().getStyle(),16));
        JLabel passText = new JLabel("Password");
        passText.setForeground(textColor);
        passText.setBorder(new EmptyBorder(0,0,0,5));
        LabelTextPanel passwordInfo = new LabelTextPanel(passText, passwordInputField);
        passwordInfo.setBackground(background);
        passwordInfo.setLayout(new BoxLayout(passwordInfo, BoxLayout.X_AXIS));
        JPanel buttons = new JPanel();
        logIn = new JButton(loginViewModel.LOGIN_BUTTON_LABEL);
        logIn.setBackground(new Color(79, 69, 87));
        logIn.setForeground(textColor);
        buttons.add(logIn);
        cancel = new JButton(loginViewModel.CANCEL_BUTTON_LABEL);
        cancel.setBackground(new Color (79, 69, 87));
        cancel.setForeground(textColor);
        buttons.add(cancel);
        buttons.setBackground(background);
        logIn.addActionListener(                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(logIn)) {
                            LoginState currentState = loginViewModel.getState();

                            loginController.execute(
                                    currentState.getUsername(),
                                    currentState.getPassword()
                            );
                        }
                    }
                }
        );
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(cancel)){
                    viewManagerModel.setActiveView(SignupView.viewName);
                    viewManagerModel.firePropertyChanged();
                }
            }
        });

        cancel.addActionListener(this);

        usernameInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                LoginState currentState = loginViewModel.getState();
                currentState.setUsername(usernameInputField.getText() + e.getKeyChar());
                loginViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        this.setLayout(null);

        passwordInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        LoginState currentState = loginViewModel.getState();
                        currentState.setPassword(passwordInputField.getText() + e.getKeyChar());
                        loginViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        // Set sizes for the panels on the screen
        usernameInfo.setBounds(390,267,200,25);
        passwordInfo.setBounds(390,310,200,25);
        buttons.setBounds(400,500,200,35);





        this.add(title);
        this.add(subtitle);
        this.add(usernameInfo);
        this.add(usernameErrorField);
        this.add(passwordInfo);
        this.add(passwordErrorField);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LoginState state = (LoginState) evt.getNewValue();

        setFields(state);
        if (state.getUsernameError() != null) {
            JOptionPane.showMessageDialog(null, state.getUsernameError(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if  (state.getPasswordError() != null) {
            JOptionPane.showMessageDialog(null, state.getPasswordError(), "Error", JOptionPane.ERROR_MESSAGE);

        }
        state.resetPasswordError();
        state.resetUsernameError();
        // fix code here
    }

    private void setFields(LoginState state) {
        usernameInputField.setText(state.getUsername());
    }

}