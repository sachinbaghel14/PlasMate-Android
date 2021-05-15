package com.example.plasmate.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.plasmate.R;

public class MainActivity extends AppCompatActivity {

    private boolean firstBoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        firstBoot= getSharedPreferences("PlasMate",MODE_PRIVATE).getBoolean("firstBoot",true);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                if (firstBoot) {
                    Intent mainIntent = new Intent(MainActivity.this, OnboardingActivity.class);
                    startActivity(mainIntent);
                    finish();
                }else{
                    Intent mainIntent = new Intent(MainActivity.this, LoginActivitty.class);
                    startActivity(mainIntent);
                    finish();
                }
            }
        }, 3000);
    }
//    @Override
//    public void onResume() {
//        super.onResume();
//        getSupportActionBar().hide();
//    }

//    @Override
//    public void onStop() {
//        super.onStop();
//        getSupportActionBar().show();
//    }
}