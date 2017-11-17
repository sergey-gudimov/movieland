package com.gudimov.movieland.dao.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.PrimitiveIterator;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/root-context.xml"})
public class JdbcMovieDaoITest {

    @Autowired
    private JdbcMovieDao jdbcMovieDao;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private String getGenreMaxIdSQL;

    @Test
    public void getAll() throws Exception {
        List allMovie = jdbcMovieDao.getAll();
        assertNotEquals(allMovie.size(), 0);
    }

    @Test
    public void getRandom() throws Exception {
        List randomMovie = jdbcMovieDao.getRandom();
        assertNotEquals(randomMovie.size(), 0);
    }

    @Test
    public void getByGenreId() throws Exception {
        int genreId = jdbcTemplate.queryForObject(getGenreMaxIdSQL, Integer.class);
        List movieByGenreId = jdbcMovieDao.getByGenreId(genreId);
        assertNotEquals(movieByGenreId.size(), 0);
    }

}