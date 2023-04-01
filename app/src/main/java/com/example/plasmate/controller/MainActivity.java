package com.example.plasmate.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.example.plasmate.R;
import com.example.plasmate.model.MyFirebaseInstanceIDService;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    private boolean firstBoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getToken();
        createNotificationChannel();
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
                    Intent mainIntent = new Intent(MainActivity.this, FirstActivity.class);
                    startActivity(mainIntent);
                    finish();
                }
            }
        }, 3000);

        FirebaseMessaging.getInstance().subscribeToTopic("weather")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        //String msg = getString(R.string.msg_subscribed);
                        String msg = "done";
                        if (!task.isSuccessful()) {
                            //msg = getString(R.string.msg_subscribe_failed);
                            msg = "failed";
                        }
                        Log.d("abc", msg);
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });
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
private void createNotificationChannel() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        CharSequence name = "firebaseNotifChannel";
        String description = "Receve Firebase notification";
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel channel = new NotificationChannel("plasmatechannel", name, importance);
        channel.setDescription(description);
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
    }
}

    private void getToken() {
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                //If task is failed then
                if (!task.isSuccessful()) {
                    Log.d("token", "onComplete: Failed to get the Token");
                }

                //Token
                String token = task.getResult();
                Log.d("token", "onComplete: " + token);
            }
        });
    }
}