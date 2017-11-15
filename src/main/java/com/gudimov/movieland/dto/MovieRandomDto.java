package com.gudimov.movieland.dto;

import com.gudimov.movieland.entity.Country;
import com.gudimov.movieland.entity.Genre;
import com.gudimov.movieland.entity.Movie;

import java.util.List;

public class MovieRandomDto {
    private final int id;
    private final String nameRussian;
    private final String nameNative;
    private final int yearOfRelease;
    private final double rating;
    private final double price;
    private final String picturePath;
    private final List<Genre> Genre;
    private final List<Country> Country;

    public MovieRandomDto(Movie movie) {
        this.id = movie.getId();
        this.nameRussian = movie.getNameRussian();
        this.nameNative = movie.getNameNative();
        this.yearOfRelease = movie.getYearOfRelease();
        this.rating = movie.getRating();
        this.price = movie.getPrice();
        this.picturePath = movie.getPicturePath();
        this.Country = movie.getCountry();
        this.Genre = movie.getGenre();
    }

    public int getId() {
        return id;
    }

    public String getNameRussian() {
        return nameRussian;
    }

    public String getNameNative() {
        return nameNative;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public double getRating() {
        return rating;
    }

    public double getPrice() {
        return price;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public List<com.gudimov.movieland.entity.Genre> getGenre() {
        return Genre;
    }

    public List<com.gudimov.movieland.entity.Country> getCountry() {
        return Country;
    }
}
