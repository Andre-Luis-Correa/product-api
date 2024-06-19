package com.example.productsapiexample.exception.config;

import com.example.productsapiexample.exception.type.EntityWasNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(EntityWasNotFoundException.class)
    public  ResponseEntity<Error> handleEntityNotFoundException(EntityWasNotFoundException e){
        Error error = new Error("A entidade não foi encontrada", e.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
}
