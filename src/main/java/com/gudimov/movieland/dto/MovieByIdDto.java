package com.gudimov.movieland.dto;

import com.gudimov.movieland.entity.Country;
import com.gudimov.movieland.entity.Genre;
import com.gudimov.movieland.entity.Movie;
import com.gudimov.movieland.entity.Review;

import java.util.List;

public class MovieByIdDto {
    private final int id;
    private final String nameRussian;
    private final String nameNative;
    private final int yearOfRelease;
    private final String description;
    private final double rating;
    private final double price;
    private final String picturePath;
    private final List<Genre> genreList;
    private final List<Country> countryList;
    private final List<Review> reviewList;

    public MovieByIdDto(Movie movie) {
        this.id = movie.getId();
        this.nameRussian = movie.getNameRussian();
        this.nameNative = movie.getNameNative();
        this.yearOfRelease = movie.getYearOfRelease();
        this.description = movie.getDescription();
        this.rating = movie.getRating();
        this.price = movie.getPrice();
        this.picturePath = movie.getPicturePath();
        this.countryList = movie.getCountry();
        this.genreList = movie.getGenre();
        this.reviewList = movie.getReview();
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

    public String getDescription() {
        return description;
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

    public List<Genre> getGenreList() {
        return genreList;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

}
