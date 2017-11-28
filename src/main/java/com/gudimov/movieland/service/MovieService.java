package com.gudimov.movieland.service;

import com.gudimov.movieland.dao.link.LinkMovieCountry;
import com.gudimov.movieland.dao.link.LinkMovieGenre;
import com.gudimov.movieland.entity.Country;
import com.gudimov.movieland.entity.Movie;
import com.gudimov.movieland.entity.Review;

import java.util.List;

public interface MovieService {
    List<Movie> getAll(String ratingSort, String priceSort);

    List<Movie> getRandom();

    List<LinkMovieGenre> getLinkMovieGenreAll();

    List<LinkMovieCountry> getLinkMovieCountryAll();

    List<Movie> getByGenreId(int genreId, String ratingSort, String priceSort);

    List<Movie> getById(int movieId);
}
