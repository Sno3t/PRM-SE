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
    TextView searchBar;
    private GenreRecyclerViewAdapter genreRecyclerViewAdapter;
    private SearchResultsRecyclerViewAdapter searchResultsRecyclerViewAdapter;
    public static ArrayList<Movie> movies = new ArrayList<>();
    public static ArrayList<Movie> searchResults = new ArrayList<>();
    public static ArrayList<String> genres = new ArrayList<>();
    private GenreRepository genreRepo = new GenreRepository();
    private SearchResultsRepository searchResultRepo = new SearchResultsRepository();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        movies = genreRepo.getMoviesByGenre(18);
//        genres = genreRepo.getGenres();
//
//        setContentView(R.layout.activity_main);
//        // Initialize the RecyclerView.
//        RecyclerView recyclerView = findViewById(R.id.movie_recyclerview);
//
//        // Set the layout manager to the recyclerview
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setHasFixedSize(true);
//        genreRecyclerViewAdapter = new GenreRecyclerViewAdapter(this, movies, genres);
//        genreRecyclerViewAdapter.setGenres(genres);
//        recyclerView.setAdapter(genreRecyclerViewAdapter);

        nav = findViewById(R.id.bottom_navi_view);


//        //---------------------------


        SearchView simpleSearchView = (SearchView) findViewById(R.id.searchbar_movie); // inititate a search view

//        CharSequence query = simpleSearchView.getQuery(); // get the query string currently in the text field
        searchResults = searchResultRepo.getSearchResults("batman");

        RecyclerView searchResultsRecyclerView = findViewById(R.id.movie_recyclerview);
        searchResultsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        searchResultsRecyclerView.setHasFixedSize(true);
        searchResultsRecyclerViewAdapter = new SearchResultsRecyclerViewAdapter(this, searchResults);
        searchResultsRecyclerView.setAdapter(searchResultsRecyclerViewAdapter);


//        searchBar.findViewById(R.id.searchbar_movie);
//        searchBar.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                // Show results of api in view
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
//        Intent intent = new Intent(MainActivity.this, MainActivity.class);
////        startActivity(intent);
//        //---------------------------


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