package com.gudimov.movieland.dao.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/root-context.xml"})
public class JdbcMovieDaoITest {

    @Autowired
    private JdbcMovieDao jdbcMovieDao;

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
        List movieByGenreId = jdbcMovieDao.getByGenreId(1);
        assertNotEquals(movieByGenreId.size(), 0);
    }

}