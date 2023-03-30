package com.example.movie.presentation.viemodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.movie.domain.Movie;

import java.util.List;

public class MovieViewModel extends AndroidViewModel {
    private LiveData<List<Movie>> mAllMovies;

    public MovieViewModel(Application application) {
        super(application);
    }
}
