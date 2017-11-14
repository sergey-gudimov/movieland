package com.gudimov.movieland.service.enricher;

import com.gudimov.movieland.dao.link.LinkMovieCountry;
import com.gudimov.movieland.dao.link.LinkMovieGenre;
import com.gudimov.movieland.entity.*;
import com.gudimov.movieland.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieEnricher {

    @Autowired
    private MovieService movieService;

    public List<Movie> enrichMovie(List<Movie> listMovie) {
        for (Movie movie : listMovie) {
            movie.setGenre(getGenreListByMovieId(movie.getId()));
            movie.setCountry(getCountryListByMovieId(movie.getId()));
        }
        return listMovie;
    }

    private List<Genre> getGenreListByMovieId(int id) {
        List<LinkMovieGenre> linkMovieGenreAll = movieService.getMovieGenreAll();
        List<Genre> genreList = new ArrayList();

        for (LinkMovieGenre linkMovieGenre : linkMovieGenreAll) {
            if (linkMovieGenre.getMovieId() == id) {
                Genre genre = new Genre();
                genre.setId(linkMovieGenre.getGenreId());
                genre.setName(linkMovieGenre.getGenreName());
                genreList.add(genre);
            }
        }
        return genreList;
    }

    private List<Country> getCountryListByMovieId(int id) {
        List<LinkMovieCountry> linkMovieCountryAll = movieService.getMovieCountryAll();
        List<Country> countryList = new ArrayList();

        for (LinkMovieCountry linkMovieCountry : linkMovieCountryAll) {
            if (linkMovieCountry.getMovieId() == id) {
                Country contry = new Country();
                contry.setId(linkMovieCountry.getCountryId());
                contry.setName(linkMovieCountry.getCountryName());
                countryList.add(contry);
            }
        }
        return countryList;
    }
}
