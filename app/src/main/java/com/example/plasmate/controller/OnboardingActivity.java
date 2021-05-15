package com.example.plasmate.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.plasmate.R;
import com.example.plasmate.adapters.SliderAdapter;

public class OnboardingActivity extends AppCompatActivity {
    private ViewPager viewPagerSlider;
    private LinearLayout linearDots;

    private TextView[] dotsView;
    private SliderAdapter sliderAdapter;

    private Button backButton;
    private Button nextButton;

    private int currentPage;
    private boolean lastSlide;

    private boolean firstBoot;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
        getSupportActionBar().hide();

        viewPagerSlider = findViewById(R.id.viewPagerSlider);
        linearDots = findViewById(R.id.linearDots);
        backButton = findViewById(R.id.backButton);
        nextButton = findViewById(R.id.nextButton);

        sliderAdapter = new SliderAdapter(this);
        viewPagerSlider.setAdapter(sliderAdapter);

        addDotsIndicator(0);
        viewPagerSlider.addOnPageChangeListener(viewListener);

        // onClick Listener

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                viewPagerSlider.setCurrentItem(currentPage - 1);
                Log.i(Boolean.toString(lastSlide),Integer.toString(currentPage));
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (!lastSlide){
                    viewPagerSlider.setCurrentItem(currentPage + 1);
                    Log.i(Boolean.toString(lastSlide),Integer.toString(currentPage));
                }
                else{
                    intent = new Intent(OnboardingActivity.this, LoginActivitty.class);
                    getSharedPreferences("PlasMate",MODE_PRIVATE).edit().putBoolean("firstBoot",false).apply();
                    startActivity(intent);
                    finish();
                    Log.i(Boolean.toString(lastSlide), Integer.toString(currentPage));
                    Log.i("FINISH CLICKED", Integer.toString(currentPage));
                }
            }
        });
    }

    public void addDotsIndicator(int position){

        dotsView = new TextView[3];
        linearDots.removeAllViews();

        for(int i=0; i<dotsView.length; i++){
            dotsView[i] = new TextView(this);
            dotsView[i].setText(Html.fromHtml("&#8226;"));
            dotsView[i].setTextSize(35);
            dotsView[i].setTextColor(ContextCompat.getColor(this,R.color.gray));
            linearDots.addView(dotsView[i]);
        }
        if (dotsView.length > 0){
            dotsView[position].setTextColor(ContextCompat.getColor(this,R.color.white));
        }
    }
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
            currentPage = position;
            if (position==0){
                nextButton.setEnabled(true);
                backButton.setEnabled(false);
                backButton.setVisibility(View.INVISIBLE);
                nextButton.setText("NEXT");
                backButton.setText("");
                lastSlide = false;
            }
            else if (position == dotsView.length -1){
                nextButton.setEnabled(true);
                backButton.setEnabled(true);
                backButton.setVisibility(View.VISIBLE);
                nextButton.setText("FINISH");
                backButton.setText("BACK");
                lastSlide = true;
            }
            else{
                nextButton.setEnabled(true);
                backButton.setEnabled(true);
                backButton.setVisibility(View.VISIBLE);
                nextButton.setText("NEXT");
                backButton.setText("BACK");
                lastSlide = false;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}