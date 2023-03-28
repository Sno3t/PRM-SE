package com.example.movie.domain;

import androidx.room.Entity;

@Entity(tableName = "genre")
public class genre {

    private int id;
    private String name;


    public genre(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
