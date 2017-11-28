package com.gudimov.movieland.service.sorter;

import com.gudimov.movieland.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.gudimov.movieland.service.sorter.SortOrder.ACS;
import static com.gudimov.movieland.service.sorter.SortOrder.DESC;


@Service
public class MovieSorter {
    private static Comparator<Movie> comparatorMovieListOrderByRatingDesc =  (o1, o2) -> Double.compare(o2.getRating(), o1.getRating());
    private static Comparator<Movie> comparatorMovieListOrderByPriceAcs =  (o1, o2) -> Double.compare(o1.getPrice(), o2.getPrice());
    private static Comparator<Movie> comparatorMovieListOrderByPriceDesc = (o1, o2) -> Double.compare(o2.getPrice(), o1.getPrice());

    @Autowired
    private ValidatorSortParams validatorSortParams;

    public List<Movie> sortMovieList(List<Movie> movieList, SortOrder sortOrderRating, SortOrder sortOrderPrice) {



        if (DESC.equals(sortOrderRating)) {
            Collections.sort(movieList, comparatorMovieListOrderByRatingDesc);
        }
        if (ACS.equals(sortOrderPrice)) {
            Collections.sort(movieList, comparatorMovieListOrderByPriceAcs);
        }
        if (DESC.equals(sortOrderPrice)) {
            Collections.sort(movieList, comparatorMovieListOrderByPriceDesc);
        }
        return movieList;
    }

}
