package com.example.wechat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class info_xiaomi extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_xiaomi);

        String text = "永远相信美好的事情即将发生";
        textView = findViewById(R.id.xiaomi_text);
        textView.setText(text);
        imageView = findViewById(R.id.xiaomi_pic);
        imageView.setImageResource(R.drawable.xiaomi_logo);

    }
}