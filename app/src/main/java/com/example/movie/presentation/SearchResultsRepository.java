package com.example.movie.presentation;

import android.util.Log;

import com.example.movie.domain.APIConn;
import com.example.movie.domain.Genre;
import com.example.movie.domain.GenreResponse;
import com.example.movie.domain.JsonResponse;
import com.example.movie.domain.Movie;

import java.util.ArrayList;
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

    public ArrayList<Movie> getSearchResults(String query) {
        QUERY = query;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        APIConn apiConn = retrofit.create(APIConn.class);

        Call<JsonResponse> call = apiConn.getSearchResults(API_KEY, QUERY);


        call.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                JsonResponse movieJsonResponse = response.body();
                List<Movie> moviesList = movieJsonResponse.getMovies();

                if (moviesList.isEmpty()) {
                    for (Movie movie : moviesList) {
                        Log.d(TAG, movie.getTitle());
                        int id = movie.getId();
                        String title = movie.getTitle();
                        String url = movie.getUrl();
                        ArrayList<String> genres = new ArrayList<>();
                        genres = movie.getGenre();

                        Movie newMovie = new Movie(id, title, url, genres);
                        movies.add(newMovie);
                    }

                    Log.d(TAG, "done searching for movies with query, " + movies.size());
                    Log.d(TAG, movies.toString());
                } else {
                    Log.d(TAG, "No results");
                }
            }


            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                Log.e(TAG, "Error: " + t);
            }
        });

        return movies;
    }
}
