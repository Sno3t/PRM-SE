package com.example.movie.dal;

import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie.R;
import com.example.movie.domain.Movie;
import com.example.movie.domain.MovieList;
import com.example.movie.presentation.ListActivityViewAdapter;
import com.example.movie.presentation.ListMoviesRecyclerViewAdapter;
import com.example.movie.presentation.MovieDetailsActivity;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ListRepoIBT{
    private static WeakReference<Context> contextWR;
    private static WeakReference<RecyclerView> rViewWR;

    private static LinearLayout lLayoutWR;

    private ListRepository repo;

    private static ArrayList<MovieList> mList;

    public ListRepoIBT(Context contextWR, RecyclerView rViewWR){
        this.contextWR = new WeakReference<>(contextWR);
        this.rViewWR = new WeakReference<>(rViewWR);

        this.repo = new ListRepository();

        this.mList = new ArrayList<>();
    }

    public ListRepoIBT(Context contextWR, LinearLayout linearLayout, Integer ctornmbr){
        this.contextWR = new WeakReference<>(contextWR);
        this.lLayoutWR = linearLayout;

        this.repo = new ListRepository();

        this.mList = new ArrayList<>();
    }

    public void getAllUserLists() {
        repo.GetLists();
    }

    public void getAllUserListOptions(){
        repo.GetListOptions();
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

    public void getUserListById(Integer id){repo.GetListByID(id);}

    public static void SetMLList(ArrayList<MovieList> movieLists){
        mList = movieLists;

        ListActivityViewAdapter listAdapter = new ListActivityViewAdapter(contextWR.get(), mList);
        RecyclerView recyclerView = rViewWR.get();
        recyclerView.setLayoutManager(new GridLayoutManager(contextWR.get(), 2));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(listAdapter);
    }

    public static void SetMLDetails(MovieList ml){

        RecyclerView recyclerView = rViewWR.get();
        // Set the layout manager to the recyclerview
        recyclerView.setLayoutManager(new GridLayoutManager(contextWR.get(), 2));
        recyclerView.setHasFixedSize(true);
        ListMoviesRecyclerViewAdapter mAdapter = new ListMoviesRecyclerViewAdapter(contextWR.get(), ml.getMovielist());
        recyclerView.setAdapter(mAdapter);
    }

    public static void SetMLOptions(ArrayList<MovieList> mList){
        lLayoutWR.removeAllViews();
        MovieDetailsActivity.mlIDs = new ArrayList<>();
        ArrayList<String> mlstrings = new ArrayList<>();

        for (MovieList ml: mList
             ) {
            CheckBox cb = new CheckBox(contextWR.get());
            cb.setText(ml.getListName());
            lLayoutWR.addView(cb);
            MovieDetailsActivity.checkBoxes.add(cb);
            MovieDetailsActivity.mlIDs.add(ml.getId());

            mlstrings.add(ml.getListName());
        }

        String[] strings = mlstrings.toArray(new String[0]);
        ArrayList<String> list = new ArrayList<>();

        AlertDialog dialog = new AlertDialog.Builder(contextWR.get())
                .setTitle("Add to a list")
                // .setMessage("Select a list")
//                .setView(layout)
//                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
////                        mAdapter.notifyDataSetChanged();
////                        displayToast(newList.getListName() + " to List added");
//                        Log.d("ALERT", "index: " + which);
//
//                    }
//                })
                .setMultiChoiceItems(strings, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        String arr[] = strings;

                        if (b){
                            list.add(arr[i]);
                        }
                        else if (list.contains(arr[i])){
                            list.remove(arr[i]);
                        }
                    }
                })
                .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ArrayList<Integer> listids = new ArrayList<>();

                        for (String s : list) {
                            for (MovieList ml: mList) {
                                if (ml.getListName() == s){
                                    listids.add(ml.getId());
                                }
                            }
                        }

                        ListRepoIBT listRepoIBT = new ListRepoIBT(contextWR.get(), null);
                        for (Integer id: listids) {
                            listRepoIBT.addMovieToList(id, MovieDetailsActivity.movieId);
                        }

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .create();
        dialog.show();
    }
}
