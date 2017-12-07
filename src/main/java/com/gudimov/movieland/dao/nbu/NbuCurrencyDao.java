package com.gudimov.movieland.dao.nbu;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gudimov.movieland.dao.CurrencyDao;
import com.gudimov.movieland.dto.CurrencyDto;
import com.gudimov.movieland.service.currency.CurrencyCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class NbuCurrencyDao implements CurrencyDao {
    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    @Value(value = "${currency.nbu.url}")
    private String currencyNbuUrl;

    @Override
    public Map<CurrencyCode, Double> getAll() {
        List<CurrencyDto> currencyDtoList = null;
        URL url = null;
        try {
            url = new URL(currencyNbuUrl);
        } catch (IOException e) {
            LOG.error("Error create URL NBU rate", e);
            throw new RuntimeException("Error create URL NBU rate", e);
        }
        OBJECT_MAPPER.configure(
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            currencyDtoList = OBJECT_MAPPER.readValue(url, new TypeReference<List<CurrencyDto>>() {
            });
        } catch (IOException e) {
            LOG.error("Error read NBU rate value ", e);
            throw new RuntimeException("Error read NBU rate value", e);
        }

        Map<CurrencyCode, Double> currencyMap = new HashMap<>();
        for (
                CurrencyDto currencyDto : currencyDtoList)

        {
            if (CurrencyCode.contains(currencyDto.getCc())) {
                currencyMap.put(CurrencyCode.getCurrencyByCode(currencyDto.getCc()), currencyDto.getRate());
            }
        }
        return currencyMap;
    }
}
