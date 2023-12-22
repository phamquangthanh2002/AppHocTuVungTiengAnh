package com.example.edit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class listItem2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item2);

        RelativeLayout aaaaLinearLayout = findViewById(R.id.aaaa);

        aaaaLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(listItem2.this, mainItemThings.class);
                startActivity(intent);
            }
        });
    }
}