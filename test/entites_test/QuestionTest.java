package entites_test;

import entity.Question;
import entity.QuestionFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class QuestionTest {
  private Question question;
 @Before
 public void init(){
  ArrayList<String> arr = new ArrayList<>();
  arr.add("2");
  arr.add("1");
  arr.add("4");
  this.question = new QuestionFactory("Music","MCQ","Hard","What how many balls am I holding?","3",arr);
 }


 @Test
 public void testGetType() {
          assertNotNull(question.getType());
 }

 @Test
 public void testGetDifficulty() {
          assertNotNull(question.getDifficulty());
 }

 @Test
 public void testGetCategory() {
           assertNotNull(question.getCategory());
 }

 @Test
 public void testGetQuestion() {

          assertNotNull(question.getQuestion());
 }

 @Test
 public void testGetRightAnswer() {
          assertNotNull(question.getRightAnswer());
 }

 @Test
 public void testGetWrongAnswers() {
  assertNotNull(question.getWrongAnswers());
 }
 
}

