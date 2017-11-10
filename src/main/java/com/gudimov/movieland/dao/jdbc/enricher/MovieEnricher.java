package com.gudimov.movieland.dao.jdbc.enricher;

import com.gudimov.movieland.entity.*;
import com.gudimov.movieland.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class MovieEnricher {

    @Autowired
    private MovieService movieService;

    public List<MovieWithGenreCountry> EnrichMovieWithGenreCountry(List<MovieWithGenreCountry> listMovie) {
        for (MovieWithGenreCountry movie : listMovie) {
            movie.setGenre(getGenreListByMovieId(movie.getId()));
            movie.setCountry(getCountryListByMovieId(movie.getId()));
        }
        return listMovie;
    }

    private List<Genre> getGenreListByMovieId(int id) {
        List<MovieGenre> movieGenreAll = movieService.getMovieGenreAll();
        List<Genre> genreList = new ArrayList();

        for (MovieGenre movieGenre : movieGenreAll) {
            if(movieGenre.getMovieId() == id){
                Genre genre = new Genre();
                genre.setId(movieGenre.getGenreId());
                genre.setName(movieGenre.getGenreName());
                genreList.add(genre);
            }
        }
        return genreList;
    }

    private List<Country> getCountryListByMovieId(int id) {
        List<MovieCountry> movieCountryAll = movieService.getMovieCountryAll();
        List<Country> countryList = new ArrayList();

        for (MovieCountry movieCountry : movieCountryAll) {
            if(movieCountry.getMovieId() == id){
                Country contry = new Country();
                contry.setId(movieCountry.getCountryId());
                contry.setName(movieCountry.getCountryName());
                countryList.add(contry);
            }
        }
        return countryList;
    }
}
