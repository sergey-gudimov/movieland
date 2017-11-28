package com.gudimov.movieland.service;

import com.gudimov.movieland.dao.link.LinkMovieCountry;
import com.gudimov.movieland.dao.link.LinkMovieGenre;
import com.gudimov.movieland.entity.Movie;
import com.gudimov.movieland.service.sorter.SortOrder;

import java.util.List;

public interface MovieService {
    List<Movie> getAll(SortOrder ratingSort, SortOrder priceSort);

    List<Movie> getRandom();

    List<LinkMovieGenre> getLinkMovieGenreAll();

    List<LinkMovieCountry> getLinkMovieCountryAll();

    List<Movie> getByGenreId(int genreId, SortOrder ratingSort, SortOrder priceSort);
}
