package com.gudimov.movieland.dao.jdbc;

import com.gudimov.movieland.dao.MovieCountryDao;
import com.gudimov.movieland.dao.jdbc.mapper.MovieCountryRowMapper;
import com.gudimov.movieland.dao.link.LinkMovieCountry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcMovieCountryDao implements MovieCountryDao {
    private static final MovieCountryRowMapper movieCountryRowMapper = new MovieCountryRowMapper();
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private String getMovieCountrySQL;

    @Override
    public List<LinkMovieCountry> getAll() {
        log.info("Start query to get movies country from DB");
        List<LinkMovieCountry> listLinkMovieCountry = jdbcTemplate.query(getMovieCountrySQL, movieCountryRowMapper);
        log.info("Finish query to get movies country from DB");
        return listLinkMovieCountry;
    }

}
