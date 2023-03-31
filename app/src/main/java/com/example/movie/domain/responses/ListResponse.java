package com.example.movie.domain.responses;

import com.example.movie.domain.MovieList;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ListResponse {

    @SerializedName("lists")
    private ArrayList<MovieList> lists;

    public ArrayList<MovieList> GetLists(){return lists;}
}
