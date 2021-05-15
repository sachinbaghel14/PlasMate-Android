package com.example.plasmate.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.plasmate.R;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    /**Display Image Array */
    public int[] slide_images = {
            R.drawable.foodbowl,
            R.drawable.manwithlaptop,
            R.drawable.peacefulowl
    };

    /**Headings Array */
    public String[] slide_headings = {
            "EAT",
            "SLEEP",
            "CODE"
    };

    /**Description Array */
    public String[] slide_descriptions = {
            "Cat ipsum dolor sit amet, what the heck just happened, something feels fishy. Sit on the laptop cat meoooow i iz master of hoomaan",
            "Push your water glass on the floor intrigued by the shower, or purr as loud as possible, and, knock everything off the table.",
            "Claws in your leg. Stares at human while pushing stuff off a table. Cat cat moo moo lick ears lick paws side-eyes your \"jerk\"."
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageView = view.findViewById(R.id.slide_image);
        TextView slideHeading = view.findViewById(R.id.headingTextView);
        TextView slideDescription = view.findViewById(R.id.descriptionTextView);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descriptions[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
