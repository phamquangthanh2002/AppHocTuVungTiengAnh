package com.example.edit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ProgressBar;

public class DashboardActivity extends AppCompatActivity {
CountDownTimer countdowntimer;

ProgressBar progressbar;
private static final long Intervall = 1000;
private static final long Countdown_time =20000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        progressbar = findViewById(R.id.quiz_timer);

        countdowntimer = new CountDownTimer(Countdown_time, Intervall) {
            @Override
            public void onTick(long millisUntilFinished) {
int timerValue = (int) (millisUntilFinished / 1000);
progressbar.setProgress(timerValue);
            }

            @Override
            public void onFinish() {
Dialog dialog = new Dialog(DashboardActivity.this);
                progressbar.setProgress(0);
            }
        };countdowntimer.start();
    }
}