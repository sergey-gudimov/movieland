package com.gudimov.movieland.service.currency;

import com.gudimov.movieland.entity.Movie;
import com.gudimov.movieland.service.CurrencyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurrencyConverter {
    private final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    CurrencyService currencyService;

    public void convertCurrency(Movie movie, Optional<CurrencyCode> currencyCode) {
        if (currencyCode.isPresent()) {
            log.info("Start currency exchange to currency = {}", currencyCode);
            double currencyRate = currencyService.getByCode(currencyCode);
            double price = movie.getPrice();
            double convertedPrice = price / currencyRate;
            movie.setPrice(convertedPrice);
            log.info("Finish currency exchange. UAH price = {} convert to currency {} price {} with rate {} ", price, currencyCode, convertedPrice, currencyRate);
        }
    }

}
