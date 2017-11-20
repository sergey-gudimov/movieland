package com.gudimov.movieland.service.sorter;

import com.gudimov.movieland.entity.Movie;

import java.util.Comparator;

public class ComparatorMovieListOrderByRatingDesc implements Comparator<Movie> {


    @Override
    public int compare(Movie o1, Movie o2) {
        return Double.compare(o2.getRating(), o1.getRating());
    }

}
