package com.example.movie.domain;

import java.util.ArrayList;
import java.util.Date;

public class MovieList {
    private String listName;
    private ArrayList<Movie> listMovies;
    private String dateCreated;

    public MovieList(String listName, ArrayList<Movie> listMovies, String dateCreated) {
        this.listName = listName;
        this.listMovies = listMovies;
        this.dateCreated = dateCreated;
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
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
}
