package com.gudimov.movieland.service.sorter;

import com.gudimov.movieland.entity.Movie;

import java.util.Comparator;

public class ComparatorMovieListOrderByPriceDesc implements Comparator<Movie>{
    @Override
    public int compare(Movie o1, Movie o2) {
        return Double.compare(o2.getPrice(), o1.getPrice());
    }
}
