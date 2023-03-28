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
import com.example.movie.domain.APIConn;
import com.example.movie.domain.GenresFromAPI;
import com.example.movie.domain.Movie;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GenreMovieAdapter extends RecyclerView.Adapter<GenreMovieAdapter.GenreMovieViewHolder> {

    private Context context;
    private LinkedList<Movie> movies;
    private static ArrayList<String> genreStrings = new ArrayList<>();
    private LayoutInflater mInflater;
    private RecyclerView homepageRecycler;

    public GenreMovieAdapter(Context context, LinkedList<Movie> movies, RecyclerView homepageRecycler) {
        this.mInflater = LayoutInflater.from(context);
        this.homepageRecycler = homepageRecycler;
        this.movies = movies;

        this.context = context;
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


        // Make lists for genres (6)
            // Action, Adventure, Drama, Family, Horror, War
        ArrayList<String> searchGenres = new ArrayList<>();
        new GenresFromAPI().execute();

        ArrayList<HashMap<String, Movie>> listMoviesByGenre = new ArrayList<>();

        // Search 9 movies for first genres
        for (String genre: searchGenres) {
            GenreMovieViewHolder viewHolder = new GenreMovieViewHolder(homepageRecycler);
            viewHolder.genre.setText(genre);
            viewHolder.movieRecylerView = new RecyclerView(context);


            HashMap<String, Movie> genreList =  new HashMap<>();
            listMoviesByGenre.add(genreList);
            Integer counter = 0;
            for (Movie movie: movies) {
                if (movie.containsGenre(genre)){
                    genreList.put(
                            genre,
                            movie
                    );
                    counter++;
                }
                if (counter < 10){
                    // Add all movies in genrelist to viewholder.movierecycler

                    break;
                }
            }
        }



    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static void SetArraylist(ArrayList<String> mList) {
        genreStrings = mList;
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
