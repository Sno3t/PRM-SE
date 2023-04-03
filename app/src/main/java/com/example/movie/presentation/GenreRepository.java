package com.example.movie.presentation;

import android.util.Log;

import com.example.movie.domain.APIConn;
import com.example.movie.domain.Movie;
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

public class GenreRepository {

    public static final String TAG = GenreRepository.class.getSimpleName();

    public static String BASE_URL = "https://api.themoviedb.org";
    public static int PAGE = 1;
    public static String API_KEY = "f3c365d45195979057ba40752d5f37ac";
    public static int GENRES;
    public static ArrayList<Movie> movies = new ArrayList<>();
    public static ArrayList<String> genres = new ArrayList<>();

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
                    ArrayList<String> genres = new ArrayList<>();
                    genres = movie.getGenre();


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

    public ArrayList<String> getGenres() {
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
                    genres.add(genre.getName());
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

    public int genreStringToId(int genreString) {
        switch (genreString) {
            case 0:
                return 28;
            case 1:
                return 12;
            case 2:
                return 16;
            case 3:
                return 35;
            case 4:
                return 80;
            case 5:
                return 99;
            case 6:
                return 18;
            case 7:
                return 10751;
            case 8:
                return 14;
            case 9:
                return 36;
            case 10:
                return 27;
            case 11:
                return 10402;
            case 12:
                return 9648;
            case 13:
                return 10749;
            case 14:
                return 878;
            case 15:
                return 10770;
            case 16:
                return 53;
            case 17:
                return 10752;
            case 18:
                return 37;
            default:
                return -1;
        }
    }
}
