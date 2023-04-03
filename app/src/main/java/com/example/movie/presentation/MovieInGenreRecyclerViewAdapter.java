package com.example.movie.presentation;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.movie.R;
import com.example.movie.domain.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieInGenreRecyclerViewAdapter extends RecyclerView.Adapter<MovieInGenreRecyclerViewAdapter.MovieViewHolder> {

    private static String TAG = MovieInGenreRecyclerViewAdapter.class.getSimpleName();
    private List<Movie> movies;
    private GenreRepository genreRepo;
    private Context context;
    private LayoutInflater inflater;
    private AdapterView.OnItemClickListener listener;
    private String genre;


    public MovieInGenreRecyclerViewAdapter(Context context, ArrayList<Movie> movies, String genre) {
        this.context = context;
        this.movies = movies;
        this.inflater = LayoutInflater.from(context);
        genreRepo = new GenreRepository();
        this.genre = genre;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_item, parent, false);

        return new MovieViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movies.get(position);
        Glide.with(context)
                .load("https://image.tmdb.org/t/p/original" + movie.getUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.movieImage);

        holder.movieTitle.setText(movie.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context = holder.itemView.getContext();
                Intent intent = new Intent(context, MovieDetailsActivity.class);
                intent.putExtra("MOVIE_ID", movie.getId());
                context.startActivity(intent);
            }
        });
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

            movieTitle = (TextView) itemView.findViewById(R.id.movie_title);
            movieImage = (ImageView) itemView.findViewById(R.id.movie_image);
        }
    }
}