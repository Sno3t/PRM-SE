package com.example.movie.presentation;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.movie.R;
import com.example.movie.domain.Movie;

import java.util.ArrayList;

public class SearchResultsActivity extends AppCompatActivity {

    public static ArrayList<Movie> movies = new ArrayList<>();
    EditText mEdit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get information from search bar
        // Upon entering something put that information through api search (keydown event)
        // Put results on the screen

        setContentView(R.layout.activity_main);
        mEdit = (EditText) findViewById(R.id.searchbar_movie);

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

