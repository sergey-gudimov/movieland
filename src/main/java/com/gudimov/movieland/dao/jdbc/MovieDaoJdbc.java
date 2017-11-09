package com.gudimov.movieland.dao.jdbc;

import com.gudimov.movieland.dao.MovieDao;
import com.gudimov.movieland.dao.jdbc.mapper.MovieRowMapper;
import com.gudimov.movieland.entity.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Repository
public class MovieDaoJdbc implements MovieDao {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private String getAllMovieSQL;

    @Override
    public List<Movie> getAllMoview() {
        log.info("Start query to get movie from DB");
        List<Movie> listMovie = jdbcTemplate.query(getAllMovieSQL, new MovieRowMapper());
        log.info("Finish query to get movie from DB");
        return listMovie;
    }
}
