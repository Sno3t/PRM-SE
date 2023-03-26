package com.example.movie.domain;

public class Movie {

    public String title;
    public String description;
    public Integer runtime;

    public Movie(String title, String description, Integer runtime){
        this.title = title;
        this.description = description;
        this.runtime = runtime;
    }
}
