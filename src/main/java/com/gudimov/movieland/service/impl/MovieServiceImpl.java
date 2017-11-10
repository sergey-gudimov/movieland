package com.gudimov.movieland.service.impl;

import com.gudimov.movieland.dao.MovieCountryDao;
import com.gudimov.movieland.dao.MovieDao;
import com.gudimov.movieland.dao.MovieGenreDao;
import com.gudimov.movieland.entity.Movie;
import com.gudimov.movieland.entity.MovieCountry;
import com.gudimov.movieland.entity.MovieGenre;
import com.gudimov.movieland.entity.MovieWithGenreCountry;
import com.gudimov.movieland.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private    MovieDao movieDao;

    @Autowired
    private MovieGenreDao movieGenreDao;

    @Autowired
    private MovieCountryDao movieCountryDao;

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }

    @Override
    public List<MovieWithGenreCountry> getRandom() {
        return movieDao.getRandom();
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
