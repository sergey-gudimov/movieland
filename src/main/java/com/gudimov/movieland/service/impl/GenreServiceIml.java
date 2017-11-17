package com.gudimov.movieland.service.impl;

import com.gudimov.movieland.cache.GenreCache;
import com.gudimov.movieland.entity.Genre;
import com.gudimov.movieland.service.GenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceIml implements GenreService {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private GenreCache genreCache;

    @Override
    public List<Genre> getAll() {
        LOG.info("Start service get all genre cache");
        List<Genre> all = genreCache.getAll();
        LOG.info("Finish service get all genre cache");
        return all;
    }
}
