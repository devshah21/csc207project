package use_case.clear_users;

// Define the ClearOutputData class for output data related to clearing users.
public class ClearOutputData {

    private static String message;
    private String[] getUsers;

    // Constructor to initialize ClearOutputData with an array of usernames.
    public ClearOutputData(String[] getUsers) {
        message = "Users deleted.";
        this.getUsers = getUsers;
    }

    // Method to fetch all users (an array of usernames).
    public String[] fatchAllUsers() {
        return this.getUsers;
    }
}
