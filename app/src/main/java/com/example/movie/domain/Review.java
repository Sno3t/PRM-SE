package com.example.movie.domain;

public class Review {

    private String content;
    private int rating;
    private User user;
    private Movie movie;

    public Review(String content, int rating, User user, Movie movie) {
        this.content = content;
        this.rating = rating;
        this.user = user;
        this.movie = movie;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
