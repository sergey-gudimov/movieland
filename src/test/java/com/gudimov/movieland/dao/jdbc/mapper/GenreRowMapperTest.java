package com.gudimov.movieland.dao.jdbc.mapper;

import com.gudimov.movieland.entity.Genre;
import org.junit.Test;

import java.sql.ResultSet;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GenreRowMapperTest {
    @Test
    public void mapRow() throws Exception {
        ResultSet resultSet = mock(ResultSet.class);

        when(resultSet.getInt("id")).thenReturn(1).thenReturn(2);
        when(resultSet.getString("name")).thenReturn("Наме 1").thenReturn("Наме 2");

        GenreRowMapper genreMapper = new GenreRowMapper();

        Genre actualGenre = genreMapper.mapRow(resultSet, 0);
        assertEquals(1, actualGenre.getId());
        assertEquals("Наме 1", actualGenre.getName());

        actualGenre = genreMapper.mapRow(resultSet, 1);
        assertEquals(2, actualGenre.getId());
        assertEquals("Наме 2", actualGenre.getName());
    }

}