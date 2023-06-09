package com.example.movie.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;

import com.example.movie.R;

public class ReviewsActivity extends AppCompatActivity {

    private EditText newReview;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);

        newReview = findViewById(R.id.new_review_movie);
        ratingBar = findViewById(R.id.custom_rating_bar);
    }

    public void submitReview(View view) {
        String addedReview = newReview.getText().toString();
        float rating = ratingBar.getRating();

        newReview.setText("");
        ratingBar.setRating(0);
    }
}