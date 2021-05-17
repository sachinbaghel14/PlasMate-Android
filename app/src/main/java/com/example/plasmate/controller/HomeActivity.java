package com.example.plasmate.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.plasmate.R;
import com.example.plasmate.controller.fragments.PlasmaFragment;
import com.example.plasmate.controller.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "HomeFragment";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setTitle("Home");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        //for bottem navigation
        BottomNavigationView bottomNav = findViewById(R.id.bottem_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        //to show plasma fragment when HomeActivity loads
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new PlasmaFragment()).commit();
    }
        // bottem navigation listner to check which one is selected
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch(item.getItemId()){
                        case R.id.ic_plasma:
                            Log.i(TAG, "selected plasma");
                            selectedFragment = new PlasmaFragment();
                            getSupportActionBar().setTitle("Home");
//                            getSupportActionBar().setHomeButtonEnabled(false);
//                            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                            break;
                        case R.id.ic_news:
                            Log.i(TAG, "selected news");
                            break;
                        case R.id.ic_resources:
                            Log.i(TAG, "selected resources");
                            break;
                        case R.id.ic_supplies:
                            Log.i(TAG, "selected supplies");
                            break;
                        case R.id.ic_profile:
                            Log.i(TAG, "selected profile");
                            selectedFragment = new ProfileFragment();
                            getSupportActionBar().setTitle("Profile");
//                            getSupportActionBar().setHomeButtonEnabled(true);
//                            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                            break;
                    }
                    //to show the selected fragment
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        Log.i("back", "back button" );
//        switch (item.getItemId()){
//            case android.R.id.home:
//                getSupportFragmentManager().popBackStack();
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}