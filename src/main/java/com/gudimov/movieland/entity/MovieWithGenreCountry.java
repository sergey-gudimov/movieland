package com.gudimov.movieland.entity;

import java.util.List;

public class MovieWithGenreCountry extends Movie{
    private List<Genre> Genre;
    private List<Country> Country;

    public List<Genre> getGenre() {
        return Genre;
    }

    public void setGenre(List<Genre> genre) {
        Genre = genre;
    }

    public List<Country> getCountry() {
        return Country;
    }

    public void setCountry(List<Country> country) {
        Country = country;
    }
}
