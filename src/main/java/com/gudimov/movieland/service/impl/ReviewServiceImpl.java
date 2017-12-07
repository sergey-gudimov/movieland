package com.gudimov.movieland.service.impl;

import com.gudimov.movieland.dao.ReviewDao;
import com.gudimov.movieland.entity.Review;
import com.gudimov.movieland.service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private ReviewDao reviewDao;

    @Override
    public List<Review> getReviewByMovieId(int movieId) {
        LOG.info("Start service get review by movie id");
        List<Review> review = reviewDao.getReviewByMovieId(movieId);
        LOG.info("Finish service get review by movie id");
        return review;
    }
}
