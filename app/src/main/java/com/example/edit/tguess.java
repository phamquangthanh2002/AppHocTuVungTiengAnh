package com.example.edit;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class tguess extends AppCompatActivity {
    TextView battleTextView,tvvTextView,wTextView;
    private int presCounter = 0;
    private int maxPresCounter = 4;
    private String [] keys = {"R","I","B","D","X"};
    private String textAnswer = "BIRD";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tguess);
        keys = shuffleArray(keys);
        for (String key : keys)
        {
            addView(((LinearLayout) findViewById(R.id.li)),key,((EditText) findViewById(R.id.ed)));
        }
        maxPresCounter =4;
        battleTextView = findViewById(R.id.battle);

        // Ánh xạ ObjectAnimator để thay đổi thuộc tính textSize của TextView
        ObjectAnimator animator = ObjectAnimator.ofFloat(battleTextView, "textSize", 12f, 40f); // 24sp to 16sp

        // Đặt thời gian chuyển động (trong milliseconds)
        animator.setDuration(1000); // 1 giây

        // Bắt đầu animation khi vào trang
        animator.start();
    }

    private void addView(LinearLayout viewParent,final String text, final EditText editText) {
        LinearLayout.LayoutParams linearLayoutParams = new  LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        linearLayoutParams.rightMargin =30;
        final TextView textView =new TextView (this);
        textView.setLayoutParams(linearLayoutParams);
        textView.setBackground(this.getResources().getDrawable(R.drawable.tpink));
        textView.setTextColor(this.getResources().getColor(R.color.cPurple));
        textView.setText(text);
        textView.setClickable(true);
        textView.setFocusable(true);
        textView.setTextSize(32);
        battleTextView =(TextView) findViewById(R.id.battle);
        tvvTextView =(TextView) findViewById(R.id.tvv);
        wTextView =(TextView) findViewById(R.id.w);
        textView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(presCounter < maxPresCounter) {
                    if (presCounter == 0) {
                        editText.setText("");
                        editText.setText(editText.getText().toString()+ text);
                  //      textView.startAnimation(bigsmallforth);
                        textView.animate().alpha(0).setDuration(300);
                        presCounter++;
                        if(presCounter == maxPresCounter){
              //              doValidate();
                        }
                    }
                }
            }
        });
        viewParent.addView(textView);


    }

    private String [] shuffleArray(String[] ar){
        Random rnd = new Random();
        for (int i = ar.length -1 ;i>0;i--){
            int index = rnd.nextInt(i+1);
            String a=ar[index];
            ar[index]=ar[i];
            ar[i]=a;
        }
        return ar;
    }

}
