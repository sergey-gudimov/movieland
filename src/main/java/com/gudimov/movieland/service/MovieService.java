package com.gudimov.movieland.service;

import com.gudimov.movieland.entity.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MovieService {
    List<Movie> getAll();
}
