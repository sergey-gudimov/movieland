package com.gudimov.movieland.dao.jdbc.mapper;

import com.gudimov.movieland.entity.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by dp-ptcstd-15 on 10/31/2017.
 */
public class MovieRowMapper implements RowMapper<Movie> {
    @Override
    public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
        Movie movie = new Movie();
        movie.setId(resultSet.getInt("id"));
        movie.setNameRussian(resultSet.getString("name_Russian"));
        movie.setNameNative(resultSet.getString("name_Native"));
        movie.setYearOfRelease(resultSet.getDate("released_date"));
        movie.setRating(resultSet.getFloat("rating"));
        movie.setPrice(resultSet.getFloat("price"));
        movie.setPicturePath(resultSet.getString("picture_path"));
        return movie;
    }
}
