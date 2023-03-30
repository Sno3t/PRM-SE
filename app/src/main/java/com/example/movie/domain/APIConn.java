package com.example.movie.domain;

import retrofit2.Call;
import retrofit2.http.GET;
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

}

