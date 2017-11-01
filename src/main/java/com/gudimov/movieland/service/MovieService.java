package com.gudimov.movieland.service;

import com.gudimov.movieland.entity.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dp-ptcstd-15 on 10/30/2017.
 */
public interface MovieService {
    List<Movie> getAll();
}
