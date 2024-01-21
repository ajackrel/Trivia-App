package com.example.triviaapptest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TriviaActivity extends AppCompatActivity {

    TextView questionView;
    Button answer_A;
    Button answer_B;
    Button answer_C;
    Button answer_D;
    Button buttonBack;





    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia);

         questionView = findViewById(R.id.textViewQuestion);
         answer_A = findViewById(R.id.choiceA);
         answer_B = findViewById(R.id.choiceB);
         answer_C = findViewById(R.id.choiceC);
         answer_D = findViewById(R.id.choiceD);
         buttonBack = findViewById(R.id.buttonBack);

        String question = getIntent().getStringExtra("question");
        String choiceA = getIntent().getStringExtra("choiceA");
        String choiceB = getIntent().getStringExtra("choiceB");
        String choiceC = getIntent().getStringExtra("choiceC");
        String choiceD = getIntent().getStringExtra("choiceD");
        String answer = getIntent().getStringExtra("answer");

//        ArrayList<TriviaList> list = (ArrayList<TriviaList>) getIntent().getSerializableExtra("list");
//        System.out.println(list.toString());

//        System.out.println("inside TriviaActivity");
//        ArrayList<TriviaList> list = (ArrayList<TriviaList>)getIntent().getSerializableExtra("list");
//        for (int i = 0; i < list.size(); i++){
//            list.get(i).toString();
//        }


        questionView.setText(question);
        answer_A.setText("A: " +choiceA);
        answer_A.setGravity(Gravity.CENTER);
        answer_B.setText("B: " +choiceB);
        answer_B.setGravity(Gravity.CENTER_HORIZONTAL);
        answer_C.setText("C: " +choiceC);
        answer_C.setGravity(Gravity.CENTER_HORIZONTAL);
        answer_D.setText("D: " +choiceD);
        answer_D.setGravity(Gravity.CENTER_HORIZONTAL);

        Intent intent = new Intent(TriviaActivity.this, MainActivity.class);


        answer_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("answer is: " +answer);
                System.out.println("choice is: " +answer_A);


                if (answer.equals("A")){
                    Toast.makeText(TriviaActivity.this, "CORRECT!", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(TriviaActivity.this, CorrectActivity.class );
//                    startActivity(intent);
                    intent.putExtra("correct", 100);
                    intent.putExtra("number_answered", 1);
                    startActivity(intent);


                }
                else {
                    Toast.makeText(TriviaActivity.this, "WRONG!", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(TriviaActivity.this, WrongActivity.class );
//                    startActivity(intent);
                    intent.putExtra("wrong", 0);

                }

            }
        });

        answer_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer.equals("B")){
                    Toast.makeText(TriviaActivity.this, "CORRECT!", Toast.LENGTH_SHORT).show();
                    intent.putExtra("correct", 100);
                    intent.putExtra("number_answered", 1);
                    startActivity(intent);


                }

                else {
                    Toast.makeText(TriviaActivity.this, "WRONG!", Toast.LENGTH_SHORT).show();
                    intent.putExtra("wrong", 0);

                }
            }
        });

        answer_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer.equals("C")){
                    Toast.makeText(TriviaActivity.this, "CORRECT!", Toast.LENGTH_SHORT).show();
                    intent.putExtra("correct", 100);
                    intent.putExtra("number_answered", 1);
                    startActivity(intent);


                }
                else {
                    Toast.makeText(TriviaActivity.this, "WRONG!", Toast.LENGTH_SHORT).show();
                    intent.putExtra("wrong", 0);

                }
            }
        });

        answer_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer.equals("D")){
                    Toast.makeText(TriviaActivity.this, "CORRECT!", Toast.LENGTH_SHORT).show();
                    intent.putExtra("correct", 100);
                    intent.putExtra("number_answered", 1);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(TriviaActivity.this, "WRONG!", Toast.LENGTH_SHORT).show();
                    intent.putExtra("correct", 0);
                }
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TriviaActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}