package com.example.productsapiexample.exception.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Error {
    private String message;
    private String info;
}
