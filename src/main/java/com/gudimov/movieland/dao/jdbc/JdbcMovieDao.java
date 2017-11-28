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
    private static final MovieRowMapper MOVIE_ROW_MAPPER = new MovieRowMapper();
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private String getAllMovieSQL;

    @Autowired
    private String getRandomMovieSQL;

    @Autowired
    private String getMovieByGenreIdSQL;

    @Autowired
    private String getMovieByIdSQL;

    @Override
    public List<Movie> getAll() {

        LOG.info("Start query to get movie from DB");
        List<Movie> listMovie = jdbcTemplate.query(getAllMovieSQL, MOVIE_ROW_MAPPER);
        LOG.info("Finish query to get movie from DB");

        return listMovie;
    }

    @Override

    public List<Movie> getRandom() {
        LOG.info("Start query to get random movie from DB");
        List<Movie> listMovie = jdbcTemplate.query(getRandomMovieSQL, MOVIE_ROW_MAPPER);
        LOG.info("Finish query to get movie from DB");

        return listMovie;
    }

    @Override
    public List<Movie> getByGenreId(int genreId) {
        LOG.info("Start query to get movie by genre id = {} from DB", genreId);

        List<Movie> listMovie = jdbcTemplate.query(getMovieByGenreIdSQL, MOVIE_ROW_MAPPER, genreId);
        LOG.info("Finish query to get movie by genre id = {} from DB. Return movie = {}", genreId, listMovie);

        return listMovie;
    }

    @Override
    public List<Movie> getById(int movieId) {
        LOG.info("Start query to get movie by  id = {} from DB", movieId);

        List<Movie> listMovie = jdbcTemplate.query(getMovieByIdSQL, MOVIE_ROW_MAPPER, movieId);
        LOG.info("Finish query to get movie by id = {} from DB. Return movie = {}", movieId, listMovie);

        return listMovie;
    }


}
