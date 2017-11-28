package com.gudimov.movieland.dao.jdbc.mapper;

import com.gudimov.movieland.entity.Movie;
import org.junit.Test;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class MovieRowMapperTest {
    @Test
    public void mapRow() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);

        when(resultSet.getInt("id")).thenReturn(1).thenReturn(2);
        when(resultSet.getString("name_Russian")).thenReturn("Наме 1").thenReturn("Наме 2");
        when(resultSet.getString("name_Native")).thenReturn("Name 1").thenReturn("Name 2");
        when(resultSet.getDate("released_date")).thenReturn(Date.valueOf(LocalDate.of(2017, 1, 1))).thenReturn(Date.valueOf(LocalDate.of(2018, 1, 1)));
        when(resultSet.getDouble("rating")).thenReturn(1.2).thenReturn(3.4);
        when(resultSet.getDouble("price")).thenReturn(45d).thenReturn(60d);
        when(resultSet.getString("picture_path")).thenReturn("path 1").thenReturn("path 2");

        MovieRowMapper movieMapper = new MovieRowMapper();

        Movie actualMovie = movieMapper.mapRow(resultSet, 0);
        assertEquals(1, actualMovie.getId());
        assertEquals("Наме 1", actualMovie.getNameRussian());
        assertEquals("Name 1", actualMovie.getNameNative());
        assertEquals(2017, actualMovie.getYearOfRelease());
        assertEquals(1.2, 0, actualMovie.getRating());
        assertEquals(45, 0, actualMovie.getPrice());
        assertEquals("path 1", actualMovie.getPicturePath());

        actualMovie = movieMapper.mapRow(resultSet, 1);
        assertEquals(2, actualMovie.getId());
        assertEquals("Наме 2", actualMovie.getNameRussian());
        assertEquals("Name 2", actualMovie.getNameNative());
        assertEquals(2018, actualMovie.getYearOfRelease());
        assertEquals(3.4, 0, actualMovie.getRating());
        assertEquals(60, 0, actualMovie.getPrice());
        assertEquals("path 2", actualMovie.getPicturePath());
    }


}