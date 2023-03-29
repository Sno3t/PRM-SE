package com.example.movie.domain;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie.presentation.GenreRecylcerViewAdapter;
import com.example.movie.presentation.MainActivity;
import com.example.movie.presentation.MovieInGenreRecyclerViewAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.LinkedList;

public class APIConn extends AsyncTask<String, Void, ArrayList<Movie>> {
    protected String apiKey = "f3c365d45195979057ba40752d5f37ac";
    ArrayList<Movie> movieList;

    Context context;
    RecyclerView recyclerView;

    public APIConn(Context context, RecyclerView recyclerView){
        this.context = context;
        this.recyclerView = recyclerView;
    }

    @Override
    protected ArrayList<Movie> doInBackground(String... strings) {
        String jsonString;
        movieList = new ArrayList<>();

        // Get genres
        Dictionary<Integer, String> genres = new Hashtable<>();
        GetGenres(genres);

        // Get amount of pages
        int pagesamount = GetPages();

        // Loop through all pages to get all movies
        for(int f = 1; f <= pagesamount; f++){
            // Get Json String from API
            try {
                URL url = new URL("https://api.themoviedb.org/3/movie/now_playing?api_key=" + apiKey + "&page=" + f);

                HttpURLConnection httpurl = (HttpURLConnection) url.openConnection();

                InputStream inputStream = httpurl.getInputStream();

                BufferedReader bR = new BufferedReader(new InputStreamReader(inputStream));

                StringBuilder sb = new StringBuilder();
                int cp;
                while ((cp = bR.read()) != -1) {
                    sb.append((char) cp);
                }
                jsonString = sb.toString();
            }
            catch (Exception e){
                throw new RuntimeException(e);
            }

            // Fit json to object
            try {
                JSONObject jsonObject = new JSONObject(jsonString);
                JSONArray array = jsonObject.getJSONArray("results");

                for (int i = 0; i < array.length(); i++){
                    JSONObject object = array.getJSONObject(i);

                    // Get genres
                    ArrayList<String>  moviegenres = new ArrayList<>();
                    JSONArray intGenres = object.getJSONArray("genre_ids");
                    for (int j = 0; j < intGenres.length(); j++){
                        moviegenres.add(
                                genres.get(intGenres.getInt(j))
                        );
                    }

                    // Check if object has release_date, otherwise default to 0000-00-00
                    if (!object.has("release_date")){
                        Movie gotMovie = new Movie(
                                object.getString("original_title") ,
                                new SimpleDateFormat("yyyy-MM-dd").parse("0000-00-00"),
                                object.getString("poster_path"),
                                object.getString("overview"),
                                moviegenres,
                                object.getInt("vote_average"),
                                object.getString("original_language")
                        );
                        movieList.add(gotMovie);
                    }
                    else{
                        Movie gotMovie = new Movie(
                                object.getString("original_title") ,
                                new SimpleDateFormat("yyyy-MM-dd").parse(object.getString("release_date")),
                                object.getString("poster_path"),
                                object.getString("overview"),
                                moviegenres,
                                object.getInt("vote_average"),
                                object.getString("original_language")
                        );
                        movieList.add(gotMovie);
                    }
                }

                // Log.d("ALERT", "Page " + f + " done parsing.") ;
            }
            catch (JSONException e) {
                throw new RuntimeException(e);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

        }

        Log.d("LIST_COUNT", String.valueOf(movieList.size())) ;

        MainActivity.SetLinkedList(movieList);

        return movieList;
    }

    @Override
    protected void onPostExecute(ArrayList<Movie> movies) {
        super.onPostExecute(movies);

        GenreRecylcerViewAdapter gmAdapter = new GenreRecylcerViewAdapter(context, movies, recyclerView);

        // Put movies in recyclerview
        MovieInGenreRecyclerViewAdapter adapter = new MovieInGenreRecyclerViewAdapter(context, movies);
        recyclerView.setAdapter(adapter);
        // recyclerView.setLayoutManager(new GridLayoutManager(context, 1));

        Log.d("MESSAGE", "Getting completed");
    }

    protected void GetGenres(Dictionary<Integer, String> genres){
        String genrestring;

        try {
            URL url = new URL("https://api.themoviedb.org/3/genre/movie/list?api_key=" + apiKey + "&language=en-US");

            HttpURLConnection httpurl = (HttpURLConnection) url.openConnection();

            InputStream inputStream = httpurl.getInputStream();

            BufferedReader bR = new BufferedReader(new InputStreamReader(inputStream));

            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = bR.read()) != -1) {
                sb.append((char) cp);
            }
            genrestring = sb.toString();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }

        try{
            JSONObject jsonObject = new JSONObject(genrestring);
            JSONArray array = jsonObject.getJSONArray("genres");

            for (int j = 0; j < array.length(); j++){
                JSONObject object = array.getJSONObject(j);

                genres.put(
                        object.getInt("id"),
                        object.getString("name")
                );
            }

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }


    protected Integer GetPages(){
        String countString;
        Integer pagescount = 0;

        try {
            URL url = new URL("https://api.themoviedb.org/3/movie/now_playing?api_key=" + apiKey );

            HttpURLConnection httpurl = (HttpURLConnection) url.openConnection();

            InputStream inputStream = httpurl.getInputStream();

            BufferedReader bR = new BufferedReader(new InputStreamReader(inputStream));

            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = bR.read()) != -1) {
                sb.append((char) cp);
            }
            countString = sb.toString();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }

        try {
            JSONObject jsonObject = new JSONObject(countString);
            pagescount = jsonObject.getInt("total_pages");
        }
        catch (JSONException e) {
            throw new RuntimeException(e);
        }

        return pagescount;
    }
}

