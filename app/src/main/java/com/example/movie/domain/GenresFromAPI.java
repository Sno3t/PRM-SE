//package com.example.movie.domain;
//
//import android.os.AsyncTask;
//
//import com.example.movie.presentation.GenreMovieAdapter;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.BufferedReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.ArrayList;
//
//public class GenresFromAPI extends AsyncTask<Void, Void, ArrayList<String>> {
//    protected String apiKey = "f3c365d45195979057ba40752d5f37ac";
//
//    @Override
//    protected ArrayList<String> doInBackground(Void... voids) {
//        String genrestring;
//        ArrayList<String> genres = new ArrayList<>();
//
//        try {
//            URL url = new URL("https://api.themoviedb.org/3/genre/movie/list?api_key=" + apiKey + "&language=en-US");
//
//            HttpURLConnection httpurl = (HttpURLConnection) url.openConnection();
//
//            InputStream inputStream = httpurl.getInputStream();
//
//            BufferedReader bR = new BufferedReader(new InputStreamReader(inputStream));
//
//            StringBuilder sb = new StringBuilder();
//            int cp;
//            while ((cp = bR.read()) != -1) {
//                sb.append((char) cp);
//            }
//            genrestring = sb.toString();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//        try {
//            JSONObject jsonObject = new JSONObject(genrestring);
//            JSONArray array = jsonObject.getJSONArray("genres");
//
//            for (int j = 0; j < array.length(); j++) {
//                JSONObject object = array.getJSONObject(j);
//
//                genres.add(
//                        object.getString("name")
//                );
//            }
//
//        } catch (JSONException e) {
//            throw new RuntimeException(e);
//        }
//        GenreMovieAdapter.SetArraylist(genres);
//        return genres;
//    }
//
//    @Override
//    protected void onPostExecute(ArrayList<String> strings) {
//        super.onPostExecute(strings);
//    }
//}
