package com.example.movie.domain;

import java.util.ArrayList;
import java.util.Date;

public class MovieResponse {
    private int id;
    private String title;
    private String release_date;
    private ArrayList<Genre> genres;
    private int runtime;
    private String overview;
    private String status;
    private int budget;
    private int revenue;
    private String original_language;
    private String poster_path;
    private double vote_average;
    private double popularity;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public String getRelease_date() { return release_date; }
    public int getRuntime() { return runtime; }
    public String getOverview() { return overview; }
    public String getStatus() { return status; }
    public ArrayList<Genre> getGenres() { return genres; }
    public int getRevenue() { return revenue; }
    public String getOriginal_language() { return original_language; }
    public int getBudget() { return budget; }
    public String getPoster_path() {
        return poster_path;
    }
    public double getVote_Average() { return vote_average; }
    public double getPopularity() { return popularity; }

    public Movie getMovie() {
        return new Movie(id, title, release_date, genres, runtime, overview, status, budget, revenue, original_language, poster_path, vote_average, popularity);
    }
}
