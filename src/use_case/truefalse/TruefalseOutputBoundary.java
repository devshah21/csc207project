package use_case.truefalse;


public interface TruefalseOutputBoundary {

    void successView(TruefalseOutputData users);

    // Define a method to handle signup failure with an error message.
    void failView(String error);
}
