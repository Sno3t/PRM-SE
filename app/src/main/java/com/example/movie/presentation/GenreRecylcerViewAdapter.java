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
    private LayoutInflater mInflater;
    private RecyclerView homepageRecycler;

    ArrayList<ArrayList<Movie>> listMoviesByGenre;

    public GenreRecylcerViewAdapter(Context context, ArrayList<Movie> movies, RecyclerView homepageRecycler) {
        this.mInflater = LayoutInflater.from(context);
        this.homepageRecycler = homepageRecycler;
        this.movies = movies;

        this.context = context;

        listMoviesByGenre = new ArrayList<>();

    }

    @NonNull
    @Override
    public GenreRecylcerViewAdapter.GenreMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.genre_movie_item, parent, false);

        return new GenreMovieViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GenreRecylcerViewAdapter.GenreMovieViewHolder holder, int position) {
//        holder.genre.setText(movie.getGenre());


        // Make lists for genres (6)
            // Action, Adventure, Drama, Family, Horror, War

        ArrayList<String> searchGenres = new ArrayList<>();
        // new GenresFromAPI().execute();

        listMoviesByGenre = new ArrayList<>();

        // Search 9 movies for first genres
        for (String genre: searchGenres) {
//            GenreMovieViewHolder viewHolder = new GenreMovieViewHolder(homepageRecycler);
//            holder.movieRecylerView.setAdapter(new MovieInGenreRecyclerViewAdapter(context, movies));
//            holder.genre.setText(genre);
//            viewHolder.movieRecylerView = new RecyclerView(context);


            ArrayList<Movie> genreList =  new ArrayList<>();
            listMoviesByGenre.add(genreList);
            Integer counter = 0;
            for (Movie movie: movies) {
                if (movie.containsGenre(genre)){
                    genreList.add(
                            movie
                    );
                    counter++;
                }
                if (counter < 10){
                    Log.d("ALERT", "Movies in " + genre + " list: " + genreList.size());
                    break;

                }
            }
            // Add all movies in genrelist to viewholder.movierecycler


            String mcurrent = genreStrings.get(position);
            holder.genre.setText(mcurrent);
            holder.movieRecylerView.setAdapter(new MovieInGenreRecyclerViewAdapter(context, genreList));
            Log.d("ALERT", "Movies in " + "genre" + " list: " + genreList.size());

        }




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

        public GenreMovieViewHolder(@NonNull View itemView) {
            super(itemView);

            genre = new TextView(context);
            movieRecylerView = new RecyclerView(context);;
        }
    }

}
