package use_case.clear_users;
import java.io.IOException;

// TODO Complete me

public interface ClearUserDataAccessInterface {
    String[] getUsers();

    void erase() throws IOException;
}
