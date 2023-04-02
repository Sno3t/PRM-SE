package com.example.movie.presentation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.movie.R;
import com.example.movie.dal.GenreRepository;
import com.example.movie.dal.ListRepoIBT;
import com.example.movie.dal.ListRepository;
import com.example.movie.domain.Genre;
import com.example.movie.domain.Movie;
import com.example.movie.domain.MovieList;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class ListsActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {


    private Spinner genreSpinner;
    private BottomNavigationView nav;

    public ArrayList<MovieList> lists = new ArrayList<>();
    private ListRepository repo = new ListRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lists);


        // Spinner
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


        // get lists
        lists = new ArrayList<MovieList>();
        new ListRepoIBT(this, findViewById(R.id.lists_recyclerview)).execute();


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
    }

    public void addNewList(View view) {
        Toast.makeText(this, "Add New List (Not available in Demo)", Toast.LENGTH_SHORT).show();

        MovieList newml = new MovieList("", "");
        newml.AddToList(new Movie(0,"Movie title", "", new ArrayList<String>()));

        // Check if list isn't null, add to API

        lists.add(newml);


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