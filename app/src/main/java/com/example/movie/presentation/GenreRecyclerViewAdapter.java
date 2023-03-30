package com.example.movie.presentation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie.R;
import com.example.movie.domain.Movie;

import java.util.ArrayList;

public class GenreRecyclerViewAdapter extends RecyclerView.Adapter<GenreRecyclerViewAdapter.GenreMovieViewHolder> {

    private Context context;
    private ArrayList<Movie> movies;
    private ArrayList<String> genreStrings;
    private GenreRepository genreRepo;
    private ArrayList<ArrayList<Movie>> listMoviesByGenre;

    public GenreRecyclerViewAdapter(Context context, ArrayList<Movie> movies, ArrayList<String> genres) {
        this.movies = movies;
        this.context = context;
        this.genreStrings = genres;
        listMoviesByGenre = new ArrayList<>();
    }

    @NonNull
    @Override
    public GenreMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.genre_movie_item, parent, false);

        return new GenreMovieViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GenreMovieViewHolder holder, int position) {
        holder.movieRecylerView.setAdapter(new MovieInGenreRecyclerViewAdapter(context, movies, genreStrings.get(position)));
        holder.movieRecylerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.movieRecylerView.setHasFixedSize(true);
        if(movies != null) {
            holder.genre.setText(genreStrings.get(position));
        }

    }

    void setGenres(ArrayList<String> genres) {
        genreStrings = genres;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class GenreMovieViewHolder extends RecyclerView.ViewHolder {

        TextView genre;
        RecyclerView movieRecylerView;

        public GenreMovieViewHolder(@NonNull View itemView) {
            super(itemView);
            genre = (TextView) itemView.findViewById(R.id.genre);
            movieRecylerView = (RecyclerView) itemView.findViewById(R.id.movie_item_recyclerview);
        }
    }

}