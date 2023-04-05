package com.example.movie.dal;

import android.util.Log;

import com.example.movie.domain.APIConn;
import com.example.movie.domain.Genre;
import com.example.movie.domain.Movie;
import com.example.movie.domain.MovieResponse;
import com.example.movie.domain.responses.GenreResponse;
import com.example.movie.domain.responses.JsonResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GenreRepository {

    private static final String TAG = GenreRepository.class.getSimpleName();

    private static String BASE_URL = "https://api.themoviedb.org";
    private static int PAGE = 1;
    private static String API_KEY = "f3c365d45195979057ba40752d5f37ac";
    private static int GENRES;
    private static ArrayList<Movie> movies = new ArrayList<>();
    private static ArrayList<Genre> genres = new ArrayList<>();
    private static int ID;
    private static Movie movieById;

    public ArrayList<Movie> getMoviesByGenre(int genre) {
        this.GENRES = genre;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        APIConn apiConn = retrofit.create(APIConn.class);

        Call<JsonResponse> call = apiConn.getMovies(API_KEY, PAGE, GENRES);

        call.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                JsonResponse movieJsonResponse = response.body();
                List<Movie> moviesList = movieJsonResponse.getMovies();

                for (Movie movie : moviesList) {
                    Log.d(TAG, movie.getTitle());
                    int id = movie.getId();
                    double popularity = movie.getPopularity();
                    String title = movie.getTitle();
                    String url = movie.getUrl();
                    ArrayList<Genre> genres = new ArrayList<>();
                    genres = movie.getGenres();


                    Movie newMovie = new Movie(id, title, url, genres, popularity);
                    movies.add(newMovie);
                }



                Log.d(TAG, "done searching for movies, " + movies.size());
                Log.d(TAG, movies.toString());
            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                Log.e(TAG, "Error: " + t.toString());
            }
        });

        return movies;
    }

    public ArrayList<Genre> getGenres() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        APIConn apiConn = retrofit.create(APIConn.class);
        Call<GenreResponse> call = apiConn.getGenres(API_KEY);

        call.enqueue(new Callback<GenreResponse>() {
            @Override
            public void onResponse(Call<GenreResponse> call, Response<GenreResponse> response) {
                GenreResponse genreResponse = response.body();
                List<Genre> genresList = genreResponse.getGenres();
                for (Genre genre : genresList) {
                    genres.add(genre);
                    Log.i(TAG, "genre added: " + genre.getName() + ", " + genre.getId());
                }


                Log.i(TAG, "amount of genres: " + genres.size());
            }

            @Override
            public void onFailure(Call<GenreResponse> call, Throwable t) {
                Log.e(TAG, "Error: " + t.toString());
            }
        });


        return genres;
    }

    public Movie getMovieById(int id) {
        this.ID = id;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        APIConn apiConn = retrofit.create(APIConn.class);
        Call<MovieResponse> call = apiConn.getMovieByIdFromApi(ID, API_KEY);

        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                MovieResponse movieResponse = response.body();
                movieById = movieResponse.getMovie();

                GenreRepoIBT.SetLayout(movieById);

                Log.d(TAG, "Movie title: " + movieById.getTitle());
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.e(TAG, "Error: " + t.toString());
            }
        });

        return movieById;
    }
}
