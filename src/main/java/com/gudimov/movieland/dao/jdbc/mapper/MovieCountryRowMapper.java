package com.gudimov.movieland.dao.jdbc.mapper;

import com.gudimov.movieland.entity.MovieCountry;
import com.gudimov.movieland.entity.MovieGenre;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieCountryRowMapper implements RowMapper<MovieCountry> {
    @Override
    public MovieCountry mapRow(ResultSet resultSet, int i) throws SQLException {
        MovieCountry movieCountry = new MovieCountry();
        movieCountry.setMovieId(resultSet.getInt("movie_id"));
        movieCountry.setCountryName(resultSet.getString("country_name"));
        movieCountry.setCountryId(resultSet.getInt("country_id"));
        return movieCountry;
    }
}
