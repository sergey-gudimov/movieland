package com.gudimov.movieland.service.currency;

public enum CurrencyCode {
    USD("USD"), EUR("EUR");

    private String currency;

    CurrencyCode(String currency) {
        this.currency = currency.toUpperCase();
    }

    public static CurrencyCode getCurrencyByCode(String currency) {
        if (currency == null) {
            return null;
        }
        for (CurrencyCode currencyCodeValue : CurrencyCode.values()) {
            if (currencyCodeValue.currency.equalsIgnoreCase(currency)) {
                return currencyCodeValue;
            }
        }
        throw new IllegalArgumentException("Incorrect currency code " + currency);
    }

    public static boolean contains(String currency) {
        for (CurrencyCode currencyCode : CurrencyCode.values()) {
            if (currencyCode.currency.equalsIgnoreCase(currency)) {
                return true;
            }
        }
        return false;
    }
}
