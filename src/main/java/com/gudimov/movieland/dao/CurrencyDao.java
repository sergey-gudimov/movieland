package com.gudimov.movieland.dao;

import com.gudimov.movieland.service.currency.CurrencyCode;

import java.util.Map;

public interface CurrencyDao {
    public Map<CurrencyCode, Double> getAll();
}
