package com.example.movie.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;

import com.example.movie.R;
import com.example.movie.domain.APIConn;
import com.example.movie.domain.Movie;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private static LinkedList<Movie> movies = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new APIConn().execute();

    }

    public static void SetLinkedList(LinkedList<Movie> mList) {
        movies = mList;

    }
}