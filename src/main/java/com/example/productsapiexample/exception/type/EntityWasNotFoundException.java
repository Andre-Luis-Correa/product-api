package com.example.productsapiexample.exception.type;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntityWasNotFoundException extends RuntimeException {

    private String className;

    public EntityWasNotFoundException(String className){
        super();
        this.className = className;
    }
}
