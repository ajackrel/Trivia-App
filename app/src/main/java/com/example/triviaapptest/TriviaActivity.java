package com.example.triviaapptest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TriviaActivity extends AppCompatActivity {

    //question
    TextView questionView;
    //Choice A
    Button answer_A;
    //Choice B
    Button answer_B;
    //Choice C
    Button answer_C;
    //Choice D
    Button answer_D;
    //Back button
    Button buttonBack;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia);

        //initialize the views
         questionView = findViewById(R.id.textViewQuestion);
         answer_A = findViewById(R.id.choiceA);
         answer_B = findViewById(R.id.choiceB);
         answer_C = findViewById(R.id.choiceC);
         answer_D = findViewById(R.id.choiceD);
         buttonBack = findViewById(R.id.buttonBack);

         //retrieve and store the intented data from MainActivity.java
        String question = getIntent().getStringExtra("question");
        String choiceA = getIntent().getStringExtra("choiceA");
        String choiceB = getIntent().getStringExtra("choiceB");
        String choiceC = getIntent().getStringExtra("choiceC");
        String choiceD = getIntent().getStringExtra("choiceD");
        String answer = getIntent().getStringExtra("answer");

        //set the text views
        questionView.setText(question);
        answer_A.setText("A: " +choiceA);
        answer_B.setText("B: " +choiceB);
        answer_C.setText("C: " +choiceC);
        answer_D.setText("D: " +choiceD);


        //create a new intent path from here to Main
        Intent intent = new Intent(TriviaActivity.this, MainActivity.class);

        //event listener for Choice A
        answer_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //if answer matches Choice - change color to green and intent back data to Main
                if (answer.equals("A")){
                    answer_A.setBackgroundColor(Color.argb(255, 30, 255, 50));
                    Toast.makeText(TriviaActivity.this, "CORRECT!", Toast.LENGTH_SHORT).show();
                    intent.putExtra("cash", 100);
                    intent.putExtra("number_answered", 1);
                    startActivity(intent);


                }
                //else change color to red and intent data back to Main
                else {
                    Toast.makeText(TriviaActivity.this, "WRONG!", Toast.LENGTH_SHORT).show();
                    intent.putExtra("wrong", 0);
                    answer_A.setBackgroundColor(Color.argb(255, 255, 30, 50));


                }

            }
        });

        //event listener for Choice B
        answer_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //if answer matches Choice - change color to green and intent back data to Main
                if (answer.equals("B")){
                    answer_B.setBackgroundColor(Color.argb(255, 30, 255, 50));
                    Toast.makeText(TriviaActivity.this, "CORRECT!", Toast.LENGTH_SHORT).show();
                    intent.putExtra("cash", 100);
                    intent.putExtra("number_answered", 1);
                    startActivity(intent);


                }
                //else change color to red and intent data back to Main
                else {
                    Toast.makeText(TriviaActivity.this, "WRONG!", Toast.LENGTH_SHORT).show();
                    intent.putExtra("wrong", 0);
                    answer_B.setBackgroundColor(Color.argb(255, 255, 30, 50));

                }
            }
        });


        //event listener for Choice C
        answer_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //if answer matches Choice - change color to green and intent back data to Main
                if (answer.equals("C")){
                    answer_C.setBackgroundColor(Color.argb(255, 30, 255, 50));
                    Toast.makeText(TriviaActivity.this, "CORRECT!", Toast.LENGTH_SHORT).show();
                    intent.putExtra("cash", 100);
                    intent.putExtra("number_answered", 1);
                    startActivity(intent);


                }
                //else change color to red and intent data back to Main
                else {
                    Toast.makeText(TriviaActivity.this, "WRONG!", Toast.LENGTH_SHORT).show();
                    intent.putExtra("wrong", 0);
                    answer_C.setBackgroundColor(Color.argb(255, 255, 30, 50));

                }
            }
        });

        //event listener for Choice D
        answer_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //if answer matches Choice - change color to green and intent back data to Main
                if (answer.equals("D")){
                    answer_D.setBackgroundColor(Color.argb(255, 30, 255, 50));
                    Toast.makeText(TriviaActivity.this, "CORRECT!", Toast.LENGTH_SHORT).show();
                    intent.putExtra("cash", 100);
                    intent.putExtra("number_answered", 1);
                    startActivity(intent);
                }

                //else change color to red and intent data back to Main
                else {
                    Toast.makeText(TriviaActivity.this, "WRONG!", Toast.LENGTH_SHORT).show();
                    intent.putExtra("wrong", 0);
                    answer_D.setBackgroundColor(Color.argb(255, 255, 30, 50));
                }
            }
        });

        //event listener for back button
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TriviaActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}