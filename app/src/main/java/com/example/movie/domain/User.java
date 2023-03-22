package com.example.movie.domain;

import java.util.ArrayList;

public class User {

    private ArrayList<MovieList> userLists;

    public User(){
        userLists = new ArrayList<>();
    }

    public void AddToList(MovieList newlist){
        if (!userLists.contains(newlist)){
            userLists.add(newlist);
        }
    }

    public void RemoveFromList(MovieList removeList){
        if (!userLists.contains(removeList)){
            userLists.remove(removeList);
        }
    }




}
