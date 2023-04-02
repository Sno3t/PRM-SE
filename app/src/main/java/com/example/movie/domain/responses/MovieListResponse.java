package com.example.movie.domain.responses;

import com.example.movie.domain.Movie;
import com.example.movie.domain.MovieList;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class MovieListResponse {
    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String mlname;
    @SerializedName("results")
    private ArrayList<Movie> mlmovies;
    @SerializedName("description")
    private String mldescription;

    public Integer GetId(){
        return id;
    }

    public String GetName(){
        return mlname;
    }

    public ArrayList<Movie> GetMovies(){
        return mlmovies;
    }

    public String GetDesc(){
        return mldescription;
    }
}
