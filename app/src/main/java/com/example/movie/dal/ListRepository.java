package com.example.movie.dal;

import android.util.Log;

import com.example.movie.domain.APIConn;
import com.example.movie.domain.MovieList;
import com.example.movie.domain.responses.JsonResponse;
import com.example.movie.domain.responses.ListResponse;

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

    public static ArrayList<MovieList> lists = new ArrayList<>();

    public ArrayList<MovieList> GetLists(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        APIConn apiConn = retrofit.create(APIConn.class);

        Call<ListResponse> call = apiConn.getLists(API_KEY, SESSION_ID);

        call.enqueue(new Callback<ListResponse>() {
            @Override
            public void onResponse(Call<ListResponse> call, Response<ListResponse> response) {
                ListResponse listJsonResponse = response.body();
                List<MovieList> listresponse = listJsonResponse.GetLists();

                for (MovieList ml : listresponse){
                    lists.add(
                            new MovieList(
                                    ml.getListName(),
                                    ml.getMovielist(),
                                    ml.getDateCreated()
                            )
                    );
                    Log.i(TAG, "amount of lists: " + lists.size());
                }
            }

            @Override
            public void onFailure(Call<ListResponse> call, Throwable t) {
                Log.e(TAG, "Error: " + t.toString());
            }
        });
        return lists;
    };
}
