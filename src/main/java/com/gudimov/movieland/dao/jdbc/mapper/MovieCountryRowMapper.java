package com.gudimov.movieland.dao.jdbc.mapper;

import com.gudimov.movieland.dao.link.LinkMovieCountry;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieCountryRowMapper implements RowMapper<LinkMovieCountry> {
    @Override
    public LinkMovieCountry mapRow(ResultSet resultSet, int i) throws SQLException {
        LinkMovieCountry linkMovieCountry = new LinkMovieCountry();
        linkMovieCountry.setMovieId(resultSet.getInt("movie_id"));
        linkMovieCountry.setCountryName(resultSet.getString("country_name"));
        linkMovieCountry.setCountryId(resultSet.getInt("country_id"));
        return linkMovieCountry;
    }
}
