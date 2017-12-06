package com.gudimov.movieland.service.impl;

import com.gudimov.movieland.dao.MovieCountryDao;
import com.gudimov.movieland.dao.link.LinkMovieCountry;
import com.gudimov.movieland.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private MovieCountryDao movieCountryDao;

    @Override
    public List<LinkMovieCountry> getLinkMovieCountryAll() {
        return movieCountryDao.getAll();
    }
}
