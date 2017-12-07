package com.gudimov.movieland.service.impl;

import com.gudimov.movieland.dao.CurrencyDao;
import com.gudimov.movieland.service.CurrencyService;
import com.gudimov.movieland.service.currency.CurrencyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    @Autowired
    private CurrencyDao currencyDao;

    @Override
    public double getByCode(Optional<CurrencyCode> currencyCode) {
        if (currencyCode.isPresent()) {
            Map<CurrencyCode, Double> currencyMap = currencyDao.getAll();
            return currencyMap.get(currencyCode.get());
        }
        return 1;
    }
}
