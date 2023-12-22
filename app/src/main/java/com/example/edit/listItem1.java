package com.example.edit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class listItem1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item1);
        RelativeLayout aaaLinearLayout = findViewById(R.id.aaa);

        aaaLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(listItem1.this, mainItemAnimals.class);
                startActivity(intent);
            }
        });

    }
}
