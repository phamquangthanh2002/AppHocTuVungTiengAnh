package com.example.edit;

import static android.app.ProgressDialog.show;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class DashboardActivity extends AppCompatActivity {
    public static ArrayList<Model> list;
    int index = 0;
    int correct = 0;
    int discorrect = 0;
    Button buttonpink;
    Button buttonpink2;
    CountDownTimer countdowntimer;

    ProgressBar progressbar;
    TextView card_question, optiona, optionb, optionc, optiond;
    CardView cardOA, cardOB, cardOC, cardOD, cardOE;
    private static final long Intervall = 1000;
    private static final long Countdown_time = 20000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        cardOE = findViewById(R.id.next);

        list = new ArrayList<>();
        Collections.shuffle(list);
        Model question1 = new Model("Câu hỏi 1", "Lựa chọn A", "Lựa chọn B", "Lựa chọn C", "Lựa chọn D", "Lựa chọn C");
        list.add(question1);
        Model question2 = new Model("Câu hỏi 2", "Lựa chọn A", "Lựa chọn B", "Lựa chọn C", "Lựa chọn D", "Lựa chọn D");
        list.add(question2);

        setAllData();
        next();
        progressbar = findViewById(R.id.quiz_timer);


        countdowntimer = new CountDownTimer(Countdown_time, Intervall) {
            @Override
            public void onTick(long millisUntilFinished) {
                int timerValue = (int) (millisUntilFinished / 1000);
                progressbar.setProgress(timerValue);
            }

            @Override
            public void onFinish() {
                progressbar.setProgress(0);
                Dialog dialog = new Dialog(DashboardActivity.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.time_out_dialog);

                buttonpink = dialog.findViewById(R.id.btn_tryagain);


                buttonpink.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(DashboardActivity.this, "Menu Item 1 clicked", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DashboardActivity.this, DashboardActivity.class);
                        startActivity(intent);
                    }
                });
                dialog.show();


            }
        };
        countdowntimer.start();



    }


    private void next(){
   cardOE.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           resetColor();
           goToNextQuestion();

       }
   });
    }
    private void setAllData() {
        card_question = findViewById(R.id.card_question);
        optiona = findViewById(R.id.card_optiona);
        optionb = findViewById(R.id.card_optionb);
        optionc = findViewById(R.id.card_optionc);
        optiond = findViewById(R.id.card_optiond);

        cardOA = findViewById(R.id.cardA);
        cardOB = findViewById(R.id.cardB);
        cardOC = findViewById(R.id.cardC);
        cardOD = findViewById(R.id.cardD);


        if (index < list.size()) {
            Model question = list.get(index);
            card_question.setText(question.getQuetion());
            optiona.setText(question.getOa());
            optionb.setText(question.getOb());
            optionc.setText(question.getOc());
            optiond.setText(question.getOd());

            cardOA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (question.getAns().equals("Lựa chọn A")) {
                        cardOA.setCardBackgroundColor(Color.GREEN);
                        correct++;
                    } else {
                        cardOA.setCardBackgroundColor(Color.RED);
                        discorrect++;
                    }

                }
            });

            cardOB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (question.getAns().equals("Lựa chọn B")) {
                        cardOB.setCardBackgroundColor(Color.GREEN);
                        correct++;
                    } else {
                        cardOB.setCardBackgroundColor(Color.RED);
                        discorrect++;
                    }

                }
            });

            cardOC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (question.getAns().equals("Lựa chọn C")) {
                        cardOC.setCardBackgroundColor(Color.GREEN);
                        correct++;
                    } else {
                        cardOC.setCardBackgroundColor(Color.RED);
                        discorrect++;
                    }

                }
            });


            cardOD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (question.getAns().equals("Lựa chọn D")) {
                        cardOD.setCardBackgroundColor(Color.GREEN);
                        correct++;
                    } else {
                        cardOD.setCardBackgroundColor(Color.RED);
                        discorrect++;
                    }

                }


            });

        }
    }


    private void resetColor(){
        cardOA.setCardBackgroundColor(Color.WHITE);
        cardOB.setCardBackgroundColor(Color.WHITE);
        cardOB.setCardBackgroundColor(Color.WHITE);
        cardOC.setCardBackgroundColor(Color.WHITE);
    }
    private void goToNextQuestion() {
        countdowntimer.cancel();
        countdowntimer.start();

        index++;
        if (index >= list.size()) {

            showResultDialog();


        }else{
            setAllData();

        }

    }
    private void showResultDialog(){
        progressbar.setProgress(0);
        Dialog dialog = new Dialog(DashboardActivity.this);
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
        dialog.setContentView(R.layout.won_activity);
        TextView textViewCorrect = dialog.findViewById(R.id.score);
        textViewCorrect.setText("score: " + correct);

        buttonpink2 = dialog.findViewById(R.id.btn_tryagain2);


        buttonpink2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DashboardActivity.this, "Menu Item 1 clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DashboardActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });
        dialog.show();
    }
}