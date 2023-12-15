package com.example.edit;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;


public class MainActivity extends AppCompatActivity {
    private Button btnA;
    private Button btnB;
    TextView appname;
    LottieAnimationView lottie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appname= findViewById(R.id.appname);
        lottie= findViewById(R.id.lottie);
        lottie.setAnimation(R.raw.huu);



        btnA = (Button) findViewById(R.id.button);
btnB =(Button) findViewById(R.id.button2);

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Clicked", Toast.LENGTH_SHORT);
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Clicked", Toast.LENGTH_LONG);
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}