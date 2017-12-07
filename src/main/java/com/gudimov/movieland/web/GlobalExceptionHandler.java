package com.gudimov.movieland.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.gudimov.movieland.util.JsonJacksonConverter.itemToJson;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<?> handlerException(JsonProcessingException e){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR );
    }


}
