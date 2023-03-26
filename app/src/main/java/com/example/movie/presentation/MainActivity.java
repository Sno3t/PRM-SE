package com.example.movie.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;

import com.example.movie.R;
import com.example.movie.domain.APIConn;
import com.example.movie.domain.Movie;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        APIConn conn = new APIConn(findViewById(R.id.recyclerview));
        conn.GetMovieByID();
    }
}