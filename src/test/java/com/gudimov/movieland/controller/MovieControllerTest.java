package com.gudimov.movieland.controller;

import com.gudimov.movieland.entity.Country;
import com.gudimov.movieland.entity.Genre;
import com.gudimov.movieland.entity.Movie;
import com.gudimov.movieland.entity.MovieWithGenreCountry;
import com.gudimov.movieland.service.MovieService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

public class MovieControllerTest {
    private MockMvc mockMvc;

    @Mock
    private MovieService movieServiceMock;

    @InjectMocks
    private MovieController movieController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(movieController).build();
    }


    @Test
    public void getAllMovie() throws Exception {
        Movie movieFirst = new Movie();
        movieFirst.setId(1);
        movieFirst.setNameNative("Day");
        movieFirst.setNameRussian("День");
        movieFirst.setPicturePath("pictureDay");
        movieFirst.setPrice(30);
        movieFirst.setRating(4);
        movieFirst.setYearOfRelease(LocalDate.of(2018, 1, 1));

        Movie movieSecond = new Movie();
        movieSecond.setId(2);
        movieSecond.setNameNative("Sea");
        movieSecond.setNameRussian("Море");
        movieSecond.setPicturePath("pictureSea");
        movieSecond.setPrice(40);
        movieSecond.setRating(5);
        movieSecond.setYearOfRelease(LocalDate.of(2018, 1, 1));

        when(movieServiceMock.getAll()).thenReturn(Arrays.asList(movieFirst, movieSecond));

        mockMvc.perform(get("/v1/movie")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].nameNative", is("Day")))
                .andExpect(jsonPath("$[0].nameRussian", is("День")))
                .andExpect(jsonPath("$[0].picturePath", is("pictureDay")))
                .andExpect(jsonPath("$[0].price", is(30d)))
                .andExpect(jsonPath("$[0].rating", is(4d)))
                .andExpect(jsonPath("$[0].yearOfRelease", is(2018)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].nameNative", is("Sea")))
                .andExpect(jsonPath("$[1].nameRussian", is("Море")))
                .andExpect(jsonPath("$[1].picturePath", is("pictureSea")))
                .andExpect(jsonPath("$[1].price", is(40d)))
                .andExpect(jsonPath("$[1].rating", is(5d)))
                .andExpect(jsonPath("$[1].yearOfRelease", is(2018)))
        ;
        //Verify that the findAll() method of the Service interface is called only once.
        verify(movieServiceMock, times(1)).getAll();

        //Ensure that no other methods of our mock object are called during the test.
        verifyNoMoreInteractions(movieServiceMock);
    }

    @Test
    public void getRandomMovie() throws Exception {
        MovieWithGenreCountry movieFirst = new MovieWithGenreCountry();
        movieFirst.setId(1);
        movieFirst.setNameNative("Day");
        movieFirst.setNameRussian("День");
        movieFirst.setPicturePath("pictureDay");
        movieFirst.setPrice(30);
        movieFirst.setRating(4);
        movieFirst.setYearOfRelease(LocalDate.of(2018, 1, 1));
        Country countryUA = new Country();
        countryUA.setId(1);
        countryUA.setName("UA");
        Country countryUK = new Country();
        countryUK.setId(2);
        countryUK.setName("UK");
        movieFirst.setCountry(Arrays.asList(countryUA, countryUK));
        Genre genre1 = new Genre();
        genre1.setId(5);
        genre1.setName("Genre 1");
        Genre genre2 = new Genre();
        genre2.setId(6);
        genre2.setName("Genre 2");
        movieFirst.setGenre(Arrays.asList(genre1, genre2));

        MovieWithGenreCountry movieSecond = new MovieWithGenreCountry();
        movieSecond.setId(2);
        movieSecond.setNameNative("Sea");
        movieSecond.setNameRussian("Море");
        movieSecond.setPicturePath("pictureSea");
        movieSecond.setPrice(40);
        movieSecond.setRating(5);
        movieSecond.setYearOfRelease(LocalDate.of(2018, 1, 1));
        Country country1 = new Country();
        country1.setId(4);
        country1.setName("Италия");
        Country country2 = new Country();
        country2.setId(5);
        country2.setName("Германия");
        movieSecond.setCountry(Arrays.asList(country1, country2));
        genre1 = new Genre();
        genre1.setId(1);
        genre1.setName("драма");
        genre2 = new Genre();
        genre2.setId(6);
        genre2.setName("мелодрама");
        movieSecond.setGenre(Arrays.asList(genre1, genre2));

        when(movieServiceMock.getAll()).thenReturn(Arrays.asList(movieFirst, movieSecond));

        mockMvc.perform(get("/v1/movie")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].nameNative", is("Day")))
                .andExpect(jsonPath("$[0].nameRussian", is("День")))
                .andExpect(jsonPath("$[0].picturePath", is("pictureDay")))
                .andExpect(jsonPath("$[0].price", is(30d)))
                .andExpect(jsonPath("$[0].rating", is(4d)))
                .andExpect(jsonPath("$[0].yearOfRelease", is(2018)))
                .andExpect(jsonPath("$[0].country[0].id", is(1)))
                .andExpect(jsonPath("$[0].country[0].name", is("UA")))
                .andExpect(jsonPath("$[0].country[1].id", is(2)))
                .andExpect(jsonPath("$[0].country[1].name", is("UK")))
                .andExpect(jsonPath("$[0].genre[0].id", is(5)))
                .andExpect(jsonPath("$[0].genre[0].name", is("Genre 1")))
                .andExpect(jsonPath("$[0].genre[1].id", is(6)))
                .andExpect(jsonPath("$[0].genre[1].name", is("Genre 2")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].nameNative", is("Sea")))
                .andExpect(jsonPath("$[1].nameRussian", is("Море")))
                .andExpect(jsonPath("$[1].picturePath", is("pictureSea")))
                .andExpect(jsonPath("$[1].price", is(40d)))
                .andExpect(jsonPath("$[1].rating", is(5d)))
                .andExpect(jsonPath("$[1].yearOfRelease", is(2018)))
                .andExpect(jsonPath("$[1].country[0].id", is(4)))
                .andExpect(jsonPath("$[1].country[0].name", is("Италия")))
                .andExpect(jsonPath("$[1].country[1].id", is(5)))
                .andExpect(jsonPath("$[1].country[1].name", is("Германия")))
                .andExpect(jsonPath("$[1].genre[0].id", is(1)))
                .andExpect(jsonPath("$[1].genre[0].name", is("драма")))
                .andExpect(jsonPath("$[1].genre[1].id", is(6)))
                .andExpect(jsonPath("$[1].genre[1].name", is("мелодрама")))
        ;
        //Verify that the findAll() method of the Service interface is called only once.
        verify(movieServiceMock, times(1)).getAll();

        //Ensure that no other methods of our mock object are called during the test.
        verifyNoMoreInteractions(movieServiceMock);
    }

}