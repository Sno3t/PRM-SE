package com.example.movie.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JsonResponse {
    @SerializedName("results")
    private List<Movie> movies;

    public List<Movie> getMovies() { return movies; }
}
