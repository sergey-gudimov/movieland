package com.gudimov.movieland.dao;

import com.gudimov.movieland.dao.link.LinkMovieGenre;

import java.util.List;

public interface MovieGenreDao {
    List<LinkMovieGenre> getAll();
}
