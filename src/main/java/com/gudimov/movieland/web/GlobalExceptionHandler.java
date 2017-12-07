package com.gudimov.movieland.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<?> handlerException(RuntimeException e) {
        String json = null;
        try {
            json = OBJECT_MAPPER.writeValueAsString(e.getMessage());
        } catch (JsonProcessingException e1) {
            e1.printStackTrace();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("JsonHeader", MediaType.APPLICATION_JSON_UTF8_VALUE);
        return new ResponseEntity<>(json, headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
