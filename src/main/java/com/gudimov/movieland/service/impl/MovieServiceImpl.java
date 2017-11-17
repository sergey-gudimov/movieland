package com.gudimov.movieland.service.impl;

import com.gudimov.movieland.dao.MovieCountryDao;
import com.gudimov.movieland.dao.MovieDao;
import com.gudimov.movieland.dao.MovieGenreDao;
import com.gudimov.movieland.dao.link.LinkMovieCountry;
import com.gudimov.movieland.dao.link.LinkMovieGenre;
import com.gudimov.movieland.entity.Movie;
import com.gudimov.movieland.service.MovieService;
import com.gudimov.movieland.service.enricher.MovieEnricher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovieServiceImpl implements MovieService {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private MovieDao movieDao;

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
    public List<Movie> getRandom() {
        List<Movie> movies = movieDao.getRandom();
        LOG.info("Start enriched movie");
        movieEnricher.enrichMovie(movies);
        LOG.info("Finish enriched with countries and genres");

        return movies;
    }

    @Override
    public List<LinkMovieGenre> getLinkMovieGenreAll() {
        return movieGenreDao.getAll();
    }

    @Override
    public List<LinkMovieCountry> getLinkMovieCountryAll() {
        return movieCountryDao.getAll();
    }

    @Override
    public List<Movie> getByGenreId(int genreId) {
        LOG.info("Start service get movie by genre id = {}",genreId);
        List<Movie> movies = movieDao.getByGenreId(genreId);
        LOG.info("Finish service get movie by genre id = {}. Return movies {} ",genreId, movies);
        return movies;
    }
}
