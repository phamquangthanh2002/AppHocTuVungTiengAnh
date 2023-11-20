package com.example.edit;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class tguess extends AppCompatActivity {
    TextView battleTextView, tvvTextView, wTextView;
    private int presCounter = 0;
    private String[] keys = {"R", "I", "B", "D"};
    private String textAnswer = "BIRD";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tguess);
        keys = shuffleArray(keys);
        for (String key : keys) {
            addView(((LinearLayout) findViewById(R.id.li)), key, ((EditText) findViewById(R.id.ed)));
        }
        battleTextView = findViewById(R.id.battle);

        ObjectAnimator animator = ObjectAnimator.ofFloat(battleTextView, "textSize", 12f, 40f); // 24sp to 16sp
        animator.setDuration(1000);

        animator.start();

        Button checkButton = findViewById(R.id.checkButton);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCheckButtonClick(v);
            }
        });
    }

    private void addView(LinearLayout viewParent, final String text, final EditText editText) {
        LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        linearLayoutParams.rightMargin = 30;
        final TextView textView = new TextView(this);
        textView.setLayoutParams(linearLayoutParams);
        textView.setBackground(this.getResources().getDrawable(R.drawable.tpink));
        textView.setTextColor(this.getResources().getColor(R.color.cPurple));
        textView.setText(text);
        textView.setClickable(true);
        textView.setFocusable(true);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(32);
        battleTextView = (TextView) findViewById(R.id.battle);
        tvvTextView = (TextView) findViewById(R.id.tvv);
        wTextView = (TextView) findViewById(R.id.w);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (presCounter == 0)
                    editText.setText("");
                editText.setText(editText.getText().toString() + text);
                textView.animate().alpha(0).setDuration(300);
                presCounter++;
            }
        });

        viewParent.addView(textView);
    }

    private void onCheckButtonClick(View view) {
        EditText editText = findViewById(R.id.ed);
        LinearLayout linearLayout = findViewById(R.id.li);

        if (editText.getText().toString().equals(textAnswer)) {
            editText.setText("");
            Toast.makeText(tguess.this, "Correct", Toast.LENGTH_SHORT).show();

            textAnswer = getNextWord();

            linearLayout.removeAllViews();

            for (String key : shuffleArray(textAnswer.split(""))) {
                addView(linearLayout, key, editText);
            }
        } else {
            editText.setText("");
            Toast.makeText(tguess.this, "Wrong", Toast.LENGTH_SHORT).show();

            linearLayout.removeAllViews();

            for (String key : textAnswer.split("")) {
                addView(linearLayout, key, editText);
            }
        }
    }

    private String[] shuffleArray(String[] ar) {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
        return ar;
    }

    private String getNextWord() {
        String[] words = {"FORG", "BEAR", "DOG", "FISH", "SHARK"};
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }
}
