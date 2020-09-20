package com.csumb.c00kie.flixter.models;

import com.facebook.stetho.inspector.jsonrpc.JsonRpcException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    String backdropPath;
    String poseterPath;
    String title;
    String overview;

    public Movie(JSONObject jsonObject) throws JSONException {
        backdropPath = jsonObject.getString("backdrop_path");
        poseterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
    }
    public static List<Movie> fromJsonArray(JSONArray moviejsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for(int x = 0; x < moviejsonArray.length(); x++){
            movies.add(new Movie(moviejsonArray.getJSONObject(x)));
        }
        return movies;
    }

    public String getPoseterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", poseterPath);
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }
}
