package com.example.movie.presentation;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movie.R;
import com.example.movie.domain.Movie;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private static String TAG= MovieAdapter.class.getSimpleName();
    private List<Movie> movies = new ArrayList<>();
    private Context context;
    private AdapterView.OnItemClickListener listener;

    public MovieAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder holder, int position) {
        Movie movie = movies.get(position);
        Glide.with(context)
                .load(movie.getUrl())
                .into(holder.movieImage);

        holder.movieTitle.setText(movie.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context = holder.itemView.getContext();
                Intent intent = new Intent(context, MovieDetailsActivity.class);
                // vervang get title en movietitle met id
                intent.putExtra("MOVIE_TITLE", movie.getTitle());
                context.startActivity(intent);
            }
        });


//        movies.add(new Movie("a", "b"));
//        movies.add(new Movie("a2", "b1"));
//        movies.add(new Movie("a3", "b2"));
//        movies.add(new Movie("a4", "b3"));

//// Create a HashMap to hold movie lists for each genre
//        HashMap<String, ArrayList<Movie>> movieMap = new HashMap<>();
//
//// Initialize an empty ArrayList for each genre
//        for (String genre : genreArray) {
//            movieMap.put(genre, new ArrayList<Movie>());
//        }
//
//// Populate the movie lists based on genre
//        for (Movie movie : movies) {
//            String genre = movie.getGenre();
//            ArrayList<Movie> movieList = movieMap.get(genre);
//            movieList.add(movie);
//        }
//
//// Print the movies for each genre
//        for (String genre : genreArray) {
//            ArrayList<Movie> movieList = movieMap.get(genre);
//            System.out.println(genre + ":");
//            for (Movie movie : movieList) {
//                System.out.println(" - " + movie.getTitle());
//            }
//        }




    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        TextView movieTitle;
        ImageView movieImage;


        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            movieTitle = itemView.findViewById(R.id.movie_title);
            movieImage = itemView.findViewById(R.id.movie_image);
        }
    }
}
