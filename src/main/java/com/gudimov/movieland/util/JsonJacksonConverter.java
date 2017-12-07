package com.gudimov.movieland.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class JsonJacksonConverter {
    private static final Logger LOG = LoggerFactory.getLogger(JsonJacksonConverter.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static <T> String itemToJson(T item) {
        try {
            return OBJECT_MAPPER.writeValueAsString(item);
        } catch (JsonProcessingException e) {
            LOG.error("Error convert item to json", e);
            throw new RuntimeException("Error convert to json", e);
        }
    }
}
