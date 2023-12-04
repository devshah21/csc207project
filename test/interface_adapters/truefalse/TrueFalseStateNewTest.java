package interface_adapters.truefalse;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import interface_adapter.TrueFalseNew.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrueFalseStateNewTest {

    private TrueFalseStateNew state;

    @BeforeEach
    public void setup() {
        state = new TrueFalseStateNew();
    }

    @Test
    public void testGettersAndSetters() {
        state.setTotalQ("10");
        assertEquals("10", state.getTotalQ());

        state.setBackupTotQ(5);
        assertEquals(5, state.getBackupTotQ());

        state.setUsername("testUser");
        assertEquals("testUser", state.getUsername());

        state.setTrueErrorFeild("trueError");
        assertEquals("trueError", state.getTrueErrorFeild());

        state.setFalseErrorFeild("falseError");
        assertEquals("falseError", state.getFalseErrorFeild());

        state.setTypeQuestion("True/False");
        assertEquals("True/False", state.getTypeQuestion());

        state.setQuestionAsked("Is Java a programming language?");
        assertEquals("Is Java a programming language?", state.getQuestionAsked());

        state.setQuestionAnswer("True");
        assertEquals("True", state.getQuestionAnswer());

        state.setTotScore(10);
        assertEquals(10, state.getTotScore());

        ArrayList<String> questions = new ArrayList<>();
        questions.add("Is Java a programming language?");
        state.setQuestions(questions);
        assertEquals(questions, state.getQuestions());

        state.firstDone();
        assertEquals(true, state.isFirstDone());

        state.firstReset();
        assertEquals(false, state.isFirstDone());
    }
}

