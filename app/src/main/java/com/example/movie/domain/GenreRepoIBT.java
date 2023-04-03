package com.example.movie.domain;

import android.media.Rating;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.movie.presentation.GenreRepository;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;

public class GenreRepoIBT {
    private static final String TAG = GenreRepoIBT.class.getSimpleName();
    private Movie movie;
    private GenreRepository repo;

    private static TextView mTitle;
    private static TextView mReleaseDate;
    private static TextView mGenre;
    private static TextView mLanguage;
    private static TextView mLength;
    private static TextView mDescription;
    private static TextView mStatus;
    private static TextView mBudget;
    private static TextView mRevenue;
    private static ImageView mImage;

//    private static ImageView mImage;
//    private static ImageView mFavButton;
//    private static ImageView mAddToListButton;
    private static RatingBar mRating;

    public GenreRepoIBT(TextView mTitle,
                        TextView mReleaseDate,
                        TextView mGenre,
                        TextView mLanguage,
                        TextView mLength,
                        TextView mDescription,
                        TextView mStatus,
                        TextView mBudget,
                        TextView mRevenue,
                        RatingBar mRatingBar,
                        ImageView mImage){

        this.repo = new GenreRepository();
        this.mTitle = mTitle;
        this.mReleaseDate = mReleaseDate;
        this.mGenre = mGenre;
        this.mLanguage = mLanguage;
        this.mLength = mLength;
        this.mDescription = mDescription;
        this.mStatus = mStatus;
        this.mBudget = mBudget;
        this.mRevenue = mRevenue;
        this.mRating = mRatingBar;
        this.mImage = mImage;
    }

    public void GetMovieById(Integer id){
        repo.getMovieById((id));
    }

    public static void SetLayout(Movie movie){
        if (movie != null){
            mTitle.setText(movie.getTitle());
            mReleaseDate.setText("Release date: " + movie.getReleaseDate());
            StringBuilder genreBuilder = new StringBuilder();
            for(int i = 0; i < movie.getGenres().size(); i++) {
                genreBuilder.append(movie.getGenres().get(i).getName());
                if(i != movie.getGenres().size() -1) {
                    genreBuilder.append(", ");
                }
            }
            mGenre.setText("Genres: " + genreBuilder);
            mLength.setText("Length: " + movie.getLength() + " minutes");
            mDescription.setText(movie.getDescription());
            mStatus.setText(movie.getStatus());
            mBudget.setText("Budget: $" + (int) movie.getBudget());
            mRevenue.setText("Revenue: $" + (int) movie.getRevenue());
            mLanguage.setText("Original Language: " + movie.getOriginalLanguage());
            Picasso.get().load("https://image.tmdb.org/t/p/original/" + movie.getUrl()).into(mImage);
            mRating.setRating((int) Math.round(movie.getUserScore()/2));
        }

    }
}
