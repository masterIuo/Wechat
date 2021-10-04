package com.example.wechat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Fragment fragment_wechat = new fragment_wechat();
    private Fragment fragment_config = new fragment_config();
    private Fragment fragment_contact = new fragment_contact();
    private Fragment fragment_friend = new fragment_friend();
    private FragmentManager fragmentManager;

    private LinearLayout linearLayout1, linearLayout2, linearLayout3, linearLayout4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout1 = findViewById(R.id.layout1);
        linearLayout2 = findViewById(R.id.layout2);
        linearLayout3 = findViewById(R.id.layout3);
        linearLayout4 = findViewById(R.id.layout4);

        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
        linearLayout4.setOnClickListener(this);


        InitFragment();


    }

    private void InitFragment() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.id_content, fragment_wechat);
        transaction.add(R.id.id_content, fragment_friend);
        transaction.add(R.id.id_content, fragment_contact);
        transaction.add(R.id.id_content, fragment_config);
        transaction.commit();
        HideFragment(transaction);
    }

    private void HideFragment(FragmentTransaction transaction) {
        transaction.hide(fragment_wechat);
        transaction.hide(fragment_config);
        transaction.hide(fragment_friend);
        transaction.hide(fragment_contact);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout1:
                showfragment(0);
                break;
            case R.id.layout2:
                showfragment(1);
                break;
            case R.id.layout3:
                showfragment(2);
                break;
            case R.id.layout4:
                showfragment(3);
                break;
            default:
                break;
        }
    }

    private void showfragment(int i) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        HideFragment(transaction);
        switch (i) {
            case 0:
                transaction.show(fragment_wechat);
                break;
            case 1:
                transaction.show(fragment_contact);
                break;
            case 2:
                transaction.show(fragment_friend);
                break;
            case 3:
                transaction.show(fragment_config);
                break;
            default:
                break;


        }
        transaction.commit();
    }
}
