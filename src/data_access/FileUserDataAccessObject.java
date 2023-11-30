package data_access;

import entity.User;
import entity.UserFactory;
import use_case.clear_users.ClearUserDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// Define a class that implements multiple data access interfaces.
public class FileUserDataAccessObject implements SignupUserDataAccessInterface, LoginUserDataAccessInterface, ClearUserDataAccessInterface {

    // Define a file to store user data.
    private final File csvFile;

    // Define header information for the CSV file.
    private final Map<String, Integer> headers = new LinkedHashMap<>();

    // Store user accounts in a map.
    private final Map<String, User> accounts = new HashMap<>();

    private UserFactory userFactory;

    // Constructor for FileUserDataAccessObject.
    public FileUserDataAccessObject(String csvPath, UserFactory userFactory) throws IOException {
        this.userFactory = userFactory;

        // Initialize the CSV file and its headers.
        csvFile = new File(csvPath);
        headers.put("username", 0);
        headers.put("password", 1);
        headers.put("score", 2);

        // If the CSV file is empty, save it.
        if (csvFile.length() == 0) {
            save();
        } else {

            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();

                // For later: clean this up by creating a new Exception subclass and handling it in the UI.
                assert header.equals("username,password,score");

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String username = String.valueOf(col[headers.get("username")]);
                    String password = String.valueOf(col[headers.get("password")]);
                    int score = 0;
                    User user = userFactory.create(username, password, score);
                    accounts.put(username, user);
                }
            }
        }
    }

    // Save a user to the data storage.
    @Override
    public void save(User user) {
        accounts.put(user.getName(), user);
        this.save();
    }

    // Retrieve a user by their username.
    @Override
    public User get(String username) {
        return accounts.get(username);
    }

    // Save the user data to the CSV file.
    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (User user : accounts.values()) {
                String line = String.format("%s,%s,%s",
                        user.getName(), user.getPassword(), 0);
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Check if a user with a specific username exists.
    @Override
    public boolean existsByName(String identifier) {
        return accounts.containsKey(identifier);
    }

    // Erase all user data.
    @Override
    public void erase() throws IOException {
        this.accounts.clear();
        this.save();
    }

    // Retrieve an array of usernames.
    @Override
    public String[] getUsers() {
        return accounts.keySet().toArray(new String[0]);
    }
}
