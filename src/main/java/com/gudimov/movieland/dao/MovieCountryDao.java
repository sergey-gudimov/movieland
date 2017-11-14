package com.gudimov.movieland.dao;

import com.gudimov.movieland.dao.link.LinkMovieCountry;

import java.util.List;

public interface MovieCountryDao {
    List<LinkMovieCountry> getAll();
}
