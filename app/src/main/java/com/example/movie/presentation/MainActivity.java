package com.example.movie.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.movie.R;
import com.example.movie.presentation.tutorial.ChildItem;
import com.example.movie.presentation.tutorial.ParentItem;
import com.example.movie.presentation.tutorial.ParentItemAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.example.movie.domain.Movie;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView nav;

    private static LinkedList<Movie> movies = new LinkedList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        new APIConn().execute();

//
//
//        setContentView(R.layout.activity_main);
//        // Initialize the RecyclerView.
//        RecyclerView recyclerView = findViewById(R.id.movies_recyclerview);
//
//        // Set the layout manager to the recyclerview
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
//        recyclerView.setHasFixedSize(true);
//
//        // Put recyclerview on homepage by genre
//        RecyclerView homepageRecycler = findViewById(R.id.movies_recyclerview);
//        GenreRecylcerViewAdapter gmAdapter = new GenreRecylcerViewAdapter(getApplicationContext(), movies, homepageRecycler);
//
//        // Put movies in recyclerview
//        MovieInGenreRecyclerViewAdapter adapter = new MovieInGenreRecyclerViewAdapter(getApplicationContext());
//        recyclerView.setAdapter(adapter);








        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView
                ParentRecyclerViewItem
                = findViewById(
                R.id.parent_recyclerview);

        // Initialise the Linear layout manager
        LinearLayoutManager
                layoutManager
                = new LinearLayoutManager(
                MainActivity.this);

        // Pass the arguments
        // to the parentItemAdapter.
        // These arguments are passed
        // using a method ParentItemList()
        ParentItemAdapter
                parentItemAdapter
                = new ParentItemAdapter(
                ParentItemList());

        // Set the layout manager
        // and adapter for items
        // of the parent recyclerview
        ParentRecyclerViewItem
                .setAdapter(parentItemAdapter);
        ParentRecyclerViewItem
                .setLayoutManager(layoutManager);
    }

    private List<ParentItem> ParentItemList()
    {
        List<ParentItem> itemList
                = new ArrayList<>();

        ParentItem item
                = new ParentItem(
                "Title 1",
                ChildItemList());
        itemList.add(item);
        ParentItem item1
                = new ParentItem(
                "Title 2",
                ChildItemList());
        itemList.add(item1);
        ParentItem item2
                = new ParentItem(
                "Title 3",
                ChildItemList());
        itemList.add(item2);
        ParentItem item3
                = new ParentItem(
                "Title 4",
                ChildItemList());
        itemList.add(item3);

        return itemList;
    }

    // Method to pass the arguments
    // for the elements
    // of child RecyclerView
    private List<ChildItem> ChildItemList()
    {
        List<ChildItem> ChildItemList
                = new ArrayList<>();

        ChildItemList.add(new ChildItem("Card 1"));
        ChildItemList.add(new ChildItem("Card 2"));
        ChildItemList.add(new ChildItem("Card 3"));
        ChildItemList.add(new ChildItem("Card 4"));

        return ChildItemList;
    }






//        nav = findViewById(R.id.bottom_navi_view);
//
//        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.home_nav_btn:
//                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.settings_nav_btn:
//                        Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.lists_nav_btn:
//                        Toast.makeText(MainActivity.this, "Lists", Toast.LENGTH_SHORT).show();
//                        break;
//                }
//                return false;
//            }
//        });
//
//
//
//    }

    public static void SetLinkedList(LinkedList<Movie> mList) {
        movies = mList;
    }



}