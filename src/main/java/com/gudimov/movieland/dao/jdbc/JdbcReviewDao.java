package com.gudimov.movieland.dao.jdbc;

import com.gudimov.movieland.dao.ReviewDao;
import com.gudimov.movieland.dao.jdbc.mapper.ReviewRowMapper;
import com.gudimov.movieland.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcReviewDao implements ReviewDao {
    private static final ReviewRowMapper REVIEW_ROW_MAPPER = new ReviewRowMapper();
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private String getReviewByMovieIdSQL;

    @Override
    public List<Review> getReviewByMovieId(int movieId) {
        LOG.info("Start query to get review by movie id from DB");
        List<Review> listReview = jdbcTemplate.query(getReviewByMovieIdSQL, REVIEW_ROW_MAPPER, movieId);
        LOG.info("Finish query to get review by movie id from DB");

        return listReview;
    }
}
