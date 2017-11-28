package com.gudimov.movieland.controller;

import com.gudimov.movieland.entity.Genre;
import com.gudimov.movieland.service.GenreService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class GenreControllerTest {

    private MockMvc mockMvc;

    @Mock
    private GenreService genreServiceMock;

    @InjectMocks
    private GenreController genreController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(genreController).build();
    }

    @Test
    public void getAll() throws Exception {
        Genre genreFirst = new Genre();
        genreFirst.setId(1);
        genreFirst.setName("Драмма");

        Genre genreSecond = new Genre();
        genreSecond.setId(2);
        genreSecond.setName("Криминал");

        when(genreServiceMock.getAll()).thenReturn(Arrays.asList(genreFirst, genreSecond));

        mockMvc.perform(get("/v1/genre")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("Драмма")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].name", is("Криминал")))
        ;
        //Verify that the findAll() method of the Service interface is called only once.
        verify(genreServiceMock, times(1)).getAll();

        //Ensure that no other methods of our mock object are called during the test.
        verifyNoMoreInteractions(genreServiceMock);
    }

}