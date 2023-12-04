package interface_adapter.signup;

// Define the SignupState class to manage the state of the signup process.
public class SignupState {
    // Fields to store various state information for signup.
    private String username = "";
    private String usernameError = null;
    private String password = "";
    private String passwordError = null;
    private String repeatPassword = "";
    private String repeatPasswordError = null;

    private String[] getUsers = null;

    // Copy constructor to create a new SignupState based on an existing one.
    public SignupState(SignupState copy) {
        username = copy.username;
        usernameError = copy.usernameError;
        password = copy.password;
        passwordError = copy.passwordError;
        repeatPassword = copy.repeatPassword;
        repeatPasswordError = copy.repeatPasswordError;
        this.getUsers = copy.getUsers;
    }

    // Explicit default constructor.
    public SignupState() {
    }

    // Getter methods for username and its error.
    public String getUsername() {
        return username;
    }

    public String getUsernameError() {
        return usernameError;
    }

    // Getter methods for password and its error.
    public String getPassword() {
        return password;
    }

    public String getPasswordError() {
        return passwordError;
    }

    // Getter methods for repeatPassword and its error.
    public String getRepeatPassword() {
        return repeatPassword;
    }

    public String getRepeatPasswordError() {
        return repeatPasswordError;
    }

    // Setter methods for username and its error.
    public void setUsername(String username) {
        this.username = username;
    }

    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    // Setter methods for password and its error.
    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    // Setter methods for repeatPassword and its error.
    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public void setRepeatPasswordError(String repeatPasswordError) {
        this.repeatPasswordError = repeatPasswordError;
    }

    // Method to fetch all users as an array.
    public String[] fetchAllUsers() {
        return getUsers;
    }

    // Method to set the users.
    public void userSet(String[] getUsers){
        this.getUsers = getUsers;
    }

    // Method to convert the array of users into a formatted string.
    public StringBuilder fetchAllUserString() {
        if (this.fetchAllUsers() == null) {
            return new StringBuilder();
        } else {
            StringBuilder users = new StringBuilder();
            for (String s : this.fetchAllUsers()) {
                users.append(s).append("\n");
            }
            return users;
        }
    }

    // Override the toString method to provide a string representation of the SignupState.
    @Override
    public String toString() {
        return "SignupState{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", repeatPassword='" + repeatPassword + '\'' +
                '}';
    }
}
