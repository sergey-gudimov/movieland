package com.gudimov.movieland.dao;

import com.gudimov.movieland.entity.Movie;

import java.util.List;

public interface MovieDao {
    List<Movie> getAll();

    List<Movie> getRandom();

    List<Movie> getByGenreId(int genreId);
}
