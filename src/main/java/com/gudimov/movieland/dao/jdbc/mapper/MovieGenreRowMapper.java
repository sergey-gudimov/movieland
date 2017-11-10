package com.gudimov.movieland.dao.jdbc.mapper;

import com.gudimov.movieland.entity.MovieGenre;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieGenreRowMapper implements RowMapper<MovieGenre> {
    @Override
    public MovieGenre mapRow(ResultSet resultSet, int i) throws SQLException {
        MovieGenre movieGenre = new MovieGenre();
        movieGenre.setMovieId(resultSet.getInt("movie_id"));
        movieGenre.setGenreName(resultSet.getString("genre_name"));
        movieGenre.setGenreId(resultSet.getInt("genre_id"));
        return movieGenre;
    }
}
