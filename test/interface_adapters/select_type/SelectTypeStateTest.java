package interface_adapters.select_type;


import interface_adapter.select_type.SelectTypeState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelectTypeStateTest {

    private SelectTypeState selectTypeState;

    @BeforeEach
    public void setUp() {
        selectTypeState = new SelectTypeState();
    }

    @Test
    public void testSetAndGetTotalQ() {
        String totalQ = "10";
        selectTypeState.setTotalQ(totalQ);
        assertEquals(totalQ, selectTypeState.getTotalQ());
    }

    @Test
    public void testSetAndGetUsername() {
        String username = "testUser";
        selectTypeState.setUsername(username);
        assertEquals(username, selectTypeState.getUsername());
    }

    @Test
    public void testCopyConstructor() {
        String totalQ = "10";
        String username = "testUser";
        selectTypeState.setTotalQ(totalQ);
        selectTypeState.setUsername(username);

        SelectTypeState copy = new SelectTypeState(selectTypeState);
        assertEquals(totalQ, copy.getTotalQ());
        assertEquals(username, copy.getUsername());
    }
}
