package com.moviesdetails.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GenreResponse {

    public List<Genres> getGenres() {
        return genres;
    }

    public void setGenres(List<Genres> genres) {
        this.genres = genres;
    }

    @SerializedName("genres")
    private List<Genres> genres;


}
