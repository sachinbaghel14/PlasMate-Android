package com.example.plasmate.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.plasmate.R;

public class LoginActivitty extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activitty);

        Button guestBtn = (Button)findViewById(R.id.btn_guest);
        guestBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivitty.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}