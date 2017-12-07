package com.gudimov.movieland.dao.jdbc.mapper;

import com.gudimov.movieland.entity.Review;
import org.junit.Test;

import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReviewRowMapperTest {
    @Test
    public void mapRow() throws Exception {
        ResultSet resultSet = mock(ResultSet.class);

        Review review1 = new Review();
        review1.setId(1);
        review1.setMovieId(3);
        review1.setUserId(5);
        review1.setText("description 1");

        Review review2 = new Review();
        review2.setId(2);
        review2.setMovieId(4);
        review2.setUserId(5);
        review2.setText("description 2");

        List<Review> reviewList = Arrays.asList(review1, review2);

        when(resultSet.getInt("id")).thenReturn(review1.getId()).thenReturn(review2.getId());
        when(resultSet.getInt("movie_id")).thenReturn(review1.getMovieId()).thenReturn(review2.getMovieId());
        when(resultSet.getInt("user_id")).thenReturn(review1.getUserId()).thenReturn(review2.getMovieId());
        when(resultSet.getString("description")).thenReturn(review1.getText()).thenReturn(review2.getText());

        ReviewRowMapper reviewRowMapper = new ReviewRowMapper();
        for (int i = 0; i < 2; i++) {
            Review actualReview = reviewRowMapper.mapRow(resultSet, i);
            Review expectedReview = reviewList.get(i);
            assertEquals(expectedReview.getId(), actualReview.getId());
            assertEquals(expectedReview.getMovieId(), actualReview.getMovieId());
            assertEquals(expectedReview.getUser(), actualReview.getUser());
            assertEquals(expectedReview.getText(), actualReview.getText());
        }

    }

}