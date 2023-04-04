package com.example.movie.presentation.viemodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.movie.dal.GenreRepository;
import com.example.movie.domain.Movie;

import java.util.List;

public class MovieViewModel extends AndroidViewModel {
    private LiveData<List<Movie>> mAllMovies;
    private GenreRepository repo;

    public MovieViewModel(Application application) {
        super(application);
        repo = new GenreRepository();
    }

    public Movie getMovieById(int id) {
        return repo.getMovieById((id));
    }
}
