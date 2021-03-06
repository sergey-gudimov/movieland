package com.gudimov.movieland.service.impl;

import com.gudimov.movieland.dao.GenreDao;
import com.gudimov.movieland.dao.MovieGenreDao;
import com.gudimov.movieland.dao.link.LinkMovieGenre;
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
    private GenreDao genreDao;

    @Autowired
    private MovieGenreDao movieGenreDao;

    @Override
    public List<Genre> getAll() {
        LOG.info("Start service get all genre cache");
        List<Genre> all = genreDao.getAll();
        LOG.info("Finish service get all genre cache");
        return all;
    }

    @Override
    public List<LinkMovieGenre> getLinkMovieGenreAll() {
        return movieGenreDao.getAll();
    }
}
