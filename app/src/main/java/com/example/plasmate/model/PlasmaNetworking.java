package com.example.plasmate.model;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class PlasmaNetworking {
    public void GetPlasmaData(Context context){
        RequestQueue queue = Volley.newRequestQueue(context);
        String url ="http://plasmate.atwebpages.com/api";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.i("test", "yeee my chal gya");
                        Log.i("response msg", response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Network Connection Error " +String.valueOf(error),
                        Toast.LENGTH_LONG).show();
                Log.i("error", String.valueOf(error));
            }
        });

        queue.add(stringRequest);
    }
}
