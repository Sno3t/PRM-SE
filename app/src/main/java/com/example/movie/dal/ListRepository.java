package com.example.movie.dal;

import android.util.Log;

import com.example.movie.domain.APIConn;
import com.example.movie.domain.MovieList;
import com.example.movie.domain.responses.JsonResponse;
import com.example.movie.domain.responses.ListResponse;
import com.example.movie.domain.responses.MovieListResponse;
import com.example.movie.presentation.ListActivityViewAdapter;
import com.example.movie.presentation.ListsActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListRepository {
    public static final String TAG = ListRepository.class.getSimpleName();
    public static String BASE_URL = "https://api.themoviedb.org";
    public static String API_KEY = "f3c365d45195979057ba40752d5f37ac";
    public static String SESSION_ID = "9cf20bea798469635e4210f5c24d719cf3864e0d";
    public static String BEARER_TOKEN = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmM2MzNjVkNDUxOTU5NzkwNTdiYTQwNzUyZDVmMzdhYyIsInN1YiI6IjY0MWFlZDkyNjg4Y2QwMDA4NTc3MzM3ZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.hdsawzjinEBHJZyn7A62wxMjOkOH4SRvs72I7qtQP84";

    public static ArrayList<MovieList> lists = new ArrayList<>();
    public static List<Integer> listids = new ArrayList<>();

    public void GetLists(){
        lists.clear();
        listids.clear();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        APIConn apiConn = retrofit.create(APIConn.class);

        Call<ListResponse> call = apiConn.getListID(API_KEY, SESSION_ID);

        // Get list ids
        call.enqueue(new Callback<ListResponse>() {
            @Override
            public void onResponse(Call<ListResponse> call, Response<ListResponse> response) {
                ListResponse listJsonResponse = response.body();

                // Get list of listids
                listids = listJsonResponse.GetLists();

                // Get details of all list ids
                // Error in api, returns 0 lists
                for (Integer id: listids) {
                    Call<MovieListResponse> calllists = apiConn.getLists(BEARER_TOKEN, id);

                    calllists.enqueue(new Callback<MovieListResponse>() {
                        @Override
                        public void onResponse(Call<MovieListResponse> call, Response<MovieListResponse> response) {
                            // Get details of lists
                            MovieListResponse mlresponse = response.body();

                            // Place in class
                            lists.add(
                                new MovieList(
                                        mlresponse.GetName(),
                                        mlresponse.GetMovies(),
                                        mlresponse.GetDesc()
                                )
                            );
                            Log.i(TAG, "amount of lists: " + lists.size());

                            ListRepoIBT.SetMLList(lists);
                        }

                        @Override
                        public void onFailure(Call<MovieListResponse> call, Throwable t) {
                            Log.e(TAG, "Error: " + t.toString());
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<ListResponse> call, Throwable t) {
                Log.e(TAG, "Error: " + t.toString());
            }
        });


        return;
    };
}
