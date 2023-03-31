package com.example.movie.domain;

import java.util.ArrayList;
import java.util.Date;

public class MovieList {
    private String name;
    private ArrayList<Movie> listMovies;
    private String description;

    public MovieList(String name, ArrayList<Movie> listMovies, String description) {
        this.name = name;
        this.listMovies = listMovies;
        this.description = description;
    }

    public MovieList(String name, String description){
        this.name = name;
        this.listMovies = new ArrayList<>();
        this.description = description;
    }

    public void AddToList(Movie newMovie) {
        if (!listMovies.contains(newMovie)) {
            listMovies.add(newMovie);
        }
    }

    public void RemoveFromList(Movie removeMovie) {
        if (!listMovies.contains(removeMovie)) {
            listMovies.remove(removeMovie);
        }
    }

    public String getListName() {
        return name;
    }

    public void setListName(String listName) {
        this.name = listName;
    }

    public String getDateCreated() {
        return description;
    }

    public void setDateCreated(String description) {
        this.description = description;
    }

    public ArrayList<Movie> getMovielist(){
        return listMovies;
    }
}

