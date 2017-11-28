package com.gudimov.movieland.dao.jdbc;

import com.gudimov.movieland.dao.GenreDao;
import com.gudimov.movieland.dao.jdbc.mapper.GenreRowMapper;
import com.gudimov.movieland.entity.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcGenreDao implements GenreDao {
    private static final GenreRowMapper GenreRowMapper = new GenreRowMapper();
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private String getAllGenreSQL;

    @Override
    public List<Genre> getAll() {
        log.info("Start query to gets genre from DB");
        List<Genre> listGenre = jdbcTemplate.query(getAllGenreSQL, GenreRowMapper);
        log.info("Finish query to gets genre from DB");
        return listGenre;
    }

}
