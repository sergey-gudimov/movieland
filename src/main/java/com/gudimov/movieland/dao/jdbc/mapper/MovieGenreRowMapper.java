package com.gudimov.movieland.dao.jdbc.mapper;

import com.gudimov.movieland.dao.link.LinkMovieGenre;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieGenreRowMapper implements RowMapper<LinkMovieGenre> {
    @Override
    public LinkMovieGenre mapRow(ResultSet resultSet, int i) throws SQLException {
        LinkMovieGenre linkMovieGenre = new LinkMovieGenre();
        linkMovieGenre.setMovieId(resultSet.getInt("movie_id"));
        linkMovieGenre.setGenreName(resultSet.getString("genre_name"));
        linkMovieGenre.setGenreId(resultSet.getInt("genre_id"));
        return linkMovieGenre;
    }
}
