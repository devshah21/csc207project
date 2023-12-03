package entity;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Iterator;

public class QuestionFactoryTest extends TestCase {

    public void testGetCategory() {
        // Test the getCategory method
        QuestionFactory question = new QuestionFactory("Science", "Multiple Choice", "Easy", "What is the capital of France?", "Paris", new ArrayList<>());
        assertEquals("Science", question.getCategory());
    }

    public void testGetType() {
        // Test the getType method
        QuestionFactory question = new QuestionFactory("Science", "Multiple Choice", "Easy", "What is the capital of France?", "Paris", new ArrayList<>());
        assertEquals("Multiple Choice", question.getType());
    }

    public void testGetDifficulty() {
        // Test the getDifficulty method
        QuestionFactory question = new QuestionFactory("Science", "Multiple Choice", "Easy", "What is the capital of France?", "Paris", new ArrayList<>());
        assertEquals("Easy", question.getDifficulty());
    }

    public void testGetQuestion() {
        // Test the getQuestion method
        QuestionFactory question = new QuestionFactory("Science", "Multiple Choice", "Easy", "What is the capital of France?", "Paris", new ArrayList<>());
        assertEquals("What is the capital of France?", question.getQuestion());
    }

    public void testGetRightAnswer() {
        // Test the getRightAnswer method
        QuestionFactory question = new QuestionFactory("Science", "Multiple Choice", "Easy", "What is the capital of France?", "Paris", new ArrayList<>());
        assertEquals("Paris", question.getRightAnswer());
    }

    public void testGetWrongAnswers() {
        // Test the getWrongAnswers method
        ArrayList<String> wrongAnswers = new ArrayList<>();
        wrongAnswers.add("Berlin");
        wrongAnswers.add("Madrid");

        QuestionFactory question = new QuestionFactory("Science", "Multiple Choice", "Easy", "What is the capital of France?", "Paris", wrongAnswers);
        assertEquals(wrongAnswers, question.getWrongAnswers());
    }

    public void testIterator() {
        // Test the iterator method
        ArrayList<String> wrongAnswers = new ArrayList<>();
        wrongAnswers.add("Berlin");
        wrongAnswers.add("Madrid");

        QuestionFactory question = new QuestionFactory("Science", "Multiple Choice", "Easy", "What is the capital of France?", "Paris", wrongAnswers);

        Iterator<String> iterator = question.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("Berlin", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("Madrid", iterator.next());
        assertFalse(iterator.hasNext());
    }
}
