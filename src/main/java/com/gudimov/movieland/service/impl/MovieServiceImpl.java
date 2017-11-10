package com.gudimov.movieland.service.impl;

import com.gudimov.movieland.dao.MovieCountryDao;
import com.gudimov.movieland.dao.MovieDao;
import com.gudimov.movieland.dao.MovieGenreDao;
import com.gudimov.movieland.entity.Movie;
import com.gudimov.movieland.entity.MovieCountry;
import com.gudimov.movieland.entity.MovieGenre;
import com.gudimov.movieland.entity.MovieWithGenreCountry;
import com.gudimov.movieland.service.MovieService;
import com.gudimov.movieland.service.enricher.MovieEnricher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovieServiceImpl implements MovieService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private    MovieDao movieDao;

    @Autowired
    private MovieGenreDao movieGenreDao;

    @Autowired
    private MovieCountryDao movieCountryDao;

    @Autowired
    private MovieEnricher movieEnricher;

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }

    @Override
    public List<MovieWithGenreCountry> getRandom() {
        List<MovieWithGenreCountry> randomMovie = movieDao.getRandom();
        log.info("Start enriched movie");
        List<MovieWithGenreCountry> movieWithGenreCountries=movieEnricher.enrichMovieWithGenreCountry(randomMovie);
        log.info("Finish enriched with countries and genres");

        return movieWithGenreCountries;
    }

    @Override
    public List<MovieGenre> getMovieGenreAll() {
        return movieGenreDao.getAll();
    }

    @Override
    public List<MovieCountry> getMovieCountryAll() {
        return movieCountryDao.getAll();
    }
}
