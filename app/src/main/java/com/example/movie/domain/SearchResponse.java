package com.example.movie.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResponse {
    @SerializedName("searchResults")
    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }
}
