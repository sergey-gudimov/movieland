package com.gudimov.movieland.service.impl;

import com.gudimov.movieland.dao.MovieDao;
import com.gudimov.movieland.entity.Movie;
import com.gudimov.movieland.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MoviewServiceImpl implements MovieService {
    @Autowired
    MovieDao movieDao;

    @Override
    public List<Movie> getAll() {
        return movieDao.getAllMoview();
    }
}
