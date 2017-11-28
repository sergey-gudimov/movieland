package com.gudimov.movieland.dto;

import com.gudimov.movieland.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieDto {
    private final int id;
    private final String nameRussian;
    private final String nameNative;
    private final int yearOfRelease;
    private final double rating;
    private final double price;
    private final String picturePath;

    public MovieDto(Movie movie) {
        this.id = movie.getId();
        this.nameRussian = movie.getNameRussian();
        this.nameNative = movie.getNameNative();
        this.yearOfRelease = movie.getYearOfRelease();
        this.rating = movie.getRating();
        this.price = movie.getPrice();
        this.picturePath = movie.getPicturePath();
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

    public static List<MovieDto> ConvertEntityListToDtoList(List<Movie> entityList) {
        List<MovieDto> movieDtos = new ArrayList<>();
        for (Movie movie : entityList) {
            movieDtos.add(new MovieDto(movie));
        }
        return movieDtos;
    }


}
