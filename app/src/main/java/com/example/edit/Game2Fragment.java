package com.example.edit;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Game2Fragment extends Fragment {

    private int presCounter = 0;
    private String[] keys;
    private String textAnswer;
    private int returnClickCounter = 0;
    private List<String> wordList; // Track available words for the current round

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game2, container, false);

        wordList = new ArrayList<>(Arrays.asList("FROG", "BEAR", "DOG", "FISH", "SHARK"));

        startNewRound(view);


        Button checkButton = view.findViewById(R.id.checkButton);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCheckButtonClick(v, view);
            }
        });

        Button returnButton = view.findViewById(R.id.returnn);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onReturnedButtonClick(v, view);
            }
        });

        return view;
    }

    private void startNewRound(View view) {
        if (wordList.isEmpty()) {
            // All words have been used, reset the list for the next round
            wordList.addAll(Arrays.asList("FROG", "BEAR", "DOG", "FISH", "SHARK"));
        }

        textAnswer = getRandomWord();
        keys = shuffleArray(textAnswer.split(""));

        LinearLayout linearLayout = view.findViewById(R.id.li);
        linearLayout.removeAllViews();

        for (String key : keys) {
            addView(linearLayout, key, view.findViewById(R.id.ed));
        }
    }

    private void addView(LinearLayout viewParent, final String text, final EditText editText) {
        LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        linearLayoutParams.rightMargin = 30;
        final TextView textView = new TextView(requireContext());
        textView.setLayoutParams(linearLayoutParams);
        textView.setBackground(requireContext().getResources().getDrawable(R.drawable.tpink));
        textView.setTextColor(requireContext().getResources().getColor(R.color.cPurple));
        textView.setText(text);
        textView.setClickable(true);
        textView.setFocusable(true);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(32);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (presCounter == 0)
                    editText.setText("");

                if (textView.getAlpha() == 1.0f) {
                    editText.setText(editText.getText().toString() + text);
                    textView.animate().alpha(0).setDuration(300);
                    presCounter++;
                }
            }
        });

        viewParent.addView(textView);
    }

    private void onReturnedButtonClick(View view, View fragmentView) {
        EditText editText = fragmentView.findViewById(R.id.ed);

        if (presCounter == 0) {
            return;
        }

        returnClickCounter++;
        String currentText = editText.getText().toString();
        int charactersToUndo = returnClickCounter;
        charactersToUndo = Math.min(charactersToUndo, currentText.length());
        editText.setText(currentText.substring(0, currentText.length() - charactersToUndo));
        updateTextViews(fragmentView);
    }

    private void updateTextViews(View view) {
        LinearLayout linearLayout = view.findViewById(R.id.li);
        linearLayout.removeAllViews();

        for (String key : keys) {
            addView(linearLayout, key, view.findViewById(R.id.ed));
        }
    }

    private void onCheckButtonClick(View view, View fragmentView) {
        EditText editText = fragmentView.findViewById(R.id.ed);
        LinearLayout linearLayout = fragmentView.findViewById(R.id.li);

        if (editText.getText().toString().equals(textAnswer)) {
            editText.setText("");
            Toast.makeText(requireContext(), "Correct", Toast.LENGTH_SHORT).show();

            startNewRound(fragmentView); // Start a new round after a correct answer
        } else {
            editText.setText("");
            Toast.makeText(requireContext(), "Check", Toast.LENGTH_SHORT).show();

            linearLayout.removeAllViews();

            for (String key : textAnswer.split("")) {
                addView(linearLayout, key, editText);
            }
        }
    }

    private String getRandomWord() {
        Random random = new Random();
        int index = random.nextInt(wordList.size());
        return wordList.remove(index);
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
}
