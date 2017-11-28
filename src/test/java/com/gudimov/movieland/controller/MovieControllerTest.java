package com.gudimov.movieland.controller;

import com.gudimov.movieland.entity.Country;
import com.gudimov.movieland.entity.Genre;
import com.gudimov.movieland.entity.Movie;
import com.gudimov.movieland.service.MovieService;
import com.gudimov.movieland.service.sorter.SortOrder;
import com.gudimov.movieland.service.sorter.ValidatorSortParams;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class MovieControllerTest {

    private MockMvc mockMvc;
    private Movie movieFirst = new Movie();
    private Movie movieSecond = new Movie();

    @Mock
    private MovieService movieServiceMock;

    @Mock
    private ValidatorSortParams validatorSortParams;

    @InjectMocks
    private MovieController movieController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(movieController).build();
        setUpServiceMock();
    }


    private void setUpServiceMock() {
        movieFirst.setId(1);
        movieFirst.setNameNative("Day");
        movieFirst.setNameRussian("День");
        movieFirst.setPicturePath("pictureDay");
        movieFirst.setPrice(30);
        movieFirst.setRating(4);
        movieFirst.setYearOfRelease(LocalDate.of(2018, 1, 1));

        movieSecond.setId(2);
        movieSecond.setNameNative("Sea");
        movieSecond.setNameRussian("Море");
        movieSecond.setPicturePath("pictureSea");
        movieSecond.setPrice(40);
        movieSecond.setRating(5);
        movieSecond.setYearOfRelease(LocalDate.of(2018, 1, 1));

        when(movieServiceMock.getAll(Optional.ofNullable(any(SortOrder.class)), Optional.ofNullable(any(SortOrder.class)))).thenReturn(Arrays.asList(movieFirst, movieSecond));
        when(movieServiceMock.getByGenreId(eq(1), Optional.ofNullable(any(SortOrder.class)), Optional.ofNullable(any(SortOrder.class)))).thenReturn(Arrays.asList(movieFirst, movieSecond));
    }

    @Test
    public void getAllMovie() throws Exception {

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
        verify(movieServiceMock, times(1)).getAll(Optional.ofNullable(any(SortOrder.class)), Optional.ofNullable(any(SortOrder.class)));

        //Ensure that no other methods of our mock object are called during the test.
        verifyNoMoreInteractions(movieServiceMock);
    }

    @Test
    public void getRandomMovie() throws Exception {
        Movie movieFirst = new Movie();
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

        Movie movieSecond = new Movie();
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

        when(movieServiceMock.getRandom()).thenReturn(Arrays.asList(movieFirst, movieSecond));

        mockMvc.perform(get("/v1/movie/random")).andExpect(status().isOk())
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
        verify(movieServiceMock, times(1)).getRandom();

        //Ensure that no other methods of our mock object are called during the test.
        verifyNoMoreInteractions(movieServiceMock);
    }

    @Test
    public void getMovieByGenreId() throws Exception {

        mockMvc.perform(get("/v1/movie/genre/1")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(movieFirst.getId())))
                .andExpect(jsonPath("$[0].nameNative", is(movieFirst.getNameNative())))
                .andExpect(jsonPath("$[0].nameRussian", is(movieFirst.getNameRussian())))
                .andExpect(jsonPath("$[0].picturePath", is(movieFirst.getPicturePath())))
                .andExpect(jsonPath("$[0].price", is(movieFirst.getPrice())))
                .andExpect(jsonPath("$[0].rating", is(movieFirst.getRating())))
                .andExpect(jsonPath("$[0].yearOfRelease", is(movieFirst.getYearOfRelease())))
                .andExpect(jsonPath("$[1].id", is(movieSecond.getId())))
                .andExpect(jsonPath("$[1].nameNative", is(movieSecond.getNameNative())))
                .andExpect(jsonPath("$[1].nameRussian", is(movieSecond.getNameRussian())))
                .andExpect(jsonPath("$[1].picturePath", is(movieSecond.getPicturePath())))
                .andExpect(jsonPath("$[1].price", is(movieSecond.getPrice())))
                .andExpect(jsonPath("$[1].rating", is(movieSecond.getRating())))
                .andExpect(jsonPath("$[1].yearOfRelease", is(movieSecond.getYearOfRelease())))
        ;
        //Verify that the getByGenreId() method of the Service interface is called only once.
        verify(movieServiceMock, times(1)).getByGenreId(eq(1), Optional.ofNullable(any(SortOrder.class)),Optional.ofNullable(any(SortOrder.class)));

        //Ensure that no other methods of our mock object are called during the test.
        verifyNoMoreInteractions(movieServiceMock);
    }
}