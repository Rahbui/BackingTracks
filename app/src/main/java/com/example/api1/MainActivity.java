package com.example.api1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import com.example.api1.Api.*;
import com.example.api1.linkAdapter;

public class MainActivity extends YouTubeBaseActivity {

    public static RecyclerView recycler;
    public static YouTubePlayerView youTubePlayerView;
    public static YouTubePlayer thisyouTubePlayer;
    SearchView searchView;
    Context context;
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = findViewById(R.id.recycler);
        youTubePlayerView = findViewById(R.id.youtubePlayerView);
        bottomNav = findViewById(R.id.bottomNav);
        assert recycler != null;
        recycler.setLayoutManager(new LinearLayoutManager(this));
        searchView = findViewById(R.id.searchView);
        context = this;

        Api.CallApi(this, "");


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Api.recyclerList.clear();
                Api.CallApi(context, query);
                Log.d("query", query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        /*bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch(menuItem.getItemId()){
                    case R.id.videosNav:
                        break;
                    case R.id.favoritesNav:
                        Intent intent = new Intent(context, Favorites.class);
                        startActivity(intent);
                        break;
                }
                return false;
            }
        });*/
        bottomNavSelect(bottomNav, context);

    }

    public void bottomNavSelect(BottomNavigationView view, final Context context){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch(menuItem.getItemId()){
                    case R.id.videosNav:
                        break;
                    case R.id.favoritesNav:
                        Intent favoriteIntent = new Intent(context, Favorites.class);
                        startActivity(favoriteIntent);
                        break;
                }
                return false;
            }
        });

    }

    public static void playVideo(final String videoId, YouTubePlayerView youTubePlayerView) {
        //initialize youtube player view
        youTubePlayerView.initialize("AIzaSyAmSTX1ZlgOGuscAqM53YbqHpiJ4jgLujE",
                new YouTubePlayer.OnInitializedListener() {
                    @Override
                    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                        YouTubePlayer youTubePlayer, boolean b) {
                        youTubePlayer.cueVideo(videoId);
                        thisyouTubePlayer = youTubePlayer;
                    }

                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                        YouTubeInitializationResult youTubeInitializationResult) {

                    }
                });
    }
}
