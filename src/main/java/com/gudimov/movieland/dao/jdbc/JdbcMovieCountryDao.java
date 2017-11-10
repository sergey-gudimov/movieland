package com.gudimov.movieland.dao.jdbc;

import com.gudimov.movieland.dao.MovieCountryDao;
import com.gudimov.movieland.dao.jdbc.mapper.MovieCountryRowMapper;
import com.gudimov.movieland.entity.MovieCountry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcMovieCountryDao implements MovieCountryDao {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private String getMovieCountrySQL;

    @Override
    public List<MovieCountry> getAll() {
        log.info("Start query to get movies country from DB");
        List<MovieCountry> listMovieCountry = jdbcTemplate.query(getMovieCountrySQL, new MovieCountryRowMapper());
        log.info("Finish query to get movies country from DB");
        return listMovieCountry;
    }

}
