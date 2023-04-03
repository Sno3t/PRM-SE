package com.example.movie.presentation;

import android.content.Context;
import android.util.Log;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie.domain.APIConn;
import com.example.movie.domain.Genre;
import com.example.movie.domain.Movie;
import com.example.movie.domain.responses.JsonResponse;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchResultsRepository {

    public static final String TAG = SearchResultsRepository.class.getSimpleName();
    public static String BASE_URL = "https://api.themoviedb.org";
    public static String QUERY;
    public static String API_KEY = "f3c365d45195979057ba40752d5f37ac";
    public static ArrayList<Movie> movies = new ArrayList<>();
    private static WeakReference<Context> contextWR;
    private static WeakReference<RecyclerView> rViewWR;


    public SearchResultsRepository(Context contextWR, RecyclerView rViewWR) {
        SearchResultsRepository.contextWR = new WeakReference<>(contextWR);
        SearchResultsRepository.rViewWR = new WeakReference<>(rViewWR);

    }

    public ArrayList<Movie> getSearchResults(String query) {
        QUERY = query;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        APIConn apiConn = retrofit.create(APIConn.class);
        Call<JsonResponse> call = apiConn.getSearchResults(API_KEY, QUERY);

        movies.clear();

        call.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                JsonResponse movieJsonResponse = response.body();
                List<Movie> moviesList = movieJsonResponse.getMovies();
                if (!moviesList.isEmpty()) {
                    for (Movie movie : moviesList) {
                        int id = movie.getId();
                        double popularity = movie.getPopularity();
                        String title = movie.getTitle();
                        String url = movie.getUrl();
                        ArrayList<String> genres = new ArrayList<>();
                        genres = movie.getGenre();

                        Movie newMovie = new Movie(id, title, url, genres, popularity);
                        movies.add(newMovie);
                    }

                    movies.sort(Comparator.comparing(Movie::getPopularity).reversed());
//                    setMoviesData(movies);

                    Log.i(TAG, "Done searching for movies with query, " + movies.size());
                } else {
                    Log.d(TAG, "No results for search with query");
                }
            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                Log.e(TAG, "Error: " + t);
            }
        });

        return movies;
    }

    public void setMoviesData(ArrayList<Movie> movieLists, boolean searchActive) {
        movies = movieLists;

        if (searchActive) {
            SearchResultsRecyclerViewAdapter listAdapter = new SearchResultsRecyclerViewAdapter(contextWR.get(), movies);
            RecyclerView recyclerView = rViewWR.get();
//        recyclerView.setLayoutManager(new LinearLayoutManager(contextWR.get()));
            recyclerView.setLayoutManager(new GridLayoutManager(contextWR.get(), 2));
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(listAdapter);
        } else {
            SearchResultsRecyclerViewAdapter listAdapter = new SearchResultsRecyclerViewAdapter(contextWR.get(), movies);
            RecyclerView recyclerView = rViewWR.get();
//        recyclerView.setLayoutManager(new LinearLayoutManager(contextWR.get()));
            recyclerView.setLayoutManager(new GridLayoutManager(contextWR.get(), 1));
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(listAdapter);
        }


    }

}
