package com.gudimov.movieland.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by dp-ptcstd-15 on 10/30/2017.
 */
@Service
public class JsonJacksonConverter {
    private final Logger log = LoggerFactory.getLogger(getClass());

    static ObjectMapper  objectMapper = new ObjectMapper();

    public <T> String parseItemToJson(T item) {

        log.info("Start parsing item to json {}", item);
        String itemJson = null;
        try {
             itemJson = objectMapper.writeValueAsString(item);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        log.info("Item {} is received.", item);
        return itemJson;
    }
}
