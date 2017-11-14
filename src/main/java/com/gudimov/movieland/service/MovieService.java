package com.gudimov.movieland.service;

import com.gudimov.movieland.dao.link.LinkMovieCountry;
import com.gudimov.movieland.dao.link.LinkMovieGenre;
import com.gudimov.movieland.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAll();

    List<Movie> getRandom();

    List<LinkMovieGenre> getMovieGenreAll();

    List<LinkMovieCountry> getMovieCountryAll();
}
