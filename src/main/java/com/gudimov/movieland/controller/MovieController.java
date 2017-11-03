package com.gudimov.movieland.controller;

import com.gudimov.movieland.entity.Movie;
import com.gudimov.movieland.service.MovieService;
import com.gudimov.movieland.util.JsonJacksonConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value = "/v1/movie")
public class MovieController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MovieService movieService;

    @Autowired
    private JsonJacksonConverter jsonJacksonConverter;

    @RequestMapping(method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    @ResponseBody
    public String getAllMovie() {
        log.info("Sending request to get all movie");
        List<Movie> movie= movieService.getAll();
        String movieJson = jsonJacksonConverter.parseMovieToJson(movie);
        log.info("Movie {} is received", movieJson);
        return movieJson;
    }

}
