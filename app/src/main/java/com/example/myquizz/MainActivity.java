package com.example.myquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonStartQuiz = findViewById(R.id.button_start_quiz);
        buttonStartQuiz.setOnClickListener(new View.OnClickListener(){
@Override
            public void onClick(View v){
    startQuiz();
}
        });
    }
    private void startQuiz(){
        Intent intent = new Intent(MainActivity.this, QuizzActivity.class );
startActivity(intent);
    }
}