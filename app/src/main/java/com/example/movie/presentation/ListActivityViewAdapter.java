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
import com.example.movie.domain.Movie;
import com.example.movie.domain.MovieList;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListActivityViewAdapter extends RecyclerView.Adapter<ListActivityViewAdapter.ListActivityViewHolder> {
    Context context;
    ArrayList<MovieList> listml;

    public ListActivityViewAdapter(Context context, ArrayList<MovieList> listml){
        this.context = context;
        this.listml = listml;
    }

    @NonNull
    @Override
    public ListActivityViewAdapter.ListActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new ListActivityViewAdapter.ListActivityViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListActivityViewAdapter.ListActivityViewHolder holder, int position) {
        MovieList ml = listml.get(position);
        Movie firstmovie = ml.getMovielist().get(0);

        holder.listname.setText(ml.getListName());

        Glide.with(context)
                .load("https://image.tmdb.org/t/p/original" + firstmovie.getUrl())
                .into(holder.image);

        holder.removebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Remove from list
                Log.d("ALERT", "Removing list");
            }
        });
    }

    @Override
    public int getItemCount() {
        return listml.size();
    }

    class ListActivityViewHolder extends RecyclerView.ViewHolder {

        TextView listname;
        ImageView image;
        Button removebutton;

        public ListActivityViewHolder(@NonNull View itemView) {
            super(itemView);
            listname = (TextView) itemView.findViewById(R.id.list_name_text);
            image = (ImageView) itemView.findViewById(R.id.list_image);
            removebutton = (Button) itemView.findViewById(R.id.list_remove_button);
        }
    }
}
