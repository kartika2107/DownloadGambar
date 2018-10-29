package com.eka.downloadgambar;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<Movie> movies;

    public MovieAdapter(@NonNull List<Movie> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_movie, viewGroup, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int i) {
        Movie movie = movies.get(i);

        movieViewHolder.title.setText(movie.getTitle());
        movieViewHolder.overview.setText(movie.getOverview());
        movieViewHolder.vote.setText(String.valueOf(movie.getVote()));

        Picasso.with(movieViewHolder.itemView.getContext())
                .load(Constant.IMAGE_URL + movie.getImage())
                .into(movieViewHolder.poster);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


    class MovieViewHolder extends RecyclerView.ViewHolder {

        private ImageView poster;
        private TextView title;
        private TextView overview;
        private TextView vote;


        MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            poster = itemView.findViewById(R.id.poster);
            title = itemView.findViewById(R.id.title_movie);
            overview = itemView.findViewById(R.id.overview_movie);
            vote = itemView.findViewById(R.id.vote_movie);
        }
    }
}
