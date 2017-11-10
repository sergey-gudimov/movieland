package com.gudimov.movieland.controller;

import com.gudimov.movieland.entity.Movie;
import com.gudimov.movieland.entity.MovieWithGenreCountry;
import com.gudimov.movieland.service.MovieService;
import com.gudimov.movieland.util.JsonJacksonConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping(value = "/v1/movie", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
public class MovieController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MovieService movieService;

    static private JsonJacksonConverter jsonJacksonConverter = new JsonJacksonConverter();

    @RequestMapping
    @ResponseBody
    public ResponseEntity<String> getAllMovie() {
        log.info("Sending request to get all movie");
        List<Movie> movie = movieService.getAll();
        String movieJson = jsonJacksonConverter.parseItemToJson(movie);
        log.info("Movie {} is received", movieJson);
        if (movieJson == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(movieJson, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/random")
    @ResponseBody
    public ResponseEntity<String> getRandomMovie() {
        log.info("Sending request to get random movie");
        List<MovieWithGenreCountry> movie = movieService.getRandom();

        String movieJson = jsonJacksonConverter.parseItemToJson(movie);
        log.info("Movie {} is received", movieJson);
        if (movieJson == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(movieJson, HttpStatus.OK);
        }
    }
}

