package com.example.plasmate.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.plasmate.R;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        getSupportActionBar().hide();
        Button loginBtn = (Button)findViewById(R.id.loginBtn);
        Button guestBtn = (Button)findViewById(R.id.guestBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, LoginActivitty.class);
                startActivity(intent);
            }
        });
        guestBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}