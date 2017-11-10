package com.gudimov.movieland.dao.jdbc;

import com.gudimov.movieland.entity.Movie;
import com.gudimov.movieland.entity.MovieWithGenreCountry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/root-context.xml"})
public class JdbcMovieDaoTest {

    @Autowired
    private JdbcMovieDao jdbcMovieDao;

    @Test
    public void getAll() throws Exception {
        List<Movie> allMovie = jdbcMovieDao.getAll();
        assertNotEquals(allMovie.size(), 0);
    }

    @Test
    public void getRandom() throws Exception {
        List<MovieWithGenreCountry> randomMovie = jdbcMovieDao.getRandom();
        assertNotEquals(randomMovie.size(), 0);
    }

}