package com.gudimov.movieland.dao.jdbc;

import com.gudimov.movieland.entity.MovieCountry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/root-context.xml"})
public class JdbcMovieCountryDaoTest {

    @Autowired
    private JdbcMovieCountryDao jdbcMovieCountryDao;

    @Test
    public void getAll() throws Exception {
        List<MovieCountry> allRecords = jdbcMovieCountryDao.getAll();
        assertNotEquals(allRecords.size(), 0);
    }

}