package com.gudimov.movieland.dao.jdbc.mapper;

import com.gudimov.movieland.entity.MovieCountry;
import org.junit.Test;

import java.sql.ResultSet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MovieCountryRowMapperTest {
    @Test
    public void mapRow() throws Exception {

        ResultSet resultSet = mock(ResultSet.class);

        when(resultSet.getInt("movie_id")).thenReturn(1).thenReturn(2);
        when(resultSet.getInt("country_id")).thenReturn(11).thenReturn(22);
        when(resultSet.getString("country_name")).thenReturn("UA").thenReturn("UK");

        MovieCountryRowMapper movieCountryRowMapper = new MovieCountryRowMapper();

        MovieCountry actualMovie = movieCountryRowMapper.mapRow(resultSet, 0);
        assertEquals( 1,actualMovie.getMovieId());
        assertEquals( 11,actualMovie.getCountryId());
        assertEquals( "UA",actualMovie.getCountryName());

        actualMovie = movieCountryRowMapper.mapRow(resultSet, 1);
        assertEquals( 2,actualMovie.getMovieId());
        assertEquals( 22,actualMovie.getCountryId());
        assertEquals( "UK",actualMovie.getCountryName());
    }

}