package com.example.movie.presentation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import android.view.MenuItem;
import android.widget.Toast;

import com.example.movie.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.os.Debug;
import android.util.Log;

import com.example.movie.R;
import com.example.movie.domain.APIConn;
import com.example.movie.domain.Movie;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView nav;

    private static LinkedList<Movie> movies = new LinkedList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new APIConn().execute();



        setContentView(R.layout.activity_main);
        // Initialize the RecyclerView.
        RecyclerView recyclerView = findViewById(R.id.movies_recyclerview);

        // Set the layout manager to the recyclerview
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        recyclerView.setHasFixedSize(true);

        MovieAdapter adapter = new MovieAdapter(getApplicationContext());
        recyclerView.setAdapter(adapter);


        nav = findViewById(R.id.bottom_navi_view);

        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home_nav_btn:
                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.settings_nav_btn:
                        Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.lists_nav_btn:
                        Toast.makeText(MainActivity.this, "Lists", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });



    }

    public static void SetLinkedList(LinkedList<Movie> mList) {
        movies = mList;
    }



}