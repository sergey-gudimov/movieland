package com.gudimov.movieland.dao.jdbc.mapper;

import com.gudimov.movieland.entity.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MovieRowMapper<M> implements RowMapper {
    @Override
    public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
        Movie movie;
        movie = new Movie();
        movie.setId(resultSet.getInt("id"));
        movie.setNameRussian(resultSet.getString("name_Russian"));
        movie.setNameNative(resultSet.getString("name_Native"));
        movie.setYearOfRelease(resultSet.getDate("released_date").toLocalDate());
        movie.setRating(resultSet.getDouble("rating"));
        movie.setPrice(resultSet.getDouble("price"));
        movie.setPicturePath(resultSet.getString("picture_path"));
        return movie;
    }
}
