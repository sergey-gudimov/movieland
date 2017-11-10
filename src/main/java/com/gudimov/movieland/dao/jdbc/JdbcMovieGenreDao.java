package com.gudimov.movieland.dao.jdbc;

import com.gudimov.movieland.dao.MovieGenreDao;
import com.gudimov.movieland.dao.jdbc.mapper.MovieGenreRowMapper;
import com.gudimov.movieland.entity.MovieGenre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcMovieGenreDao implements MovieGenreDao {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private String getMovieGenreSQL;

    @Override
    public List<MovieGenre> getAll() {
        log.info("Start query to get movies genre from DB");
        List<MovieGenre> listMovieGenre = jdbcTemplate.query(getMovieGenreSQL, new MovieGenreRowMapper());
        log.info("Finish query to get movies genre from DB");
        return listMovieGenre;
    }

}
