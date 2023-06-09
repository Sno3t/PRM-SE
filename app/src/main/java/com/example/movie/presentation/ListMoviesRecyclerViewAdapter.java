package com.example.movie.presentation;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movie.R;
import com.example.movie.dal.ListRepoIBT;
import com.example.movie.domain.Movie;

import java.util.ArrayList;

public class ListMoviesRecyclerViewAdapter extends RecyclerView.Adapter<ListMoviesRecyclerViewAdapter.ListMoviesViewHolder> {

    private Context context;
    private ArrayList<Movie> listMovies;

    public ListMoviesRecyclerViewAdapter(Context context, ArrayList<Movie> listMovies) {
        this.context = context;
        this.listMovies = listMovies;
    }

    @NonNull
    @Override
    public ListMoviesRecyclerViewAdapter.ListMoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_item_list_item, parent, false);

        return new ListMoviesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListMoviesRecyclerViewAdapter.ListMoviesViewHolder holder, int position) {

        Movie movie = listMovies.get(position);
        Glide.with(context)
                .load("https://image.tmdb.org/t/p/original" + movie.getUrl())
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

        holder.removebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("ALERT", "Remove " + movie.getTitle());
                ListRepoIBT listRepoIBT = new ListRepoIBT(context, null);
                listRepoIBT.removeMovieFromList(ListActivity.listID , movie.getId());

                Intent intent = new Intent(context, ListActivity.class);
                intent.putExtra("ListID", ListActivity.listID);

                Log.d("ALERT", "Going to List " + ListActivity.listID);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (listMovies == null){
            return 0;
        }

        return listMovies.size();
    }

    class ListMoviesViewHolder extends RecyclerView.ViewHolder {

        private TextView movieTitle;
        private ImageView movieImage;

        private Button removebutton;


        public ListMoviesViewHolder(@NonNull View itemView) {
            super(itemView);
            movieTitle = itemView.findViewById(R.id.movie_title);
            movieImage = itemView.findViewById(R.id.movie_image);
            removebutton = itemView.findViewById(R.id.removeMovieButton);

        }
    }
}
