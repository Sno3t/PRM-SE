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
//        if (ml.getMovielist().size() > 0){
//            Movie firstmovie = ml.getMovielist().get(0);
//
//            Glide.with(context)
//                    .load("https://image.tmdb.org/t/p/original" + firstmovie.getUrl())
//                    .into(holder.image);
//        }

        if (ml != null){
            holder.listname.setText(ml.getListName());
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ListActivity.class);
                intent.putExtra("MovieID", ml.getId());

                Log.d("ALERT", "Going to List " + ml.getId());

                context.startActivity(intent);
            }
        });



//        holder.removebutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Remove from list
//                Log.d("ALERT", "Removing list");
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return listml.size();
    }

    class ListActivityViewHolder extends RecyclerView.ViewHolder {

        TextView listname;

        public ListActivityViewHolder(@NonNull View itemView) {
            super(itemView);
            listname = (TextView) itemView.findViewById(R.id.name_list);

        }
    }
}
