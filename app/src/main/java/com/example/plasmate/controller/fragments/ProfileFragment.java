package com.example.plasmate.controller.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.plasmate.R;
import com.example.plasmate.controller.EditProfileActivity;
import com.example.plasmate.controller.HomeActivity;
import com.example.plasmate.controller.LoginActivitty;
import com.example.plasmate.controller.MainActivity;

public class ProfileFragment extends Fragment {
    private Context context;

    private static final String TAG = "ProfileFragment";
    //A layout which is used as a button
    private LinearLayout mEditProfile, mNotification, mAboutUs, mLogOut;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        context = getContext();
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // layout buttons
        mEditProfile = view.findViewById(R.id.editProfile);
        mNotification = view.findViewById(R.id.notification);
        mAboutUs = view.findViewById(R.id.aboutUs);
        mLogOut = view.findViewById(R.id.logOut);

        //onclick listners
        mEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Edit Profile");
                Intent intent = new Intent(context, EditProfileActivity.class);
                startActivity(intent);
            }
        });

        mNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Notification");
            }
        });

        mAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "About Us");
            }
        });

        mLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "Log out");
                AlertDialog alertDialog = new AlertDialog.Builder(context).create();
                alertDialog.setTitle("Log out");
                alertDialog.setMessage("Are you sure you want to logout?");
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "CANCEL",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                Toast.makeText(context, "Log out!",
                                        Toast.LENGTH_LONG).show();
                            }
                        });
                alertDialog.show();
            }
        });

        return view;
    }
}