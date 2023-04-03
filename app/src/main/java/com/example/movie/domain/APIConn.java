package com.example.movie.domain;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIConn {
    @GET("/3/discover/movie")
    Call<JsonResponse> getMovies(
            @Query("api_key") String apiKey,
            @Query("page") int page,
            @Query("with_genres") int genres
    );

    @GET("/3/genre/movie/list")
    Call<GenreResponse> getGenres(@Query("api_key") String apiKey);


    @GET("/3/movie/{movie_id}")
    Call<MovieResponse> getMovieByIdFromApi(
            @Path("movie_id") int movieId,
            @Query("api_key") String apiKey);

    @GET("/3/search/multi")
    Call<JsonResponse> getSearchResults(@Query("api_key") String apiKey, @Query("query") String query);

}

