package com.example.movie.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import com.example.movie.R;
import com.example.movie.domain.Movie;
import com.example.movie.presentation.viemodel.MovieViewModel;
import com.squareup.picasso.Picasso;

public class MovieDetailsActivity extends AppCompatActivity {
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
    private ImageView mStar1;
    private ImageView mStar2;
    private ImageView mStar3;
    private ImageView mStar4;
    private ImageView mStar5;
    private EditText mReviewText;

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
        mStar1 = findViewById(R.id.star_1);
        mStar2 = findViewById(R.id.star_2);
        mStar3 = findViewById(R.id.star_3);
        mStar4 = findViewById(R.id.star_4);
        mStar5 = findViewById(R.id.star_5);
        mReviewText = findViewById(R.id.review_movie);

        Intent intent = getIntent();
        int movieId = intent.getIntExtra("MEAL_ID", -1);
        MovieViewModel model = new MovieViewModel(getApplication());

        LiveData<Movie> movieLiveData = model.getMovieById(movieId);

        movieLiveData.observe(this, movie -> {
            if(movie != null) {
                mTitle.setText(movie.getTitle());
                mReleaseDate.setText(String.valueOf(movie.getReleaseDate().getTime()));
                StringBuilder genreBuilder = new StringBuilder();
                for(int i = 0; i < movie.getGenre().size(); i++) {
                    genreBuilder.append(movie.getGenre().get(i));
                    if(i != movie.getGenre().size()) {
                        genreBuilder.append(", ");
                    }
                }
                mLanguage.setText(movie.getLanguage());
                mDirector.setText(movie.getDirector());
                mLength.setText(movie.getLength());
                mDescription.setText(movie.getDescription());
                mStatus.setText(movie.getStatus());
                mBudget.setText(String.valueOf(movie.getBudget()));
                mRevenue.setText(String.valueOf(movie.getRevenue()));

                Picasso.get().load(movie.getUrl()).into(mImage);
            }
        });
    }
}
