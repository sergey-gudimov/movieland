package com.gudimov.movieland.service;

import com.gudimov.movieland.dao.link.LinkMovieGenre;
import com.gudimov.movieland.entity.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> getAll();

    List<LinkMovieGenre> getLinkMovieGenreAll();
}
