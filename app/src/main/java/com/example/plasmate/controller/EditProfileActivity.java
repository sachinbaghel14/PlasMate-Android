package com.example.plasmate.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.plasmate.R;

public class EditProfileActivity extends AppCompatActivity {

    private static final String TAG = "EditProfileActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        getSupportActionBar().setTitle("Edit Profile");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
        @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                Log.i(TAG, "back button" );
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}