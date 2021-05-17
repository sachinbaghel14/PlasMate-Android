package com.example.plasmate.model;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class PlasmaNetworking {
    private static final String TAG = "PlasmaNetworking";
    public void GetPlasmaData(Context context){
        RequestQueue queue = Volley.newRequestQueue(context);
        String url ="http://plasmate.atwebpages.com/api";

        // Request a string response from the provided URL.
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG,"Response: " + response.toString());
                        PlasmaDataModel plasmaData = PlasmaDataModel.fromJson(response);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(context, "Network Connection Error " +String.valueOf(error),
//                        Toast.LENGTH_LONG).show();
                Log.i(TAG,"error"+ String.valueOf(error));
            }
        });

        queue.add(jsonObjectRequest);
    }
}
