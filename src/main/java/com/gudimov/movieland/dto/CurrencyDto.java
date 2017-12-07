package com.gudimov.movieland.dto;

public class CurrencyDto {
    private String cc;
    private Double rate;

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "CurrencyDto{" +
                "cc='" + cc + '\'' +
                ", rate=" + rate +
                '}';
    }
}
