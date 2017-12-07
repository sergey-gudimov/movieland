package com.gudimov.movieland.web.controller;

import com.gudimov.movieland.dto.GenreDto;
import com.gudimov.movieland.entity.Genre;
import com.gudimov.movieland.service.GenreService;
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

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/v1/genre", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
public class GenreController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private GenreService genreService;

    @RequestMapping
    @ResponseBody
    public ResponseEntity<String> getAll() {
        log.info("Sending request to get all genre");
        List<Genre> genres = genreService.getAll();
        List<GenreDto> genreDtos = new ArrayList<>();
        for (Genre genre : genres) {
            genreDtos.add(new GenreDto(genre));
        }
        String genreJson = JsonJacksonConverter.itemToJson(genreDtos);
        log.info("Genre {} is received", genreJson);

        return new ResponseEntity<>(genreJson, HttpStatus.OK);

    }
}
