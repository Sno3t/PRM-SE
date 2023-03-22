package com.example.movie.domain;

import java.util.ArrayList;

public class MovieList {
    private String listName;
    private ArrayList<Movie> listMovies;

    public MovieList(String listName, ArrayList<Movie> listMovies){
        this.listName = listName;
        this.listMovies = listMovies;
    }

    public void AddToList(Movie newMovie){
        if (!listMovies.contains(newMovie)){
            listMovies.add(newMovie);
        }
    }

    public void RemoveFromList(Movie removeMovie){
        if (!listMovies.contains(removeMovie)){
            listMovies.remove(removeMovie);
        }
    }
}
