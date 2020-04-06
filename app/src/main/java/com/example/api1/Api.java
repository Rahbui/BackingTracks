package com.example.api1;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static  com.example.api1.MainActivity.recycler;


public class Api {

    public static RequestQueue queue;
    private static JSONObject apiCall;
    private static JSONArray items;
    private static JSONObject snippet;
    private static JSONObject thumbnails;
    private static String id;
    private static String title;
    private static String description;
    private static String thumbnailUrl;
    public static ArrayList<youtubeLink> recyclerList = new ArrayList<>();

    public static synchronized void CallApi(final Context context, final String query){
        queue = Volley.newRequestQueue(context);
        String url ="https://www.googleapis.com/youtube/v3/search?part=snippet&q=" + query + "backingtrack&type=video&maxResults=50&key=";


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            apiCall = new JSONObject(response);
                            items = apiCall.getJSONArray("items");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        for(int i = 0; i < items.length(); i++){
                            try {
                                snippet = items.getJSONObject(i).getJSONObject("snippet");
                                id = items.getJSONObject(i).getJSONObject("id").getString("videoId");
                                title = snippet.getString("title");
                                description = snippet.getString("description");
                                thumbnails = snippet.getJSONObject("thumbnails");
                                thumbnailUrl = thumbnails.getJSONObject("high").getString("url");

                                recyclerList.add(new youtubeLink(id, thumbnailUrl, title, description));

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        linkAdapter adapter = new linkAdapter(context, recyclerList);
                        recycler.setAdapter(adapter);

                        MainActivity.playVideo(Api.recyclerList.get(0).getId(), MainActivity.youTubePlayerView);


                        if(query != ""){
                            adapter.notifyDataSetChanged();
                        }

                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("volleyError", error.getMessage());
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}
