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
            JSONArray cast = jsonObject.getJSONArray("plasma_list");
            for (int i=0; i<cast.length(); i++) {
                JSONObject plasmaList = cast.getJSONObject(i);
                String name = plasmaList.getString("Name1");
                String email = plasmaList.getString("EmailId");
                String phoneNo = plasmaList.getString("PhoneNo");
                String location = plasmaList.getString("City");
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
