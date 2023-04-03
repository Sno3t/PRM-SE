package com.example.movie.presentation;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie.R;
import com.example.movie.domain.Genre;
import com.example.movie.domain.Movie;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    public static String BASE_URL = "https://api.themoviedb.org";
    public static int PAGE = 1;
    public static String API_KEY = "f3c365d45195979057ba40752d5f37ac";
    public static String GENRES = "action";
    private boolean isShowingSearchResults = false;
    BottomNavigationView nav;
    TextView searchBar;
    private GenreRecyclerViewAdapter genreRecyclerViewAdapter;
    private SearchResultsRecyclerViewAdapter searchResultsRecyclerViewAdapter;
    public static ArrayList<Movie> movies = new ArrayList<>();
    public static ArrayList<Genre> genres = new ArrayList<>();
    public static ArrayList<String> genreStrings = new ArrayList<>();
    public static ArrayList<Movie> searchResults = new ArrayList<>();
    private GenreRepository genreRepo = new GenreRepository();
//    private SearchResultsRepository searchResultRepo = new SearchResultsRepository();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        movies = genreRepo.getMoviesByGenre(18);
        genres = genreRepo.getGenres();
        for (Genre genre : genres) {
            genreStrings.add(genre.getName());
        }

        setContentView(R.layout.activity_main);
        // Initialize the RecyclerView.
        RecyclerView recyclerView = findViewById(R.id.movie_recyclerview);

        // Set the layout manager to the recyclerview
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        genreRecyclerViewAdapter = new GenreRecyclerViewAdapter(this, movies, genreStrings);
        genreRecyclerViewAdapter.setGenres(genreStrings);
        recyclerView.setAdapter(genreRecyclerViewAdapter);


        nav = findViewById(R.id.bottom_navi_view);

        SearchView simpleSearchView = findViewById(R.id.searchbar_movie); // initiate a search view
        if (simpleSearchView != null) {
            SearchResultsRepository searchResultRepo = new SearchResultsRepository(this, findViewById(R.id.movie_recyclerview));

            final String[] previousQuery = {""};
            simpleSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    if (!s.equals(previousQuery[0])) {
                        searchResultRepo.getSearchResults(s);

                        Log.d(TAG, "onQueryTextSubmit");
                        Log.d(TAG, s);

                        previousQuery[0] = s;
                    }
                    return true;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    if (!s.equals(previousQuery[0])) {
                        ArrayList<Movie> searchResults = searchResultRepo.getSearchResults(s);
                        searchResultRepo.setMoviesData(searchResults, true);

                        Log.d(TAG, "onQueryTextChange");
                        Log.d(TAG, s);

                        previousQuery[0] = s;
                    }

                    if (s.length() == 0) {
                        // Show the movies again
                        searchResultRepo.setMoviesData(searchResults, false);
                        recyclerView.setAdapter(genreRecyclerViewAdapter);
                    } else {
                        // Show the search results
                        searchResultsRecyclerViewAdapter = new SearchResultsRecyclerViewAdapter(MainActivity.this, searchResults);
                        searchResultRepo.setMoviesData(searchResults, true);
                        recyclerView.setAdapter(searchResultsRecyclerViewAdapter);

                    }
                    return true;
                }
            });
        }

        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch (item.getItemId()) {
                    case R.id.home_nav_btn:
                        intent = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.settings_nav_btn:
                        intent = new Intent(MainActivity.this, SettingsActivity.class);
                        Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.lists_nav_btn:
                        intent = new Intent(MainActivity.this, ListsActivity.class);
                        startActivity(intent);
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