package com.example.movie.presentation;


import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie.R;
import com.example.movie.domain.Movie;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    public static String BASE_URL = "https://api.themoviedb.org";
    public static int PAGE = 1;
    public static String API_KEY = "f3c365d45195979057ba40752d5f37ac";
    public static String GENRES = "action";
    BottomNavigationView nav;
    private GenreRecyclerViewAdapter mAdapter;
    public static ArrayList<Movie> movies = new ArrayList<>();
    public static ArrayList<String> genres = new ArrayList<>();
    private GenreRepository genreRepo = new GenreRepository();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        movies = genreRepo.getMoviesByGenre(18);
        genres = genreRepo.getGenres();

        setContentView(R.layout.activity_main);
        // Initialize the RecyclerView.
        RecyclerView recyclerView = findViewById(R.id.movie_recyclerview);

        // Set the layout manager to the recyclerview
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        mAdapter = new GenreRecyclerViewAdapter(this, movies, genres);
        mAdapter.setGenres(genres);
        recyclerView.setAdapter(mAdapter);

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

    public static void SetLinkedList(ArrayList<Movie> mList) {
        movies = mList;
        Log.d("ALERT", "movies: " + movies.size());
    }
}