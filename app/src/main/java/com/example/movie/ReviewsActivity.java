package com.example.movie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;

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
        String addedReview = newReview.toString();
        ratingBar.getRating();

    }
}