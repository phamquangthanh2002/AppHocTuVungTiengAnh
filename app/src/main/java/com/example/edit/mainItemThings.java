package com.example.edit;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class mainItemThings extends AppCompatActivity {

    private TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11;
    private ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_item_things);


        textView1 = findViewById(R.id.text_main);
        imageView1 = findViewById(R.id.imagevoca);

        textView2 = findViewById(R.id.text_main1);
        imageView2 = findViewById(R.id.imagevoca1);

        textView3 = findViewById(R.id.text_main2);
        imageView3 = findViewById(R.id.imagevoca2);

        textView4 = findViewById(R.id.text_main3);
        imageView4 = findViewById(R.id.imagevoca3);

        textView5 = findViewById(R.id.text_main4);
        imageView5 = findViewById(R.id.imagevoca4);

        textView6 = findViewById(R.id.text_main5);
        imageView6 = findViewById(R.id.imagevoca5);
        textView7 = findViewById(R.id.text_main6);
        imageView7 = findViewById(R.id.imagevoca6);

        textView8 = findViewById(R.id.text_main7);
        imageView8 = findViewById(R.id.imagevoca7);

        textView9 = findViewById(R.id.text_main8);
        imageView9 = findViewById(R.id.imagevoca8);

        textView10 = findViewById(R.id.text_main9);
        imageView10 = findViewById(R.id.imagevoca9);

        textView11 = findViewById(R.id.text_main10);
        imageView11 = findViewById(R.id.imagevoca10);



        textView1.setVisibility(View.GONE);
        textView2.setVisibility(View.GONE);
        textView3.setVisibility(View.GONE);
        textView4.setVisibility(View.GONE);
        textView5.setVisibility(View.GONE);
        textView6.setVisibility(View.GONE);
        textView7.setVisibility(View.GONE);
        textView8.setVisibility(View.GONE);
        textView9.setVisibility(View.GONE);
        textView10.setVisibility(View.GONE);
        textView11.setVisibility(View.GONE);

    }

    public void onImageClick(View view) {

        ImageView clickedImageView = (ImageView) view;
        if (clickedImageView == imageView1) {
            toggleVisibility(textView1, imageView1);
        } else if (clickedImageView == imageView2) {
            toggleVisibility(textView2, imageView2);
        } else if (clickedImageView == imageView3) {
            toggleVisibility(textView3, imageView3);
        }else if (clickedImageView == imageView4) {
            toggleVisibility(textView4, imageView4);
        } else if (clickedImageView == imageView5) {
            toggleVisibility(textView5, imageView5);
        }else if (clickedImageView == imageView6) {
            toggleVisibility(textView6, imageView6);
        } else if (clickedImageView == imageView7) {
            toggleVisibility(textView7, imageView7);
        } else if (clickedImageView == imageView8) {
            toggleVisibility(textView8, imageView8);
        }else if (clickedImageView == imageView9) {
            toggleVisibility(textView9, imageView9);
        } else if (clickedImageView == imageView10) {
            toggleVisibility(textView10, imageView10);
        }else if (clickedImageView == imageView11) {
            toggleVisibility(textView11, imageView11);
        }
    }

    public void onTextClick(View view) {

        TextView clickedTextView = (TextView) view;
        if (clickedTextView == textView1) {
            toggleVisibility(textView1, imageView1);
        } else if (clickedTextView == textView2) {
            toggleVisibility(textView2, imageView2);
        } else if (clickedTextView == textView3) {
            toggleVisibility(textView3, imageView3);
        }else if (clickedTextView == textView4) {
            toggleVisibility(textView4, imageView4);
        } else if (clickedTextView == textView5) {
            toggleVisibility(textView5, imageView5);
        }else if (clickedTextView == textView6) {
            toggleVisibility(textView6, imageView6);
        }
        else if (clickedTextView == textView7) {
            toggleVisibility(textView7, imageView7);
        } else if (clickedTextView == textView8) {
            toggleVisibility(textView8, imageView8);
        }else if (clickedTextView == textView9) {
            toggleVisibility(textView9, imageView9);
        } else if (clickedTextView == textView10) {
            toggleVisibility(textView10, imageView10);
        }else if (clickedTextView == textView11) {
            toggleVisibility(textView11, imageView11);
        }
    }

    private void toggleVisibility(TextView textView, ImageView imageView) {

        if (textView.getVisibility() == View.VISIBLE) {
            textView.setVisibility(View.GONE);
            imageView.setVisibility(View.VISIBLE);
        } else {
            textView.setVisibility(View.VISIBLE);
            imageView.setVisibility(View.GONE);
        }
    }
}