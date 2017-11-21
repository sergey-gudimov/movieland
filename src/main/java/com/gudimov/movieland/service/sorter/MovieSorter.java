package com.gudimov.movieland.service.sorter;

import com.gudimov.movieland.entity.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static com.gudimov.movieland.service.sorter.SortOrder.ACS;
import static com.gudimov.movieland.service.sorter.SortOrder.DESC;


@Service
public class MovieSorter {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    ValidatorSortParams validatorSortParams;

    public List<Movie> sortMovieList(List<Movie> movieList, String ratingSort, String priceSort) {
        LOG.info("Start service sort movies");

        validatorSortParams.validate(ratingSort, priceSort);
        if (DESC.name().equalsIgnoreCase(String.valueOf(ratingSort))) {
            Collections.sort(movieList, new ComparatorMovieListOrderByRatingDesc());
        }
        if (ACS.name().equalsIgnoreCase(String.valueOf(priceSort))) {
            Collections.sort(movieList, new ComparatorMovieListOrderByPriceAcs());
        }
        if (DESC.name().equalsIgnoreCase(String.valueOf(priceSort))) {
            Collections.sort(movieList, new ComparatorMovieListOrderByPriceDesc());
        }
        LOG.info("Finish service sort movies");
        return movieList;
    }

}
