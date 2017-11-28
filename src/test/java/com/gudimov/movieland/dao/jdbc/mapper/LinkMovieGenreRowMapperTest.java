package com.gudimov.movieland.dao.jdbc.mapper;

import com.gudimov.movieland.dao.link.LinkMovieGenre;
import org.junit.Test;

import java.sql.ResultSet;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LinkMovieGenreRowMapperTest {
    @Test
    public void mapRow() throws Exception {

        ResultSet resultSet = mock(ResultSet.class);

        when(resultSet.getInt("movie_id")).thenReturn(1).thenReturn(2);
        when(resultSet.getInt("genre_id")).thenReturn(11).thenReturn(22);
        when(resultSet.getString("genre_name")).thenReturn("Жах").thenReturn("Комедия");

        MovieGenreRowMapper movieGenreRowMapper = new MovieGenreRowMapper();

        LinkMovieGenre actualMovie = movieGenreRowMapper.mapRow(resultSet, 0);
        assertEquals(1, actualMovie.getMovieId());
        assertEquals(11, actualMovie.getGenreId());
        assertEquals("Жах", actualMovie.getGenreName());

        actualMovie = movieGenreRowMapper.mapRow(resultSet, 1);
        assertEquals(2, actualMovie.getMovieId());
        assertEquals(22, actualMovie.getGenreId());
        assertEquals("Комедия", actualMovie.getGenreName());
    }
}