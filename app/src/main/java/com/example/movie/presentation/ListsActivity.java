package com.example.movie.presentation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.movie.R;
import com.example.movie.domain.Movie;
import com.example.movie.domain.MovieList;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class ListsActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    private Spinner genreSpinner;
    private BottomNavigationView nav;
    private ListsRecyclerViewAdapter mAdapter;
    private ArrayList<MovieList> lists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lists);

        genreSpinner = findViewById(R.id.filter_spinner);
        if (genreSpinner != null) {
            genreSpinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.genre_filter, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        if (genreSpinner != null) {
            genreSpinner.setAdapter(adapter);
        }



        nav = findViewById(R.id.bottom_navi_view);

        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch (item.getItemId()) {
                    case R.id.home_nav_btn:
                        intent = new Intent(ListsActivity.this, MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(ListsActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.settings_nav_btn:
                        intent = new Intent(ListsActivity.this, SettingsActivity.class);
                        startActivity(intent);
                        Toast.makeText(ListsActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.lists_nav_btn:
                        intent = new Intent(ListsActivity.this, ListsActivity.class);
                        startActivity(intent);
                        Toast.makeText(ListsActivity.this, "Lists", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });


        // Initialize the RecyclerView.
        RecyclerView recyclerView = findViewById(R.id.lists_recyclerview);

        // Set the layout manager to the recyclerview
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setHasFixedSize(true);
        mAdapter = new ListsRecyclerViewAdapter(this, lists);
        recyclerView.setAdapter(mAdapter);

    }

    public void addNewList(View view) {
//        lists.add(new MovieList())

        Toast.makeText(this, "Add New List (Not available in Demo)", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        String spinnerLabel = adapterView.getItemAtPosition(position).toString();
        displayToast(spinnerLabel);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    // Tijdelijke methode
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
}