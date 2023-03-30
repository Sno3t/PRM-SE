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
        RecyclerView recyclerView = findViewById(R.id.movies_recyclerview);

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

//
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        RecyclerView
//                ParentRecyclerViewItem
//                = findViewById(
//                R.id.parent_recyclerview);
//
//        // Initialise the Linear layout manager
//        LinearLayoutManager
//                layoutManager
//                = new LinearLayoutManager(
//                MainActivity.this);
//
//        // Pass the arguments
//        // to the parentItemAdapter.
//        // These arguments are passed
//        // using a method ParentItemList()
//        ParentItemAdapter
//                parentItemAdapter
//                = new ParentItemAdapter(
//                ParentItemList());
//
//        // Set the layout manager
//        // and adapter for items
//        // of the parent recyclerview
//        ParentRecyclerViewItem
//                .setAdapter(parentItemAdapter);
//        ParentRecyclerViewItem
//                .setLayoutManager(layoutManager);
//    }
//
//    private List<ParentItem> ParentItemList()
//    {
//        List<ParentItem> itemList
//                = new ArrayList<>();
//
//        ParentItem item
//                = new ParentItem(
//                "Title 1",
//                ChildItemList());
//        itemList.add(item);
//        ParentItem item1
//                = new ParentItem(
//                "Title 2",
//                ChildItemList());
//        itemList.add(item1);
//        ParentItem item2
//                = new ParentItem(
//                "Title 3",
//                ChildItemList());
//        itemList.add(item2);
//        ParentItem item3
//                = new ParentItem(
//                "Title 4",
//                ChildItemList());
//        itemList.add(item3);
//
//        return itemList;
//    }
//
//    // Method to pass the arguments
//    // for the elements
//    // of child RecyclerView
//    private List<ChildItem> ChildItemList()
//    {
//        List<ChildItem> ChildItemList
//                = new ArrayList<>();
//
//        ChildItemList.add(new ChildItem("Card 1"));
//        ChildItemList.add(new ChildItem("Card 2"));
//        ChildItemList.add(new ChildItem("Card 3"));
//        ChildItemList.add(new ChildItem("Card 4"));
//
//        return ChildItemList;
//    }







}