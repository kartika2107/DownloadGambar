package com.eka.downloadgambar;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class DownloadMovieAsync extends AsyncTask<String, Void, List<Movie>> {

    private WeakReference<Context> context;

    public DownloadMovieAsync(Context context) {
        this.context = new WeakReference<>(context);
    }

    @Override
    protected List<Movie> doInBackground(String... strings) {
        String url = strings[0] + "?api_key=" + Constant.API_KEY;
        List<Movie> movies = new ArrayList<>();

        try {
            HttpsURLConnection urlConnection = (HttpsURLConnection) new URL(url).openConnection();
            BufferedReader br =
                    new BufferedReader(
                            new InputStreamReader(urlConnection.getInputStream()));
            String input;
            StringBuilder sb = new StringBuilder();

            while ((input = br.readLine()) != null) {
                sb.append(input);
            }
            br.close();

            JSONObject jsonObject = new JSONObject(sb.toString());


            JSONArray array = jsonObject.getJSONArray("results");

            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                Movie movie = new Movie(
                        object.optInt("id"),
                        object.optString("title"),
                        object.optString("overview"),
                        object.optString("poster_path"),
                        object.optInt("vote_average")
                );
                movies.add(movie);
            }

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context.get(), "Error saat mengunduh film", Toast.LENGTH_SHORT).show();
        }

        return movies;
    }
}
