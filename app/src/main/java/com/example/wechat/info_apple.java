package com.example.wechat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class info_apple extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_apple);
        imageView = findViewById(R.id.apple_pic);
        textView = findViewById(R.id.apple_text);

        String text = "We do the right thing, even when it’s not easy.";

        textView.setText(text);
        imageView.setImageResource(R.drawable.apple_logo);
    }
}