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

public class SearchResultsActivity extends AppCompatActivity {

    public static final String TAG = SearchResultsActivity.class.getSimpleName();
    public static ArrayList<Movie> movies = new ArrayList<>();
    EditText mEdit;

    public static ArrayList<Movie> searchResults = new ArrayList<>();
    private SearchResultsRecyclerViewAdapter searchResultsRecyclerViewAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get information from search bar
        // Upon entering something put that information through api search (keydown event)
        // Put results on the screen


        setContentView(R.layout.activity_results);
        SearchView simpleSearchView = findViewById(R.id.searchbar_movie2); // initiate a search view

        SearchResultsRepository searchResultRepo = new SearchResultsRepository(this, findViewById(R.id.search_result_movie_recyclerview));

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
                    searchResultRepo.getSearchResults(s);

                    Log.d(TAG, "onQueryTextChange");
                    Log.d(TAG, s);

                    previousQuery[0] = s;
                }
                return true;
            }
        });
    }
}