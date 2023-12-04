package interface_adapters.truefalse;


import entity.APIException;
import interface_adapter.TrueFalseNew.TrueFalseControllerNew;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.truefalseNew.TrueFalseInputBoundaryNew;
import use_case.truefalseNew.TrueFalseInputDataNew;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class truefalsecontrollertest {

    private TrueFalseControllerNew controller;
    private TrueFalseInputBoundaryNew useCase;

    @BeforeEach
    public void setup() {
        useCase = new TrueFalseInputBoundaryNew() {
            @Override
            public void execute(TrueFalseInputDataNew inputData) throws APIException, IOException, InterruptedException {
                // You can add your own implementation here for testing
            }
        };
        controller = new TrueFalseControllerNew(useCase);
    }

    @Test
    public void testExecute() {
        String answer = "True";
        Boolean isFirstDone = false;
        String Qleft = "5";
        String typeQuestion = "True/False";
        JLabel questionA = new JLabel("Is Java a programming language?");
        String realAnswer = "True";
        ArrayList<String> questions = new ArrayList<>();
        int currIndex = 0;

        assertDoesNotThrow(() -> controller.execute(answer, isFirstDone, Qleft, typeQuestion, questionA, realAnswer, questions, currIndex));
    }
}
