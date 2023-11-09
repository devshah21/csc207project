package interface_adapter.clear_users;

import use_case.clear_users.ClearInputBoundary;

import java.io.IOException;

// TODO Complete me
public class ClearController {
    final ClearInputBoundary clearUCI;
    public ClearController(ClearInputBoundary useCaseInteractor) {
        this.clearUCI = useCaseInteractor;
    }
    public void execute() throws IOException {
        this.clearUCI.execute();
    }
}
