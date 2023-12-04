package use_case.login;

public interface LoginOutputBoundary {
    void prepareSuccessView(LoginOutputData user);

    void prepareFailViewUsername(String error);

    void prepareFailViewPassword(String error);
}