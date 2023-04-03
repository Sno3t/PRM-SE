package com.example.movie.domain;

import java.util.ArrayList;
import java.util.Date;

public class MovieList {
    private Integer id;
    private String name;
    private ArrayList<Movie> listMovies;
    private String dateCreated;
    private String listName;
    private String description;

    public MovieList(Integer id, String name, ArrayList<Movie> listMovies, String description) {
        this.id = id;
        this.name = name;
    }

    public MovieList(String listName, ArrayList<Movie> listMovies, String dateCreated) {
        this.listName = listName;
        this.listMovies = listMovies;
        this.description = description;
    }

    public MovieList(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.listMovies = new ArrayList<>();
        this.description = description;
    }

    public MovieList(String listName, String dateCreated) {
        this.listName = listName;
        this.dateCreated = dateCreated;
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
        return dateCreated;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Movie> getMovielist() {
        return listMovies;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;

    }
}

