package com.example.movie.presentation;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie.R;
import com.example.movie.domain.GenresFromAPI;
import com.example.movie.domain.Movie;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class GenreRecylcerViewAdapter extends RecyclerView.Adapter<GenreRecylcerViewAdapter.GenreMovieViewHolder> {

    private Context context;
    private ArrayList<Movie> movies;
    private static ArrayList<String> genreStrings = new ArrayList<>();

    String currentgenre;

    ArrayList<ArrayList<Movie>> listMoviesByGenre;

    private MovieInGenreRecyclerViewAdapter adapter;

    public GenreRecylcerViewAdapter(Context context, ArrayList<Movie> movies, String currencgenre, MovieInGenreRecyclerViewAdapter adapter) {
        this.movies = movies;

        this.context = context;

        listMoviesByGenre = new ArrayList<>();
        this.currentgenre =currencgenre;

        this.adapter = adapter;
    }

    @NonNull
    @Override
    public GenreRecylcerViewAdapter.GenreMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.genre_movie_item, parent, false);

        return new GenreMovieViewHolder(itemView, adapter);
    }

    @Override
    public void onBindViewHolder(@NonNull GenreRecylcerViewAdapter.GenreMovieViewHolder holder, int position) {

        holder.genre.setText(currentgenre);
        holder.movieRecylerView.setAdapter(new MovieInGenreRecyclerViewAdapter(context, movies));

    }



    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static void SetArraylist(ArrayList<String> mList) {
        genreStrings = mList;
        Log.d("ALERT", "Genres in list: " + genreStrings);
    }

    class GenreMovieViewHolder extends RecyclerView.ViewHolder {

        TextView genre;
        RecyclerView movieRecylerView;

        public GenreMovieViewHolder(@NonNull View itemView, MovieInGenreRecyclerViewAdapter adapter) {
            super(itemView);

            genre = itemView.findViewById(R.id.genre);
            movieRecylerView = itemView.findViewById(R.id.movie_item_recyclerview);
            movieRecylerView.setAdapter(adapter);
        }
    }

}
