package use_case.signup;

// Define a public interface for the SignupOutputBoundary.
public interface SignupOutputBoundary {

    // Define a method to handle successful signup with a SignupOutputData object.
    void successView(SignupOutputData users);

    // Define a method to handle signup failure with an error message.
    void failView(String error);
}
