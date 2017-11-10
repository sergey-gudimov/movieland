package com.gudimov.movieland.dao;

import com.gudimov.movieland.entity.Movie;
import com.gudimov.movieland.entity.MovieWithGenreCountry;

import java.util.List;

public interface MovieDao {
    List<Movie> getAll();

    List<MovieWithGenreCountry> getRandom();
}
