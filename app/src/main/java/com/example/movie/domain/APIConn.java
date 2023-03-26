package com.example.movie.domain;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

public class APIConn {
    String apiKey = "f3c365d45195979057ba40752d5f37ac";

    public APIConn(RecyclerView recyclerView){

    }

    // Temp method to test url conn
    public void GetMovieByID() {
        URL url = null;
        try {
            url = new URL("https://api.themoviedb.org/3/movie/438799?api_key=" + apiKey);
            HttpURLConnection httpurl = (HttpURLConnection) url.openConnection();

            InputStream inputStream = httpurl.getInputStream();

            BufferedReader bR = new BufferedReader(new InputStreamReader(inputStream));

            Log.d("Tag", bR.readLine());

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    // Movies
    public Movie GetMovieByID(Integer id){
        String jsonString = "";

        // Check if url isn't empty
        try{
            InputStream is = new URL("https://api.themoviedb.org/3/movie/" + id + "?api_key=" + apiKey).openStream();
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonString = new String(buffer, "UTF-8");
        } catch (IOException ex){
            ex.printStackTrace();
            return null;
        }

        // Convert to json string
        try {
            InputStream is = new URL("https://api.themoviedb.org/3/movie/" + id + "?api_key=" + apiKey).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }
            jsonString = sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }  catch (IOException e) {
            e.printStackTrace();
        }


        // Convert JSon to objects & return
        try {
            JSONObject reader = new JSONObject(jsonString);

            Movie gotMovie = new Movie(
                    reader.getString("original_title"),
                    reader.getString("overview"),
                    reader.getInt("runtime")
            );

            return gotMovie;
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e(TAG, "Failed to parse JSON");
        }
        return null;
    }

    // Lists


}
