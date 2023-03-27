package com.example.movie.presentation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.movie.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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



}