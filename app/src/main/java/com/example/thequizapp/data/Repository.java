package com.example.thequizapp.data;


import android.util.Log;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.thequizapp.controller.AppController;
import com.example.thequizapp.model.Question;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    ArrayList<Question> questionArrayList = new ArrayList<>();
    String url = "https://raw.githubusercontent.com/curiousily/simple-quiz/master/script/statements-data.json";

    public List<Question> getQuestions(){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, response -> {
            for (int i = 0; i < response.length(); i++) {
                try {
                    Log.d("Repo","On Create"+response.getJSONArray(i).get(1));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }, error -> {

        });

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);
        return  null;
    }
}
