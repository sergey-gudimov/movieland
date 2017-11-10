package com.gudimov.movieland.service;

import com.gudimov.movieland.entity.Movie;
import com.gudimov.movieland.entity.MovieCountry;
import com.gudimov.movieland.entity.MovieGenre;
import com.gudimov.movieland.entity.MovieWithGenreCountry;

import java.util.List;

public interface MovieService {
    List<Movie> getAll();

    List<MovieWithGenreCountry> getRandom();

    List<MovieGenre> getMovieGenreAll();

    List<MovieCountry> getMovieCountryAll();
}
