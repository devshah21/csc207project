package entity;

import entity.APIException;
import entity.Question;
import entity.QuizAPI;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class quizapi_test {
    QuizAPI api;
    ArrayList<Question> q;
    @Before
    public void init() throws APIException, IOException, InterruptedException {
        this.api =  new QuizAPI(10,"medium","boolean","9");
        this.q = api.getQuestions();

    }

    @Test
    public void testAPICallGenericListNonEmpty(){
        assertFalse(q.isEmpty());
    }

}
