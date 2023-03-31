package com.example.movie.domain.responses;

import com.example.movie.domain.MovieList;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ListResponse {

    @SerializedName("results")
    private ArrayList<ListResponseObject> lists;

    public ArrayList<Integer> GetLists(){
        ArrayList<Integer> intlist = new ArrayList<>();

        for (ListResponseObject obj: lists
             ) {
            intlist.add(obj.GetListid());
        }

        return intlist; }
}

class ListResponseObject{
    @SerializedName("id")
    private Integer listid;

    public Integer GetListid(){return listid;}
}
