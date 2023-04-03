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
    private Date releaseDate;

    @SerializedName("runtime")
    private int length;
    @SerializedName("poster_path")
    private String url;
    @SerializedName("overview")
    private String description;
    //    private String director;
    @SerializedName("genres")
    private ArrayList<String> genre;
    @SerializedName("vote_average")
    private double userScore;
    //    private String cast;
    private String status;
    @SerializedName("spoken_languages")
    private String[] languages;
    private double budget;
    private double revenue;
    private double popularity;

    public Movie(int id, String title, String imageUrl, ArrayList<String> genres, double popularity) {
        this.id = id;
        this.title = title;
        this.url = imageUrl;
        this.genre = genres;
        this.popularity = popularity;
    }

    public Movie(int id,
                 String title, Date releaseDate,
                 int length, String url,
                 String description,
//                 String director,
                 ArrayList<String> genre,
                 double userScore,
//                 String cast,
                 String status,
                 String[] languages,
                 double popularity,
                 double budget,
                 double revenue) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.length = length;
        this.url = url;
        this.description = description;
        //this.director = director;
        this.genre = genre;
        this.userScore = userScore;
//        this.cast = cast;
        this.status = status;
        this.languages = languages;
        this.popularity = popularity;
        this.budget = budget;
        this.revenue = revenue;
    }


//    public Movie(String title, String genre){
//        this.title = title;
//        this.genre = genre;
//    }


    // For now_playing
    public Movie(String title, Date releaseDate,
                 String url,
                 String description,
                 ArrayList<String> genre,
                 double userScore,
                 String[] languages) throws ParseException {
        this.title = title;
        this.releaseDate = releaseDate;
        this.url = url;
        this.description = description;
        this.genre = genre;
        this.userScore = userScore;
        this.languages = languages;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
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

//    public String getDirector() {
//        return director;
//    }
//
//    public void setDirector(String director) {
//        this.director = director;
//    }


    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }

    public boolean containsGenre(String genreString) {
        if (genre.contains(genreString)) {
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

    public String[] getLanguage() {
        return languages;
    }

    public void setLanguage(String[] language) {
        this.languages = languages;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
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
