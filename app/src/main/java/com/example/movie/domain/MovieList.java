package com.example.movie.domain;

import java.util.ArrayList;
import java.util.Date;

public class MovieList {
    private String listName;
    private ArrayList<Movie> listMovies;
    private Date dateCreated;

    public MovieList(String listName, ArrayList<Movie> listMovies, Date dateCreated) {
        this.listName = listName;
        this.listMovies = listMovies;
        this.dateCreated = dateCreated;
    }

    public MovieList(String listName){
        this.listName = listName;
        this.listMovies = new ArrayList<>();
        this.dateCreated = new Date();
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

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public ArrayList<Movie> getMovielist(){
        return listMovies;
    }
}
