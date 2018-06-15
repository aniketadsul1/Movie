package com.moviesdetails.moviesdetails;

import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.moviesdetails.Adapter.MoviesAdapter;
import com.moviesdetails.Model.GenreResponse;
import com.moviesdetails.Model.Genres;
import com.moviesdetails.rest.APIClient;
import com.moviesdetails.rest.APIInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    // TODO - insert your themoviedb.org API KEY here
    private final static String API_KEY = "f17e9c5e6c34ad9dc2bf6aab852c0cc7";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        if (API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY from themoviedb.org first!", Toast.LENGTH_LONG).show();
            return;
        }
        fetchGenerwiseMovie();
    }

    private void fetchGenerwiseMovie() {
        APIInterface apiService =
                APIClient.getClient().create(APIInterface.class);

        Call<GenreResponse> call = apiService.getMovieslist(API_KEY);
        call.enqueue(new Callback<GenreResponse>() {
            @Override
            public void onResponse(Call<GenreResponse> call, Response<GenreResponse> response) {
                int statusCode = response.code();
                List<Genres> genres = response.body().getGenres();
                recyclerView.setAdapter(new MoviesAdapter(genres, R.layout.list_item_movie, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<GenreResponse> call, Throwable t) {
                // Log error here since request failed
            }
        });
    }


}
