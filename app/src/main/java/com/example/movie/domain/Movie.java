package com.example.movie.domain;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

@Entity(tableName = "movie")
public class Movie {

    @PrimaryKey
    private int id;
    private String title;
    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("runtime")
    private int length;
    @SerializedName("poster_path")
    private String url;
    @SerializedName("overview")
    private String description;
    @SerializedName("genres")
    private ArrayList<Genre> genres;
    @SerializedName("vote_average")
    private double userScore;
    //    private String cast;
    private String status;
    @SerializedName("original_language")
    private String originalLanguage;
    private int budget;
    private double revenue;

    public Movie(int id,
                 String title,
                 String releaseDate,
                 ArrayList<Genre> genres,
                 int runtime,
                 String tagline,
                 String status,
                 int budget,
                 int revenue,
                 String originalLanguage,
                 String imageUrl,
                 double userScore) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.genres = genres;
        this.length = runtime;
        this.description = tagline;
        this.status = status;
        this.budget = budget;
        this.revenue = revenue;
        this.originalLanguage = originalLanguage;
        this.url = imageUrl;
        this.userScore = userScore;
    }

    public Movie(int id, String title, String imageUrl, ArrayList<Genre> genres) {
        this.id = id;
        this.title = title;
        this.url = imageUrl;
        this.genres = genres;
    }

    public Movie(int id,
                 String title,
                 String releaseDate,
                 int length,
                 String url,
                 String description,
                 ArrayList<Genre> genres,
                 double userScore,
//                 String cast,
                 String status,
                 String originalLanguage,
                 int budget,
                 double revenue) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.length = length;
        this.url = url;
        this.description = description;
        this.genres = genres;
        this.userScore = userScore;
//        this.cast = cast;
        this.status = status;
        this.originalLanguage = originalLanguage;
        this.budget = budget;
        this.revenue = revenue;
    }


//    public Movie(String title, String genre){
//        this.title = title;
//        this.genre = genre;
//    }


    // For now_playing
    public Movie(String title,
                 String releaseDate,
                 String url,
                 String description,
                 ArrayList<Genre> genres,
                 double userScore,
                 String originalLanguage) throws ParseException {
        this.title = title;
        this.releaseDate = releaseDate;
        this.url = url;
        this.description = description;
        this.genres = genres;
        this.userScore = userScore;
        this.originalLanguage = originalLanguage;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    public void setGenre(ArrayList<Genre> genre) {
        this.genres = genre;
    }

    public boolean containsGenre(String genreString) {
        if (genres.contains(genreString)) {
            return true;
        }
        return false;
    }

    public double getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

//    public String getCast() {
//        return cast;
//    }
//
//    public void setCast(String cast) {
//        this.cast = cast;
//    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
