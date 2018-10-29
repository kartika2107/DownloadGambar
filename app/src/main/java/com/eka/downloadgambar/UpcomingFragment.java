package com.eka.downloadgambar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class UpcomingFragment extends Fragment {

    private RecyclerView recyclerView;
    private MovieAdapter adapter;

    private List<Movie> movies = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_upcoming, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.listMovie);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setHasFixedSize(false);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new MovieAdapter(movies);
        recyclerView.setAdapter(adapter);

        new DownloadMovieAsync(getActivity()){
            @Override
            protected void onPostExecute(List<Movie> movies) {
                super.onPostExecute(movies);
                UpcomingFragment.this.movies.clear();
                UpcomingFragment.this.movies.addAll(movies);
                adapter.notifyDataSetChanged();
            }
        }.execute(Constant.BASE_URL+"movie/upcoming");
    }
}
