package com.example.movie.domain;

import com.example.movie.domain.responses.GenreResponse;
import com.example.movie.domain.responses.JsonResponse;
import com.example.movie.domain.responses.ListResponse;
import com.example.movie.domain.responses.MovieListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
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

    @GET("/4/list/{list_id}")
    Call<MovieListResponse> getLists(
            @Header("Authorization") String bearer_token,
            @Path("list_id") Integer path
//            @Query("api_key") String apiKey,
//            @Query("session_id") String sessionID
    );

    @GET("/3/account/18473348/lists")
    Call<ListResponse> getListID(
            @Query("api_key") String apiKey,
            @Query("session_id") String sessionID
    );
}

