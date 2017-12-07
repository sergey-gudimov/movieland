package com.gudimov.movieland.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class JsonJacksonConverter {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public <T> String ItemToJson(T item) {

        LOG.info("Start parsing item to json {}", item);
        String itemJson = null;
        try {
            itemJson = objectMapper.writeValueAsString(item);
        } catch (JsonProcessingException e) {
            LOG.error("Error convert to json ", e);
        }
        LOG.info("Item {} is received.", item);
        return itemJson;
    }
}
