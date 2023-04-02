package com.example.movie.presentation;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie.R;
import com.example.movie.domain.Movie;

import java.util.ArrayList;
import java.util.Date;

public class SearchResultsActivity extends AppCompatActivity {

    public static final String TAG = SearchResultsActivity.class.getSimpleName();
    public static ArrayList<Movie> movies = new ArrayList<>();
    EditText mEdit;

    public static ArrayList<Movie> searchResults = new ArrayList<>();
    private SearchResultsRepository searchResultRepo = new SearchResultsRepository();
    private SearchResultsRecyclerViewAdapter searchResultsRecyclerViewAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get information from search bar
        // Upon entering something put that information through api search (keydown event)
        // Put results on the screen

        setContentView(R.layout.activity_results);

//        SearchView simpleSearchView = (SearchView) findViewById(R.id.searchbar_movie2); // inititate a search view

//        CharSequence query = simpleSearchView.getQuery(); // get the query string currently in the text field
        searchResults = searchResultRepo.getSearchResults("batman");
        Log.d(TAG, "aaaaaaaaaaaaa" + String.valueOf(searchResults.size()));

        ArrayList<String> a = new ArrayList<String>();
        searchResults.add(new Movie(1, "movie name", "/pB8BM7pdSp6B6Ih7QZ4DrQ3PmJK.jpg", a));


//        RecyclerView searchResultsRecyclerView = findViewById(R.id.searchbar_movie2);
        RecyclerView searchResultsRecyclerView = findViewById(R.id.search_result_movie_recyclerview);
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

//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        setSupportActionBar(toolbarHome)

    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//
//
//        setContentView(R.layout.activity_main);
////        String searchBar = findViewById(R.layout)
//
//
////        setContentView(R.layout.);
//
////        setContentView(R.layout.activity_lists);
////
////        genreSpinner = findViewById(R.id.filter_spinner);
////        if (genreSpinner != null) {
////            genreSpinner.setOnItemSelectedListener(this);
////        }
////        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
////                R.array.genre_filter, android.R.layout.simple_spinner_item);
////        adapter.setDropDownViewResource
////                (android.R.layout.simple_spinner_dropdown_item);
////        if (genreSpinner != null) {
////            genreSpinner.setAdapter(adapter);
////        }
//
//    }
}

