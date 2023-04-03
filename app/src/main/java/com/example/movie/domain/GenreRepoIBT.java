package com.example.movie.domain;

import android.media.Rating;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.movie.presentation.GenreRepository;

public class GenreRepoIBT {
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
                        RatingBar ratingBar){
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
        this.mRating = ratingBar;


    }

    public void GetMovieById(Integer id){
        repo.getMovieById((id));
    }

    public static void SetLayout(Movie movie){
        if (movie != null){
            mTitle.setText(movie.getTitle());
            mReleaseDate.setText(String.valueOf(movie.getReleaseDate().getTime()));
            StringBuilder genreBuilder = new StringBuilder();
            for(int i = 0; i < movie.getGenre().size(); i++) {
                genreBuilder.append(movie.getGenre().get(i));
                if(i != movie.getGenre().size()) {
                    genreBuilder.append(", ");
                }
            }
            mLanguage.setText(movie.getLanguage()[1]);
            //mDirector.setText(movie.getDirector());
            mLength.setText(movie.getLength());
            mDescription.setText(movie.getDescription());
            mStatus.setText(movie.getStatus());
            mBudget.setText(String.valueOf(movie.getBudget()));
            mRevenue.setText(String.valueOf(movie.getRevenue()));
            // Picasso.get().load(movie.getUrl()).into(mImage);
            mRating.setNumStars((int) Math.round(movie.getUserScore()/2));
        }

    }
}
