package com.example.api1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;

public class Favorites extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        bottomNavSelect(bottomNav, this);

    }

    public void bottomNavSelect(BottomNavigationView view, final Context context){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch(menuItem.getItemId()){
                    case R.id.videosNav:
                        Intent videoIntent = new Intent(context, MainActivity.class);
                        startActivity(videoIntent);
                        break;
                    case R.id.favoritesNav:

                        break;
                }
                return false;
            }
        });

    }

}
