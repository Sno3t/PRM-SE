package com.example.movie.presentation;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movie.R;
import com.example.movie.domain.Movie;

import java.util.ArrayList;
import java.util.List;

public class GenreMovieAdapter extends RecyclerView.Adapter<GenreMovieAdapter.GenreMovieViewHolder> {

    private Context context;
    private final List<Movie> genreList = new ArrayList<>();
    private LayoutInflater mInflater;

    public GenreMovieAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public GenreMovieAdapter.GenreMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.genre_movie_item, parent, false);
        return new GenreMovieViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GenreMovieAdapter.GenreMovieViewHolder holder, int position) {
        // Genre genre = genreList.get(position);

//        holder.genre.setText(movie.getGenre());

    }

    @Override
    public int getItemCount() {
        return genreList.size();
    }

    class GenreMovieViewHolder extends RecyclerView.ViewHolder {

        TextView genre;
        RecyclerView movieRecylerView;

        public GenreMovieViewHolder(@NonNull View itemView) {
            super(itemView);

            genre = itemView.findViewById(R.id.genre);
            movieRecylerView = itemView.findViewById(R.id.movie_item_recyclerview);
        }
    }
}
