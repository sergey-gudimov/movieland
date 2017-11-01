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
    // thread-safe
    private ObjectMapper objectMapper = new ObjectMapper();

    public <T>  String parseMovieToJson(T  item){
        log.info("Start parsing item to json {}", item);
        String movieJson = parseValueToJson(item);
        log.info("Movie {} is received.", item);
        return movieJson;
    }

    private <T> String parseValueToJson( T item) {
        ObjectMapper objectMapper = new ObjectMapper();
        String itemJson = null;
        try {
             itemJson = objectMapper.writeValueAsString(item);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return itemJson;
    }
}
