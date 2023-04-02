package com.example.movie.domain;

import com.example.movie.domain.responses.GenreResponse;
import com.example.movie.domain.responses.JsonResponse;
import com.example.movie.domain.responses.ListResponse;
import com.example.movie.domain.responses.MovieListResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
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

    // List methods
    @GET("/4/list/{list_id}")
    Call<MovieListResponse> getLists(
            @Header("Authorization") String bearer_token,
            @Path("list_id") Integer path
    );

    @GET("/3/account/18473348/lists")
    Call<ListResponse> getListID(
            @Query("api_key") String apiKey,
            @Query("session_id") String sessionID
    );

    // Add new list
    @POST("https://api.themoviedb.org/3/list")
    Call<ListResponse> createList(
            @Query("api_key") String apiKey,
            @Query("session_id") String sessionid,
            // https://stackoverflow.com/questions/21398598/how-to-post-raw-whole-json-in-the-body-of-a-retrofit-request
            @Body() RequestBody rbody
    );

    // Add movie to list
    @POST("https://api.themoviedb.org/3/list/{list_id}/add_item")
    Call<ListResponse> addMovieToList(
            @Query("api_key") String apiKey,
            @Query("session_id") String sessionid,
            @Path("list_id") Integer path,

            @Body() RequestBody rbody
    );

    // Remove movie from list
    @POST("https://api.themoviedb.org/3/list/{list_id}/remove_item")
    Call<ListResponse> removeMovieFromList(
            @Query("api_key") String apiKey,
            @Query("session_id") String sessionid,
            @Path("list_id") Integer path,

            @Body() RequestBody rbody
    );

    // Remove list
    @DELETE("https://api.themoviedb.org/3/list/{list_id}")
    Call<ListResponse> removeList(
            @Query("api_key") String apiKey,
            @Query("session_id") String sessionid,
            @Path("list_id") Integer path
    );
}

