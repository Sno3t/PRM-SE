package com.example.movie.presentation;

import static com.example.movie.presentation.MainActivity.movies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.movie.R;
import com.example.movie.domain.Movie;

import java.text.ParseException;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private ListMoviesRecyclerViewAdapter mAdapter;
    private ArrayList<Movie> mMovies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        // Initialize the RecyclerView.
        RecyclerView recyclerView = findViewById(R.id.movie_list_recyclerview);

        // Set the layout manager to the recyclerview
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setHasFixedSize(true);
        mAdapter = new ListMoviesRecyclerViewAdapter(this, mMovies);
        recyclerView.setAdapter(mAdapter);
    }

    public void shareList(View view) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, mMovies);
        shareIntent.putExtra(Intent.EXTRA_TEXT, "List of Movies");
        startActivity(Intent.createChooser(shareIntent, "Share via"));
    }
}