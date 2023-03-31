package com.example.movie.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import com.example.movie.R;
import com.example.movie.domain.Movie;
import com.example.movie.presentation.viemodel.MovieViewModel;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Picasso;

public class MovieDetailsActivity extends AppCompatActivity {
    private static final String TAG = MovieDetailsActivity.class.getSimpleName();
    private TextView mTitle;
    private TextView mReleaseDate;
    private TextView mGenre;
    private TextView mLanguage;
    private TextView mDirector;
    private TextView mLength;
    private TextView mDescription;
    private TextView mStatus;
    private TextView mBudget;
    private TextView mRevenue;
    private ImageView mImage;
    private ImageView mFavButton;
    private ImageView mAddToListButton;
    private RatingBar mRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        mTitle = findViewById(R.id.title_movie_detail);
        mReleaseDate = findViewById(R.id.releasedate_movie);
        mGenre = findViewById(R.id.genre_movie);
        mLanguage = findViewById(R.id.language_movie);
        mDirector = findViewById(R.id.director);
        mLength = findViewById(R.id.Length);
        mDescription = findViewById(R.id.description);
        mStatus = findViewById(R.id.status);
        mBudget = findViewById(R.id.budget);
        mRevenue = findViewById(R.id.revenue);
        mImage = findViewById(R.id.movie_detail_image);
        mFavButton = findViewById(R.id.favorite_btn);
        mAddToListButton = findViewById(R.id.add_to_list_btn);
        mRating = findViewById(R.id.movie_detail_rating);

        Intent intent = getIntent();
        int movieId = intent.getIntExtra("MOVIE_ID", 2);
        MovieViewModel model = new MovieViewModel(getApplication());

        Movie movie = model.getMovieById(movieId);
        if(movie != null) {
            mTitle.setText(movie.getTitle());
//            mReleaseDate.setText(String.valueOf(movie.getReleaseDate().getTime()));
//            StringBuilder genreBuilder = new StringBuilder();
//            for(int i = 0; i < movie.getGenre().size(); i++) {
//                genreBuilder.append(movie.getGenre().get(i));
//                if(i != movie.getGenre().size()) {
//                    genreBuilder.append(", ");
//                }
//            }
//            mLanguage.setText(movie.getLanguage()[1]);
//            //mDirector.setText(movie.getDirector());
//            mLength.setText(movie.getLength());
//            mDescription.setText(movie.getDescription());
//            mStatus.setText(movie.getStatus());
//            mBudget.setText(String.valueOf(movie.getBudget()));
//            mRevenue.setText(String.valueOf(movie.getRevenue()));
//            Picasso.get().load(movie.getUrl()).into(mImage);
//            mRating.setNumStars((int) Math.round(movie.getUserScore()/2));
        }
    }

    public void addToFav(View view) {
        if (mFavButton.getColorFilter().equals(R.color.grey)) {
            mFavButton.setColorFilter(R.color.red);
            // Add to list functionality to be added
        } else if (mFavButton.getColorFilter().equals(R.color.red)) {
            mFavButton.setColorFilter(R.color.grey);
            // Remove from list functionality to be added
        } else {
            Log.e(TAG, "Movie niet toegevoegd aan favorites");
        }

    }

    public void openReviews(View view) {
        Intent intent = new Intent(this, ReviewsActivity.class);
        startActivity(intent);
    }
}
