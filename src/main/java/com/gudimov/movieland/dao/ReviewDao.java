package com.gudimov.movieland.dao;

import com.gudimov.movieland.entity.Review;

import java.util.List;

public interface ReviewDao {
    public List<Review> getReviewByMovieId(int movieId);
}
