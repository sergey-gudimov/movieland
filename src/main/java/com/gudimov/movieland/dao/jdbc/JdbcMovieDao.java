package com.gudimov.movieland.dao.jdbc;

import com.gudimov.movieland.dao.MovieDao;
import com.gudimov.movieland.dao.jdbc.mapper.MovieRowMapper;
import com.gudimov.movieland.entity.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class JdbcMovieDao implements MovieDao {
    private static MovieRowMapper movieRowMapper = new MovieRowMapper();
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private String getAllMovieSQL;

    @Autowired
    private String getRandomMovieSQL;


    @Override
    public List<Movie> getAll() {
        log.info("Start query to get movie from DB");
        List<Movie> listMovie = jdbcTemplate.query(getAllMovieSQL, movieRowMapper);
        log.info("Finish query to get movie from DB");
        return listMovie;
    }

    @Override
    public List<Movie> getRandom() {
        log.info("Start query to get random movie from DB");
        List<Movie> listMovie = jdbcTemplate.query(getRandomMovieSQL, movieRowMapper);
        log.info("Finish query to get movie from DB");
        return listMovie;
    }


}
