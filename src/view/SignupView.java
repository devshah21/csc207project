package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.clear_users.ClearController;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;


// Define the SignupView class, which is a Swing-based user interface.
public class SignupView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "sign up";

    private final SignupViewModel signupViewModel;
    private final JTextField usernameInputField = new JTextField(15);
    private final JPasswordField passwordInputField = new JPasswordField(15);
    private final JPasswordField repeatPasswordInputField = new JPasswordField(15);
    private final SignupController signupController;
    private final ClearController clearController;
    private Color background = new Color(57,54,70);
    private Color textColor = new Color(244, 238, 224);
    private final JButton signUp;
    private final JButton logIn;
    private final JButton clear;
    private final LoginViewModel loginViewModel;
    private ViewManagerModel viewManagerModel;


    // Constructor for the SignupView class.
    public SignupView(SignupController controller, SignupViewModel signupViewModel, ClearController clearController,
                      LoginViewModel loginViewModel, ViewManagerModel viewManagerModel) {
        this.setBackground(background);
        this.signupController = controller;
        this.signupViewModel = signupViewModel;
        this.clearController = clearController;
        this.loginViewModel = loginViewModel;
        this.viewManagerModel = viewManagerModel;


        signupViewModel.addPropertyChangeListener(this);

        // Create user interface elements.
        JLabel title = new JLabel("Welcome to Quizit!");
        title.setForeground(textColor);
        title.setBounds(400,0,200,100);
        JLabel subtitle = new JLabel("Please sign up to start");
        subtitle.setForeground(textColor);
        subtitle.setFont(new Font("Calibri",Font.BOLD,17));
        subtitle.setBounds(430,20,200,100);
        title.setFont(new Font("Calibri",Font.BOLD,24));


        // set size of the prefered texlabel
        usernameInputField.setPreferredSize(new Dimension(200, 25));
        usernameInputField.setFont(new Font(usernameInputField.getFont().getName(),usernameInputField.getFont().getStyle(),16));

        // Username label when signing up
        JLabel userName = new JLabel("Username");
        userName.setBorder(new EmptyBorder(0,0,0,5)); //top,left,bottom,right
        userName.setForeground(textColor);
        LabelTextPanel usernameInfo = new LabelTextPanel(userName, usernameInputField);
        usernameInfo.setBackground(background);
        usernameInfo.setLayout(new BoxLayout(usernameInfo, BoxLayout.X_AXIS));

        passwordInputField.setPreferredSize(new Dimension(200, 25));
        passwordInputField.setFont(new Font(usernameInputField.getFont().getName(),usernameInputField.getFont().getStyle(),16));

        JLabel passText = new JLabel("Password");
        passText.setForeground(textColor);
        passText.setBorder(new EmptyBorder(0,0,0,5));
        LabelTextPanel passwordInfo = new LabelTextPanel(passText, passwordInputField);
        passwordInfo.setBackground(background);
        passwordInfo.setLayout(new BoxLayout(passwordInfo, BoxLayout.X_AXIS));

        // ...

        repeatPasswordInputField.setPreferredSize(new Dimension(200, 25));
        repeatPasswordInputField.setFont(new Font(usernameInputField.getFont().getName(),usernameInputField.getFont().getStyle(),16));

        JLabel repeatPasswordText = new JLabel("Repeat Password");
        repeatPasswordText.setForeground(textColor);
        repeatPasswordText.setBorder(new EmptyBorder(0, 0, 0, 5));
        LabelTextPanel repeatpasswordInfo = new LabelTextPanel(repeatPasswordText, repeatPasswordInputField);
        repeatpasswordInfo.setBackground(background);
        repeatpasswordInfo.setLayout(new BoxLayout(repeatpasswordInfo, BoxLayout.X_AXIS));


        JPanel buttons = new JPanel();
        buttons.setBackground(background);
        signUp = new JButton(SignupViewModel.SIGNUP_BUTTON_LABEL);
        signUp.setBackground(new Color(79, 69, 87));
        signUp.setForeground(textColor);

        buttons.add(signUp);

        logIn = new JButton(LoginViewModel.LOGIN_BUTTON_LABEL);
        buttons.add(logIn);

        logIn.setBackground(new Color (79, 69, 87));
        logIn.setForeground(textColor);

        clear = new JButton(SignupViewModel.CLEAR_BUTTON_LABEL);
        buttons.add(clear);
        clear.setBackground(new Color (79, 69, 87));
        clear.setForeground(textColor);


        // Register action listeners for buttons.
        signUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(signUp)) {
                    SignupState currentState = signupViewModel.getState();
                    signupController.execute(
                            currentState.getUsername(),
                            currentState.getPassword(),
                            currentState.getRepeatPassword()
                    );
                }
            }
        });

        logIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(logIn)) {
                    viewManagerModel.setActiveView(loginViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                }
            }
        });


        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(clear)) {
                    try {
                        clearController.execute();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        clear.addActionListener(this);

        // Add KeyListeners for input fields.
        usernameInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                SignupState currentState = signupViewModel.getState();
                String text = usernameInputField.getText() + e.getKeyChar();
                currentState.setUsername(text);
                signupViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });


        passwordInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                SignupState currentState = signupViewModel.getState();
                currentState.setPassword(passwordInputField.getText() + e.getKeyChar());
                signupViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        repeatPasswordInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                SignupState currentState = signupViewModel.getState();
                currentState.setRepeatPassword(repeatPasswordInputField.getText() + e.getKeyChar());
                signupViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        // Configure the layout of the panel.
        this.setLayout(null);

        usernameInfo.setBounds(390,267,200,25);
        passwordInfo.setBounds(390,310,200,25);
        repeatpasswordInfo.setBounds(390, 350, 220, 25);
        buttons.setBounds(390, 400, 200, 35);  // Add this line
        this.add(buttons);

        // Add UI elements to the panel.
        this.add(subtitle);
        usernameInfo.setPreferredSize(new Dimension(0,0));
        this.add(title);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(repeatpasswordInfo);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showConfirmDialog(this, "LogIn not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SignupState state = (SignupState) evt.getNewValue();
        if (state.getUsernameError() != null) {
            JOptionPane.showMessageDialog(this, state.getUsernameError());
        }
        if (state.fetchAllUsers() != null) {
            JOptionPane.showMessageDialog(this, state.fetchAllUserString());
        }
    }
}