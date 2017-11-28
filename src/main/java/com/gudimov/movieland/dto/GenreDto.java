package com.gudimov.movieland.dto;

import com.gudimov.movieland.entity.Genre;

public class GenreDto {
    private final int id;
    private final String name;

    public GenreDto(Genre genre) {
        id = genre.getId();
        name = genre.getName();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
