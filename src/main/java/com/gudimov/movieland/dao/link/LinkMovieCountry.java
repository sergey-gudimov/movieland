package com.gudimov.movieland.dao.link;

public class LinkMovieCountry {
    private int countryId;
    private int movieId;
    private String countryName;

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return "LinkMovieCountry{" +
                "countryId=" + countryId +
                ", movieId=" + movieId +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}
