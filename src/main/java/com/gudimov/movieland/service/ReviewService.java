package com.gudimov.movieland.service;

import com.gudimov.movieland.entity.Review;

import java.util.List;

public interface ReviewService {

    public List<Review> getReviewByMovieId(int movieId);
}
