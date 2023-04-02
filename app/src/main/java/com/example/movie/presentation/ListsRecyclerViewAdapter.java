package com.example.movie.presentation;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie.R;
import com.example.movie.domain.Movie;
import com.example.movie.domain.MovieList;

import java.util.ArrayList;

public class ListsRecyclerViewAdapter extends RecyclerView.Adapter<ListsRecyclerViewAdapter.ListsViewHolder>{

    private Context context;
    private ArrayList<MovieList> lists;

    public ListsRecyclerViewAdapter(Context context, ArrayList<MovieList> lists) {
        this.context = context;
        this.lists = lists;
    }

    @NonNull
    @Override
    public ListsRecyclerViewAdapter.ListsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new ListsRecyclerViewAdapter.ListsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListsRecyclerViewAdapter.ListsViewHolder holder, int position) {
        MovieList list = lists.get(position);

        holder.listName.setText(list.getListName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context = holder.itemView.getContext();
                Intent intent = new Intent(context, ListActivity.class);
                intent.putExtra("LIST_NAME", list.getListName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    class ListsViewHolder extends RecyclerView.ViewHolder {

        private ImageView listImage;
        private TextView listName;

        public ListsViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
