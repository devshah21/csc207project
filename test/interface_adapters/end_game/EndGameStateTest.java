package interface_adapters.end_game;

import interface_adapter.end_game.EndGameState;
import interface_adapters.end_game.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EndGameStateTest {

    private EndGameState endGameState;

    @BeforeEach
    public void setUp() {
        endGameState = new EndGameState();
    }

    @Test
    public void testUserOutput() {
        String output = "Test Output";
        endGameState.setOutput(output);
        assertEquals(output, endGameState.getOutput());
    }

    @Test
    public void testLeaderBoardTF() {
        String lbtf = "Test LBTF";
        endGameState.setLBTF(lbtf);
        assertEquals(lbtf, endGameState.getLBTF());
    }

    @Test
    public void testLeaderBoardMul() {
        String lbmul = "Test LBMul";
        endGameState.setLBMul(lbmul);
        assertEquals(lbmul, endGameState.getLBMul());
    }

    @Test
    public void testUsername() {
        String username = "Test Username";
        endGameState.setUsername(username);
        assertEquals(username, endGameState.getUsername());
    }
}

