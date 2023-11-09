package use_case.clear_users;

// TODO Complete me
import java.io.IOException;

public class ClearInteractor implements ClearInputBoundary {
    final ClearUserDataAccessInterface clearDAO;
    final ClearOutputBoundary clearP;

    public ClearInteractor(ClearUserDataAccessInterface clearDAO, ClearOutputBoundary clearP) {
        this.clearDAO = clearDAO;
        this.clearP = clearP;
    }
    @Override
    public void execute() throws IOException {
        String[] usersGet = this.clearDAO.getUsers();
        this.clearDAO.erase();

        ClearOutputData clearOutputData = new ClearOutputData(usersGet);
        this.clearP.prepareSuccessView(clearOutputData);
    }
}
