package com.example.movie.presentation;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import com.example.movie.R;
//<<<<<<< HEAD
//import com.example.movie.dal.ListRepoIBT;
//import com.example.movie.presentation.viemodel.MovieViewModel;
//
//import java.lang.reflect.Array;
//import java.util.ArrayList;
////import com.squareup.picasso.Picasso;
//=======
import com.example.movie.dal.ListRepoIBT;
import com.example.movie.domain.GenreRepoIBT;
import com.example.movie.domain.Movie;
import com.example.movie.presentation.viemodel.MovieViewModel;

import java.util.ArrayList;


public class MovieDetailsActivity extends AppCompatActivity {
    private static final String TAG = MovieDetailsActivity.class.getSimpleName();
    private TextView mTitle;
    private TextView mReleaseDate;
    private TextView mGenre;
    private TextView mLanguage;
    private TextView mLength;
    private TextView mDescription;
    private TextView mStatus;
    private TextView mBudget;
    private TextView mRevenue;
    private ImageView mImage;
    private ImageView mFavButton;
    private ImageView mAddToListButton;
    private RatingBar mRating;
    private boolean added = false;

    public static Integer movieId;

    public static ArrayList<Integer> mlIDs;
    public static ArrayList<CheckBox> checkBoxes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        mTitle = findViewById(R.id.title_movie_detail);
        mReleaseDate = findViewById(R.id.releasedate_movie);
        mGenre = findViewById(R.id.genre_movie);
        mLanguage = findViewById(R.id.language_movie);
        mLength = findViewById(R.id.Length);
        mDescription = findViewById(R.id.description);
        mStatus = findViewById(R.id.status);
        mBudget = findViewById(R.id.budget);
        mRevenue = findViewById(R.id.revenue);
        mImage = findViewById(R.id.movie_detail_image);
        mFavButton = findViewById(R.id.favorite_btn);
        mAddToListButton = findViewById(R.id.add_to_list_btn);
        mRating = findViewById(R.id.movie_detail_rating);

//<<<<<<< HEAD
//        Intent intent = getIntent();
//        movieId = intent.getIntExtra("MOVIE_ID", -2);
//        MovieViewModel model = new MovieViewModel(getApplication());
//=======
//>>>>>>> origin/details

        Intent intent = getIntent();
        int movieId = intent.getIntExtra("MOVIE_ID", 2);

        // Get movie by id
        // Set layout elements
        GenreRepoIBT genreRepoIBT = new GenreRepoIBT(mTitle,
                mReleaseDate, mGenre, mLanguage, mLength,
                mDescription, mStatus, mBudget, mRevenue, mRating, mImage);
        genreRepoIBT.GetMovieById(movieId);
    }

    public void addToFav(View view) {
        if(!added) {
            mFavButton.setImageResource(R.drawable.ic_filled_favorite_red);
            mFavButton.setTag(R.drawable.ic_filled_favorite_red);
            added = true;
        } else {
            mFavButton.setImageResource(R.drawable.ic_filled_favorite);
            mFavButton.setTag(R.drawable.ic_filled_favorite);
            added = false;
        }
    }

    public void openReviews(View view) {
        Intent intent = new Intent(this, ReviewsActivity.class);
        startActivity(intent);
    }

    public void addToList(View view) {
//        CheckBox list = new CheckBox(this);
//        list.setText("List");
//        CheckBox list2 = new CheckBox(this);
//        list2.setText("List");
//        CheckBox list3 = new CheckBox(this);
//        list3.setText("List");
        checkBoxes = new ArrayList<>();

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        layout.setGravity(Gravity.CENTER);
        layout.setPadding(8, 8, 8, 8);

        // Get lists
        ListRepoIBT listRepoIBT = new ListRepoIBT(this, layout, 0);
        listRepoIBT.getAllUserListOptions();

//        layout.addView(list);
//        layout.addView(list2);
//        layout.addView(list3);


    }
}
