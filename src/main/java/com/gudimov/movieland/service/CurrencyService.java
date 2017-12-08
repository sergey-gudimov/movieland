package com.gudimov.movieland.service;

import com.gudimov.movieland.service.currency.CurrencyCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public interface CurrencyService {

    public double getByCode(Optional<CurrencyCode> currencyCodeCode);

    public default double convertCurrency(double price, Optional<CurrencyCode> currencyCode) {
        if (currencyCode.isPresent()) {
            Logger log = LoggerFactory.getLogger(getClass());
            log.info("Start currency exchange to currency = {}", currencyCode);
            double currencyRate = getByCode(currencyCode);
            double convertedPrice = price / currencyRate;
            log.info("Finish currency exchange. UAH price = {} convert to currency {} price {} with rate {} ", price, currencyCode, convertedPrice, currencyRate);
            return convertedPrice;
        }
        return price;
    }
}
