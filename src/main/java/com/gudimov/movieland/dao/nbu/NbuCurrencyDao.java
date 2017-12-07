package com.gudimov.movieland.dao.nbu;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gudimov.movieland.dao.CurrencyDao;
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
        List<JsonNode> jsonNodeList = null;
        URL url = null;
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
