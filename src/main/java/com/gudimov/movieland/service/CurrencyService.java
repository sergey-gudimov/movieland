package com.gudimov.movieland.service;

import com.gudimov.movieland.service.currency.CurrencyCode;

import java.util.Optional;

public interface CurrencyService {

    public double getByCode(Optional<CurrencyCode> currencyCodeCode);

}
