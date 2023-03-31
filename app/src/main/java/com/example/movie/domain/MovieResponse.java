package com.example.movie.domain;

public class MovieResponse {
    private int id;
    private String title;
    private String poster_path;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public Movie getMovie() {
        return new Movie(id, title, poster_path);
    }
}
