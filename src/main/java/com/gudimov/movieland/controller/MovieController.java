package com.gudimov.movieland.controller;

import com.gudimov.movieland.dto.MovieDto;
import com.gudimov.movieland.dto.MovieRandomDto;
import com.gudimov.movieland.entity.Movie;
import com.gudimov.movieland.service.MovieService;
import com.gudimov.movieland.util.JsonJacksonConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "/v1/movie", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
public class MovieController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MovieService movieService;

    static private final JsonJacksonConverter jsonJacksonConverter = new JsonJacksonConverter();

    @RequestMapping
    @ResponseBody
    public ResponseEntity<String> getAllMovie(
            @RequestParam(value = "rating", required = false) String ratingSort,
            @RequestParam(value = "price", required = false) String priceSort) {
        log.info("Sending request to get all movie");
        List<Movie> movies = movieService.getAll(ratingSort, priceSort);
        List<MovieDto> movieDtos = MovieDto.ConvertEntityListToDtoList(movies);
        String movieJson = jsonJacksonConverter.parseItemToJson(movieDtos);
        log.info("Movie {} is received", movieJson);

        return new ResponseEntity<>(movieJson, HttpStatus.OK);

    }

    @RequestMapping(value = "/random")
    @ResponseBody
    public ResponseEntity<String> getRandomMovie() {
        log.info("Sending request to get random movie");
        List<Movie> movies = movieService.getRandom();
        List<MovieRandomDto> movieDtos = new ArrayList<>();
        for (Movie movie : movies) {
            movieDtos.add(new MovieRandomDto(movie));
        }
        String movieJson = jsonJacksonConverter.parseItemToJson(movieDtos);
        log.info("Movie {} is received", movieJson);
        return new ResponseEntity<>(movieJson, HttpStatus.OK);

    }

    @RequestMapping(value = "/genre/{genreId}")
    @ResponseBody
    public ResponseEntity<String> getByGenreId(@PathVariable int genreId,
                                               @RequestParam(value = "rating", required = false) String ratingSort,
                                               @RequestParam(value = "price", required = false) String priceSort) {
        log.info("Sending request to get movie by genre id = {}", genreId);
        List<Movie> movies = movieService.getByGenreId(genreId, ratingSort, priceSort);
        List<MovieDto> movieDtos = MovieDto.ConvertEntityListToDtoList(movies);
        String movieJson = jsonJacksonConverter.parseItemToJson(movieDtos);
        log.info("Movie {} is received", movieJson);

        return new ResponseEntity<>(movieJson, HttpStatus.OK);
    }
}

