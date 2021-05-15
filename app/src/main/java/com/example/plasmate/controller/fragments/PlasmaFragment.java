package com.example.plasmate.controller.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;


import com.example.plasmate.R;

import com.example.plasmate.adapters.RecyclerViewAdapter;
import com.example.plasmate.model.PlasmaNetworking;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;


public class PlasmaFragment extends Fragment {

    private static final String TAG = "PlasmaFragment";
    //fab buttons
    private FloatingActionButton mAddFab, mRequestFab, mDonateFab;
    //fab text
    private TextView mDonateText, mRequestText;
    //a view which is used to get the blur background effect
    private View mShadowView;
    // animation variable to load all the animation files
    private Animation mFabOpenAnim, mFabCloseAnim, rotateOpen, rotateClose;
    //for top tab bar
    TabLayout mTabLayout;
    TabItem mDonationTab, mRequestTab;

    private boolean isOpen = false;
    private Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        context = getContext();
        PlasmaNetworking plasmaNetworking = new PlasmaNetworking();
        plasmaNetworking.GetPlasmaData(context);

        super.onCreate(savedInstanceState);

        //loading animation
        mFabOpenAnim = AnimationUtils.loadAnimation(context, R.anim.fab_open_anim);
        mFabCloseAnim = AnimationUtils.loadAnimation(context, R.anim.fab_close_anim);
        rotateOpen = AnimationUtils.loadAnimation(context, R.anim.rotate_open_anim);
        rotateClose = AnimationUtils.loadAnimation(context, R.anim.rotate_close_anim);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_plasma, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);

        //attaching the recyclerView to its items rows(adapter)
        RecyclerViewAdapter adapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        RecyclerView.ItemDecoration itemDecoration = new RecyclerViewAdapter.EqualSpaceItemDecoration(25);
        recyclerView.addItemDecoration(itemDecoration);

        // fab
        mAddFab = view.findViewById(R.id.addbtn);
        mRequestFab = view.findViewById(R.id.requestbtn);
        mDonateFab = view.findViewById(R.id.donatebtn);
        mDonateText = view.findViewById(R.id.donateText);
        mRequestText = view.findViewById(R.id.requestText);
        mShadowView = view.findViewById(R.id.shadowView);

        //tab bar
        mTabLayout = view.findViewById(R.id.tab_layout);
        mRequestTab = view.findViewById(R.id.request_tab);
        mDonationTab = view.findViewById(R.id.donation_tab);

        mAddFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fabAnimation();
            }
        });

        //setting a listener to a view so that if we click on blur background fab will automatically close
        mShadowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isOpen = true;
                fabAnimation();
            }
        });

        mRequestFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isOpen = true;
                fabAnimation();
                Toast.makeText(context, "Request clicked!",
                        Toast.LENGTH_LONG).show();
            }
        });
        mDonateFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isOpen = true;
                fabAnimation();
                Toast.makeText(context, "Donate clicked!",
                        Toast.LENGTH_LONG).show();
            }
        });

        //tab bar select listener
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(context, "selected "+ String.valueOf(tab.getPosition()),
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return view;
    }

// fuction to perform all the animations and opening , closing the fab
    private void fabAnimation(){
        if(isOpen){
            mAddFab.startAnimation(rotateClose);
            mRequestFab.startAnimation(mFabCloseAnim);
            mDonateFab.startAnimation(mFabCloseAnim);

            mShadowView.setVisibility(View.INVISIBLE);
            mRequestText.setVisibility(View.INVISIBLE);
            mDonateText.setVisibility(View.INVISIBLE);


            isOpen = false;
        } else {
            mAddFab.startAnimation(rotateOpen);
            mDonateFab.startAnimation(mFabOpenAnim);
            mRequestFab.startAnimation(mFabOpenAnim);

            mShadowView.setVisibility(View.VISIBLE);
            mDonateText.setVisibility(View.VISIBLE);
            mRequestText.setVisibility(View.VISIBLE);
            isOpen = true;
        }
    }
}