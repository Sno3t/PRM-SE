package com.example.movie.dal;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie.R;
import com.example.movie.domain.Movie;
import com.example.movie.domain.MovieList;
import com.example.movie.presentation.ListActivityViewAdapter;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ListRepoIBT{
    private static WeakReference<Context> contextWR;
    private static WeakReference<RecyclerView> rViewWR;

    private ListRepository repo;

    private static ArrayList<MovieList> mList;

    public ListRepoIBT(Context contextWR, RecyclerView rViewWR){
        this.contextWR = new WeakReference<>(contextWR);
        this.rViewWR = new WeakReference<>(rViewWR);

        this.repo = new ListRepository();

        this.mList = new ArrayList<>();
    }

    public void getAllUserLists() {
        repo.GetLists();
    }

    public void addUserList(String name, String description){
        repo.AddUserList(name, description);
    }

    public void addMovieToList(Integer listid, Integer movieid){
        repo.AddMovieToList(listid, movieid);
    }

    public void removeMovieFromList(Integer listid, Integer movieid){
        repo.RemoveMovieFromList(listid, movieid);
    }

    public void removeUserList(Integer id){
        repo.RemoveUserList(id);
    }

    public static void SetMLList(ArrayList<MovieList> movieLists){
        mList = movieLists;

        ListActivityViewAdapter listAdapter = new ListActivityViewAdapter(contextWR.get(), mList);
        RecyclerView recyclerView = rViewWR.get();
        recyclerView.setLayoutManager(new LinearLayoutManager(contextWR.get()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(listAdapter);
    }
}
