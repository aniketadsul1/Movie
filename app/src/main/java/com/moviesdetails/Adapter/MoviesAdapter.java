package com.moviesdetails.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.moviesdetails.Model.Genres;
import com.moviesdetails.moviesdetails.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Gino Osahon on 14/03/2017.
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private List<Genres> Genres;
    private int rowLayout;
    private Context context;

    public MoviesAdapter(List<Genres> Genres, int rowLayout, Context context) {
        this.Genres = Genres;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    //A view holder inner class where we get reference to the views in the layout using their ID

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView itemname;


        public MovieViewHolder(View v) {
            super(v);
            moviesLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
            itemname = (TextView) v.findViewById(R.id.itemname);

        }
    }


    @Override
    public MoviesAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {

        holder.itemname.setText(Genres.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return Genres.size();
    }
}
