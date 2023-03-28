package com.example.movie.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;

public class Movie {

    private String title;
    private Date releaseDate;
    private int length;
    private String url;
    private String description;
    private String director;
    private ArrayList<String> genre;
    private int userScore;
    private String cast;
    private String status;
    private String language;
    private double budget;
    private double revenue;

    public Movie(String title, Date releaseDate,
                 int length, String url,
                 String description,
                 String director,
                 ArrayList<String>  genre,
                 int userScore,
                 String cast,
                 String status,
                 String language,
                 double budget,
                 double revenue){
        this.title = title;
        this.releaseDate = releaseDate;
        this.length = length;
        this.url = url;
        this.description = description;
        this.director = director;
        this.genre = genre;
        this.userScore = userScore;
        this.cast = cast;
        this.status = status;
        this.language = language;
        this.budget = budget;
        this.revenue = revenue;
    }

    // For now_playing
    public Movie(String title, Date releaseDate,
                 String url,
                 String description,
                 ArrayList<String>  genre,
                 int userScore,
                 String language) throws ParseException {
        this.title = title;
        this.releaseDate = releaseDate;
        this.url = url;
        this.description = description;
        this.genre = genre;
        this.userScore = userScore;
        this.language = language;
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public ArrayList<String>  getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }

    public int getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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
}
