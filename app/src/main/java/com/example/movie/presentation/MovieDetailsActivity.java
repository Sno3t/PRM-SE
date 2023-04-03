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

import com.example.movie.R;
import com.example.movie.presentation.viemodel.MovieViewModel;
//import com.squareup.picasso.Picasso;

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
        int movieId = intent.getIntExtra("MEAL_ID", -1);
        MovieViewModel model = new MovieViewModel(getApplication());

//        LiveData<Movie> movieLiveData = model.getMovieById(movieId);
//
//        movieLiveData.observe(this, movie -> {
//            if(movie != null) {
//                mTitle.setText(movie.getTitle());
//                mReleaseDate.setText(String.valueOf(movie.getReleaseDate().getTime()));
//                StringBuilder genreBuilder = new StringBuilder();
//                for(int i = 0; i < movie.getGenre().size(); i++) {
//                    genreBuilder.append(movie.getGenre().get(i));
//                    if(i != movie.getGenre().size()) {
//                        genreBuilder.append(", ");
//                    }
//                }
//                mLanguage.setText(movie.getLanguage());
//                mDirector.setText(movie.getDirector());
//                mLength.setText(movie.getLength());
//                mDescription.setText(movie.getDescription());
//                mStatus.setText(movie.getStatus());
//                mBudget.setText(String.valueOf(movie.getBudget()));
//                mRevenue.setText(String.valueOf(movie.getRevenue()));
//                Picasso.get().load(movie.getUrl()).into(mImage);
//                mRating.setNumStars(movie.getUserScore()/2);
//            }
//        });
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

    public void addToList(View view) {
        CheckBox list = new CheckBox(this);
        list.setText("List");
        CheckBox list2 = new CheckBox(this);
        list2.setText("List");
        CheckBox list3 = new CheckBox(this);
        list3.setText("List");
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        layout.setGravity(Gravity.CENTER);
        layout.setPadding(8, 8, 8, 8);
        layout.addView(list);
        layout.addView(list2);
        layout.addView(list3);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Add to a list")
                .setMessage("Select a list")
                .setView(layout)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

//                        mAdapter.notifyDataSetChanged();
//                        displayToast(newList.getListName() + " to List added");
                    }
                })
                .setNegativeButton("Cancel", null)
                .create();
        dialog.show();
    }
}
