package com.gudimov.movieland.dao.jdbc.mapper;

import com.gudimov.movieland.entity.Movie;
import org.junit.Test;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by dp-ptcstd-15 on 11/1/2017.
 */
public class MovieRowMapperTest {
    @Test
    public void mapRow() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);

        when(resultSet.getInt("id")).thenReturn(1).thenReturn(2);
        when(resultSet.getString("name_Russian")).thenReturn("Наме 1").thenReturn("Наме 2");
        when(resultSet.getString("name_Native")).thenReturn("Name 1").thenReturn("Name 2");
        when(resultSet.getDate("released_date")).thenReturn(Date.valueOf("2017")).thenReturn(Date.valueOf("2018"));
        when(resultSet.getFloat("rating")).thenReturn((float) 1.2).thenReturn((float) 3.4);
        when(resultSet.getFloat("price")).thenReturn((float) 45).thenReturn((float) 60);
        when(resultSet.getString("picture_path")).thenReturn("path 1").thenReturn("path 2");

        MovieRowMapper movieMapper = new MovieRowMapper();
        Movie actualMovie = movieMapper.mapRow(resultSet, 0);


        assertEquals(actualMovie.getId(), 1);
        assertEquals(actualMovie.getNameNative(), "Наме 1");
        assertEquals(actualMovie.getNameRussian(), "Name 1");
        assertEquals(actualMovie.getYearOfRelease(), Date.valueOf("2017"));
        assertEquals(actualMovie.getRating(),1.2);
        assertEquals(actualMovie.getPrice(),  45);
        assertEquals(actualMovie.getPicturePath(), "path 1");

        assertEquals(actualMovie.getId(), 2);
        assertEquals(actualMovie.getNameNative(), "Наме 2");
        assertEquals(actualMovie.getNameRussian(), "Name 2");
        assertEquals(actualMovie.getYearOfRelease(), Date.valueOf("2018"));
        assertEquals(actualMovie.getRating(), (float) 3.4);
        assertEquals(actualMovie.getPrice(),(float) 60);
        assertEquals(actualMovie.getPicturePath(), "path 2");
    }


}