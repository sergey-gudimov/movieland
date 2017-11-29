package com.gudimov.movieland.dao.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/root-context.xml"})
public class JdbcReviewDaoITest {

    @Autowired
    private JdbcReviewDao jdbcReviewDao;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private String getMovieMaxIdSQL;

    @Autowired
    private String getReviewByMovieIdSQL;
    @Test
    public void getReviewByMovieId() throws Exception {
        int movieId = jdbcTemplate.queryForObject(getMovieMaxIdSQL, Integer.class);
        List reviewList = jdbcReviewDao.getReviewByMovieId(movieId);
        assertNotEquals(reviewList.size(), 0);
    }

}