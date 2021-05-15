package com.example.plasmate.model;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PlasmaDataModel {
    private ArrayList<String> mNames = new ArrayList<String>();
    private ArrayList<String> mEmails = new ArrayList<String>();
    private ArrayList<String> mPhoneNos = new ArrayList<String>();
    private ArrayList<String> mLocations = new ArrayList<String>();

    public static PlasmaDataModel fromJson(JSONObject jsonObject){

        try{
            PlasmaDataModel plasmaData = new PlasmaDataModel();
            JSONArray cast = jsonObject.getJSONArray("abridged_cast");
            for (int i=0; i<cast.length(); i++) {
                JSONObject actor = cast.getJSONObject(i);
                String name = actor.getString("name");
                String email = actor.getString("name");
                String phoneNo = actor.getString("name");
                String location = actor.getString("name");
                plasmaData.mNames.add(name);
                plasmaData.mEmails.add(email);
                plasmaData.mPhoneNos.add(phoneNo);
                plasmaData.mLocations.add(location);
            }
            return plasmaData;

        }catch(JSONException e){
            e.printStackTrace();
            return null;
        }
    }
}
