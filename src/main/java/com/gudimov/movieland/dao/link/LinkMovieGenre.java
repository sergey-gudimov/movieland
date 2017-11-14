package com.gudimov.movieland.dao.link;

public class LinkMovieGenre {
    private  int movieId;
    private String genreName;
    private int genreId;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    @Override
    public String toString() {
        return "LinkMovieGenre{" +
                "movieId=" + movieId +
                ", genreName='" + genreName + '\'' +
                ", genreId=" + genreId +
                '}';
    }
}

