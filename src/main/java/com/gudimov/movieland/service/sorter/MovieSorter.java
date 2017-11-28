package com.gudimov.movieland.service.sorter;

import com.gudimov.movieland.entity.Movie;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static com.gudimov.movieland.service.sorter.SortOrder.ACS;
import static com.gudimov.movieland.service.sorter.SortOrder.DESC;


@Service
public class MovieSorter {
    private static final Comparator<Movie> comparatorMovieListOrderByRatingDesc = (o1, o2) -> Double.compare(o2.getRating(), o1.getRating());
    private static final Comparator<Movie> comparatorMovieListOrderByPriceAcs = Comparator.comparingDouble(Movie::getPrice);
    private static final Comparator<Movie> comparatorMovieListOrderByPriceDesc = (o1, o2) -> Double.compare(o2.getPrice(), o1.getPrice());

    public void sortMovieList(List<Movie> movieList, Optional<SortOrder> sortOrderRating, Optional<SortOrder> sortOrderPrice) {

        if (sortOrderRating.isPresent() && DESC.equals(sortOrderRating.get())) {
            movieList.sort(comparatorMovieListOrderByRatingDesc);
        }
        if (sortOrderPrice.isPresent()) {
            if (ACS.equals(sortOrderPrice.get())) {
                movieList.sort(comparatorMovieListOrderByPriceAcs);
            }
            if (DESC.equals(sortOrderPrice.get())) {
                movieList.sort(comparatorMovieListOrderByPriceDesc);
            }
        }
    }

}
