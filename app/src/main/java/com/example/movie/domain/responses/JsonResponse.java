package com.example.movie.domain.responses;

import com.example.movie.domain.Movie;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JsonResponse {
    @SerializedName("results")
    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }
}
