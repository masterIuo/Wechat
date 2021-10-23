package com.example.wechat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class info_huawei extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_huawei);

        String text = "把数字世界带入每个人、每个家庭、每个组织，构建万物互联的智能世界。";
        textView = findViewById(R.id.huawei_text);
        textView.setText(text);
        imageView = findViewById(R.id.huawei_pic);
        imageView.setImageResource(R.drawable.huawei_logo);
    }
}