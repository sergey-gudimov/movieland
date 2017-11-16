package com.gudimov.movieland.dao.jdbc.mapper;

import com.gudimov.movieland.entity.Genre;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreRowMapper implements RowMapper<Genre> {
    @Override
    public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
        Genre Genre = new Genre();
        Genre.setId(resultSet.getInt("id"));
        Genre.setName(resultSet.getString("name"));
        return Genre;
    }
}
