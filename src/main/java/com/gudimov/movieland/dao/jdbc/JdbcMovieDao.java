package com.gudimov.movieland.dao.jdbc;

import com.gudimov.movieland.dao.MovieDao;
import com.gudimov.movieland.service.enricher.MovieEnricher;
import com.gudimov.movieland.dao.jdbc.mapper.MovieRowMapper;
import com.gudimov.movieland.entity.Movie;
import com.gudimov.movieland.entity.MovieWithGenreCountry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class JdbcMovieDao implements MovieDao {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private String getAllMovieSQL;

    @Autowired
    private String getRandomMovieSQL;



    @Override
    public List<Movie> getAll() {
        log.debug("Start query to get movie from DB");
        List<Movie> listMovie = jdbcTemplate.query(getAllMovieSQL, new MovieRowMapper<Movie>());
        log.debug("Finish query to get movie from DB");
        return listMovie;
    }

    @Override
    public List<MovieWithGenreCountry> getRandom() {
        log.debug("Start query to get random movie from DB");
        List<MovieWithGenreCountry> listMovie = jdbcTemplate.query(getRandomMovieSQL, new MovieRowMapper<MovieWithGenreCountry>());
        log.debug("Finish query to get movie from DB");
        return listMovie;
    }


}
