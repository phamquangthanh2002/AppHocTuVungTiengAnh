package com.example.edit;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class tguess extends AppCompatActivity {
    private TextView battleTextView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tguess);

        battleTextView = findViewById(R.id.battle);

        // Ánh xạ ObjectAnimator để thay đổi thuộc tính textSize của TextView
        ObjectAnimator animator = ObjectAnimator.ofFloat(battleTextView, "textSize", 12f, 40f); // 24sp to 16sp

        // Đặt thời gian chuyển động (trong milliseconds)
        animator.setDuration(1000); // 1 giây

        // Bắt đầu animation khi vào trang
        animator.start();
    }

}
