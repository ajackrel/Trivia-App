package com.example.triviaapptest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.icu.lang.UCharacter;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity{

    SharedPreferences sharedPreferences;
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private ArrayList<TriviaList> triviaList = new ArrayList<>();

    private TextView correct;
    private TextView cash;
    private Button new_game;

    int money = 3;
    int correctly_answered = 0;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        correct = findViewById(R.id.textView3);
        cash = findViewById(R.id.textView4);
        new_game = findViewById(R.id.button3);

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        recyclerAdapter = new RecyclerAdapter(triviaList, MainActivity.this);
        recyclerView.setAdapter(recyclerAdapter);

        String temp = loadJSONFromAsset();

        try {
            JSONArray obj = new JSONArray(temp);
            setUpTriviaArrays(obj);
            //  String question = obj.getString(40);
            // obj.getString("question");
        }
        catch (JSONException e) {
            throw new RuntimeException(e);
        }

        sharedPreferences = getSharedPreferences("saveData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
//        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);


//        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferencesName(this);
//        String s1 = sh.getString("name", "");

        System.out.println("money is: "  +money);

        //editor.putInt("cash", money);
        //editor.commit();

        Intent intent = getIntent();
        System.out.println("STORED: " +sharedPreferences.getInt("cash", 17));
        System.out.println("NEW: " +intent.getIntExtra("correct", 0));

        money = sharedPreferences.getInt("cash", 0) + intent.getIntExtra("correct", 0);
        System.out.println("updated money is: "  +money);
        editor.putInt("cash", money);

        correctly_answered = sharedPreferences.getInt("cash", 0) + intent.getIntExtra("correct", 0);

        editor.commit();


//
//        System.out.println("money is: "  +money);
        cash.setText("$" +money);

        new_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.clear();
                editor.apply();
                cash.setText("$0");
            }
        });

    }

    private void setUpTriviaArrays(JSONArray obj) throws JSONException {

        for(int i = 0; i < obj.length(); i++){
            JSONObject entry = obj.getJSONObject(i);
            String question = entry.getString("question");
            String answer = entry.getString("answer");
            String a = entry.getString("A");
            String b = entry.getString("B");
            String c = entry.getString("C");
            String d = entry.getString("D");
//            System.out.println(question);
//            System.out.println(answer);
            triviaList.add(new TriviaList(question, answer, a, b, c, d));

        }

    }

    public String loadJSONFromAsset() {
        System.out.println("inside of loadJSONFromAsset");
        String json = null;
        try {
            System.out.println("start json parsing");
            InputStream is = getAssets().open("million.json");
            System.out.println("end json parsing");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


}