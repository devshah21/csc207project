package entity;
import java.net.URI;
import java.net.http.HttpRequest; // Handles Requests
import java.net.http.HttpResponse; // Respone Handler
import java.net.http.HttpClient;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

class APIExpection extends Exception{}
public class QuizAPI {
    private ArrayList<Question> questions;

    public QuizAPI(int amount, String difficulty,String type, String catagory) throws IOException, InterruptedException, APIExpection {
        String API = String.format("https://opentdb.com/api.php?amount=%d&difficulty=%s&type=%s&category=%s", amount, difficulty, type, catagory);
        URI apiURL = URI.create(API);
        HttpRequest request = HttpRequest.newBuilder().uri(apiURL).GET().build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        int responseCode = response.statusCode();
        JSONObject jsonResponse = new JSONObject(response.body());
        JSONArray results = jsonResponse.getJSONArray("results");
        if (responseCode == 200){
            for (int i =0; i < results.length(); i++){
                JSONObject obj = (JSONObject)results.get(i);
                JSONArray arr = (JSONArray) obj.get("incorrect_answers");
                ArrayList<String> lst = new ArrayList<String>();
                for (int j = 0; j< arr.length(); j++){
                    lst.add(arr.get(j).toString());
                }
                Question q = new QuestionFactory(
                        obj.get("category").toString(),
                        obj.get("type").toString(),
                        obj.get("difficulty").toString(),
                        obj.get("question").toString(),
                        obj.get("correct_answer").toString(),
                        lst

                );

            }
        }
        else{
            throw new APIExpection();
        }


    }

    public ArrayList<Question> getQuestions(){
        return (ArrayList<Question>) questions.clone();
    }
}
