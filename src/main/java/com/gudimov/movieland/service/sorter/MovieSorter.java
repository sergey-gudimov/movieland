package com.gudimov.movieland.service.sorter;

import com.gudimov.movieland.entity.Movie;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static com.gudimov.movieland.service.sorter.SortOrder.ACS;
import static com.gudimov.movieland.service.sorter.SortOrder.DESC;


@Service
public class MovieSorter {
    public List<Movie> sortMovieList(List<Movie> movieList, String ratingSort, String priceSort) {

        if (DESC.name().equalsIgnoreCase(String.valueOf(ratingSort))) {
            Collections.sort(movieList, new ComparatorMovieListOrderByRatingDesc());
        }
        if (ACS.name().equalsIgnoreCase(String.valueOf(priceSort))) {
            Collections.sort(movieList, new ComparatorMovieListOrderByPriceAcs());
        }
        if (DESC.name().equalsIgnoreCase(String.valueOf(priceSort))) {
            Collections.sort(movieList, new ComparatorMovieListOrderByPriceDesc());
        }
        return movieList;
    }

}
