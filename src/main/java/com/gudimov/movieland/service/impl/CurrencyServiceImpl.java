package com.gudimov.movieland.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gudimov.movieland.service.CurrencyService;
import com.gudimov.movieland.service.currency.CurrencyCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private volatile Map<CurrencyCode, Double> currencyMap;

    @Value(value = "${currency.nbu.url}")
    private String currencyNbuUrl;

    @Override
    public double getByCode(Optional<CurrencyCode> currencyCode) {
        if (currencyCode.isPresent()) {
            return currencyMap.get(currencyCode.get());
        }
        return 1;
    }

    @PostConstruct
    public void invalidate() {
        LOG.info("Start currency cache invalidate");
        currencyMap = getAll();
        LOG.info("Finish currency cache invalidate");
    }

    @Scheduled(cron = "${cache.currency.refresh.interval}")
    private void putOnSchedule() {
        invalidate();
    }

    private Map<CurrencyCode, Double> getAll() {
        List<JsonNode> jsonNodeList;
        URL url;
        try {
            url = new URL(currencyNbuUrl);
        } catch (IOException e) {
            LOG.error("Error create URL NBU rate", e);
            throw new RuntimeException("Error create URL NBU rate", e);
        }
        try {
            jsonNodeList = OBJECT_MAPPER.readValue(url, new TypeReference<List<JsonNode>>() {
            });
        } catch (IOException e) {
            LOG.error("Error read NBU rate value ", e);
            throw new RuntimeException("Error read NBU rate value", e);
        }

        Map<CurrencyCode, Double> currencyMap = new HashMap<>();
        for (JsonNode jsonNode : jsonNodeList) {
            JsonNode cc = jsonNode.get("cc");
            if (CurrencyCode.contains(cc.asText())) {
                JsonNode rate = jsonNode.get("rate");
                currencyMap.put(CurrencyCode.getCurrencyByCode(cc.asText()), rate.asDouble());
            }
        }
        return currencyMap;
    }
}
