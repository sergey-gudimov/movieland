package com.gudimov.movieland.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CurrencyConversion {
    private static final Logger LOG = LoggerFactory.getLogger(CurrencyConversion.class);

    public static double priceConvert(double price, double currencyRate) {
        LOG.info("Start currency conversion to currency rate = {}", currencyRate);
        double convertedPrice = price / currencyRate;
        LOG.info("Finish currency exchange. Price = {} convert to currency rate {} price {} with rate {} ", price, currencyRate, convertedPrice, currencyRate);
        return convertedPrice;
    }
}
